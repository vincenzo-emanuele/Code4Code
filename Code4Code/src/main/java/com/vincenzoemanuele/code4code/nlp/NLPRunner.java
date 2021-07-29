package com.vincenzoemanuele.code4code.nlp;
import com.google.gson.Gson;
import com.vincenzoemanuele.code4code.nlp.beans.FrameworkWrapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.net.URIBuilder;

import java.lang.reflect.Array;
import java.util.*;

public class NLPRunner {

    public static List<List<Map.Entry<String, Double>>> getSuggestedFrameworks(List<String> technologies){

        //List<Map.Entry<String, Double>> suggestedFrameworks = new ArrayList<>();
        List<List<Map.Entry<String, Double>>> output = new ArrayList<>();

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            URIBuilder builder = new URIBuilder("http://127.0.0.1:5000/nlp");
            Gson gson = new Gson();
            builder.setParameter("technologies", gson.toJson(technologies));
            HttpGet httpGet = new HttpGet(builder.build());
            CloseableHttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String similarity = EntityUtils.toString(entity, "UTF-8");
            System.out.println(similarity);
            output = gson.fromJson(similarity, List.class);
            System.out.println(output);
        } catch (Exception e){
            e.printStackTrace();
        }

        return output;

    }

}
