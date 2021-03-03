package testDaily;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestTest {

    public static void main(String[] args) {

        String token = "747bb40fdd3bd5683926ae848c5248bc1f4a1a23eb22f1dd12ecbe9311cd4273";      //API Token relativo al mio account

        try{

            //Prova per la creazione di una room
            URL url = new URL("https://api.daily.co/v1/rooms");     //Endpoint per la creazione delle room
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("connection", "keep-alive");
            con.setRequestProperty("Authorization", "Bearer "+ token);
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            Gson g = new Gson();
            String jsonInputString = g.toJson(new Properties("test-room-7717", "private"));
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

            //Prova per l'ottenimento di un token


        }catch(Exception e){
            e.printStackTrace();
        }


    }

}
