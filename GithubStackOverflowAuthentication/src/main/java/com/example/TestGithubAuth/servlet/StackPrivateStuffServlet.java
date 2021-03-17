package com.example.TestGithubAuth.servlet;

import com.example.TestGithubAuth.jsonwrappers.Item;
import com.example.TestGithubAuth.jsonwrappers.Question;
import com.example.TestGithubAuth.jsonwrappers.Token;
import com.google.gson.Gson;
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
import java.util.*;

@WebServlet(name = "privateStuffStack", value = "/private-stuff-stack")
public class StackPrivateStuffServlet extends HttpServlet {

    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        Gson g = new Gson();
        List<String> questionTags = new ArrayList<>();
        List<String> answerTags = new ArrayList<>();
        String code = request.getParameter("code");
        String token = (String) request.getSession().getAttribute("tokenStack");

            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

                Map<String, String> env = System.getenv();
                String client_secret = env.get("STACKOVERFLOWCLIENTSECRET");

                if(token == null) {

                    HttpPost httpPost = new HttpPost("https://stackoverflow.com/oauth/access_token/json");
                    ArrayList<NameValuePair> postParameters = new ArrayList<>();
                    //client_id della mia applicazione
                    postParameters.add(new BasicNameValuePair("client_id", "19786"));
                    //codice privato della mia applicazione
                    postParameters.add(new BasicNameValuePair("client_secret", client_secret));
                    //codice temporaneo generato dalla richiesta di autenticazione
                    postParameters.add(new BasicNameValuePair("code", code));
                    postParameters.add(new BasicNameValuePair("redirect_uri", "http://localhost:8080/GithubStackOverflowAuthentication_war_exploded/private-stuff-stack"));
                    httpPost.setEntity(new UrlEncodedFormEntity(postParameters, StandardCharsets.UTF_8));
                    httpPost.setHeader("accept", "application/json");

                    try (CloseableHttpResponse response1 = httpClient.execute(httpPost)) {

                        HttpEntity entity1 = response1.getEntity();
                        String jsonToken = EntityUtils.toString(entity1, "UTF-8");
                        System.out.println("JSON TOKEN " + jsonToken);
                        Token t = g.fromJson(jsonToken, Token.class);
                        token = t.getAccess_token();
                        HttpSession httpSession = request.getSession();
                        httpSession.setAttribute("tokenStack", token);
                        EntityUtils.consume(entity1);

                    } catch (Exception e) {

                        e.printStackTrace();

                    }

                }

                //Ottengo le domande dell'utente autenticato
                HttpGet httpGet = new HttpGet("https://api.stackexchange.com/2.2/me/questions?site=stackoverflow");
                ArrayList<NameValuePair> getParameters = new ArrayList<>();
                getParameters.add(new BasicNameValuePair("access_token", token));
                getParameters.add(new BasicNameValuePair("key", "j0vHrc8NJ3F4QvirfUCXJA(("));
                httpGet.setEntity(new UrlEncodedFormEntity(getParameters, StandardCharsets.UTF_8));
                try (CloseableHttpResponse response1 = httpClient.execute(httpGet)) {
                    HttpEntity entity1 = response1.getEntity();
                    String res = EntityUtils.toString(entity1, "UTF-8");
                    System.out.println(res);
                    EntityUtils.consume(entity1);
                    Question q = g.fromJson(res, Question.class);
                    System.out.println(q);
                    for(Item item : q.getItems()){
                        for(String s : item.getTags()){
                            questionTags.add(s);
                            System.out.println("Tag: " + s);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                //Ottengo le risposte dell'utente autenticato
                httpGet = new HttpGet("https://api.stackexchange.com/2.2/me/answers?site=stackoverflow");
                getParameters = new ArrayList<>();
                getParameters.add(new BasicNameValuePair("access_token", token));
                getParameters.add(new BasicNameValuePair("key", "j0vHrc8NJ3F4QvirfUCXJA(("));
                httpGet.setEntity(new UrlEncodedFormEntity(getParameters, StandardCharsets.UTF_8));
                try (CloseableHttpResponse response1 = httpClient.execute(httpGet)) {
                    HttpEntity entity1 = response1.getEntity();
                    String res = EntityUtils.toString(entity1, "UTF-8");
                    System.out.println(res);
                    EntityUtils.consume(entity1);
                    Question q = g.fromJson(res, Question.class);
                    System.out.println(q);
                    for(Item item : q.getItems()){
                        for(String s : item.getTags()){
                            answerTags.add(s);
                            System.out.println("Tag: " + s);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<a href=http://localhost:8080/GithubStackOverflowAuthentication_war_exploded>Home</a>");
        out.println("<h1>Tag delle domande: " + questionTags + "</h1>");
        out.println("<h1>Tag delle risposte: " + answerTags + "</h1>");
        out.println("</body></html>");

    }


}
