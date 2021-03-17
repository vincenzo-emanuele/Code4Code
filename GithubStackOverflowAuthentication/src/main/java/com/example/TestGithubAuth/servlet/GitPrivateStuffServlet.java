package com.example.TestGithubAuth.servlet;

import com.example.TestGithubAuth.jsonwrappers.RepoWrapper;
import com.example.TestGithubAuth.jsonwrappers.Token;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "privateStuff", value = "/private-stuff")
public class GitPrivateStuffServlet extends HttpServlet {

    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        String jsonRepos = "";
        String token = (String) request.getSession().getAttribute("token");
        Gson g = new Gson();
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            Map<String, String> env = System.getenv();
            String client_secret = env.get("GITHUBCLIENTSECRET");

            if(token == null) {
                //Richiedo il token
                HttpPost httpPost = new HttpPost("https://github.com/login/oauth/access_token");
                ArrayList<NameValuePair> postParameters = new ArrayList<>();
                //client_id della mia applicazione
                postParameters.add(new BasicNameValuePair("client_id", "cba2d4eee4f6df798aec"));
                //codice privato della mia applicazione
                postParameters.add(new BasicNameValuePair("client_secret", client_secret));
                //codice temporaneo generato dalla richiesta di autenticazione
                postParameters.add(new BasicNameValuePair("code", request.getParameter("code")));
                httpPost.setEntity(new UrlEncodedFormEntity(postParameters, StandardCharsets.UTF_8));
                httpPost.setHeader("accept", "application/json");

                try (CloseableHttpResponse response1 = httpclient.execute(httpPost)) {

                    HttpEntity entity1 = response1.getEntity();
                    String jsonToken = EntityUtils.toString(entity1, "UTF-8");
                    System.out.println(jsonToken);
                    Token t = g.fromJson(jsonToken, Token.class);
                    token = t.getAccess_token();
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("token", token);
                    EntityUtils.consume(entity1);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            /*
            * Ottengo la lista di repo pubbliche e private di un utente (posso accedere a quelle private
            * grazie al token ottenuto nella richiesta precedente
            * */
            HttpGet httpGet = new HttpGet("https://api.github.com/user/repos");
            httpGet.setHeader("Authorization", "token " + token);
            System.out.println("TOKEN " + token);
            try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
                HttpEntity entity1 = response1.getEntity();
                jsonRepos = EntityUtils.toString(entity1, "UTF-8");
                EntityUtils.consume(entity1);

            } catch (Exception e) {
                e.printStackTrace();
            }

            //RepoWrapper è un wrapper per le repo avente solo le informazioni che servono per questo test
            RepoWrapper[] rw = g.fromJson(jsonRepos, RepoWrapper[].class);
            HashSet<String> languages = new HashSet<>();

            /* Estraggo il nome di ogni repo ottenuta (comprensivo di autore) per ottenere i linguaggi
            usati in quella repo */

            for(int i = 0; i < rw.length; i++){
                String languagesEndpoint = "https://api.github.com/repos/" + rw[i].getFull_name() + "/languages";
                HttpGet httpGet1 = new HttpGet(languagesEndpoint);
                httpGet1.setHeader("accept", "application/json");
                httpGet1.setHeader("Authorization", "token " + token);
                try (CloseableHttpResponse response1 = httpclient.execute(httpGet1)) {
                    HttpEntity entity1 = response1.getEntity();
                    String jsonLanguage = EntityUtils.toString(entity1, "UTF-8");
                    JsonObject obj = JsonParser.parseString(jsonLanguage).getAsJsonObject();
                    Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();
                    for(Map.Entry<String, JsonElement> entry: entries) {
                        languages.add(entry.getKey());
                    }
                    EntityUtils.consume(entity1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<a href=http://localhost:8080/GithubStackOverflowAuthentication_war_exploded>Home</a>");
            out.println("<h1>Linguaggi usati nelle repo: " + languages + "</h1>");
            out.println("</body></html>");
        }

    }
}


