package com.vincenzoemanuele.code4code.nlp;
import com.google.gson.Gson;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.net.URIBuilder;

import java.util.ArrayList;

public class NLPTester {

    public static void main(String[] args){

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            URIBuilder builder = new URIBuilder("http://127.0.0.1:5000/nlp");
            ArrayList<String> technologies = new ArrayList<>();
            technologies.add("java");
            //technologies.add("javascript");
            //technologies.add("react");
            Gson gson = new Gson();
            System.out.println(gson.toJson(technologies));
            //builder.setParameter("technologies", technologies);
            builder.setParameter("technologies", gson.toJson(technologies));
            HttpGet httpGet = new HttpGet(builder.build());
            CloseableHttpResponse response = httpclient.execute(httpGet);
            System.out.println(response);
            HttpEntity entity = response.getEntity();
            String similarity = EntityUtils.toString(entity, "UTF-8");
            System.out.println(similarity);
        } catch (Exception e){
            System.out.println(e);
        }

    }

}
