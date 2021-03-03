package testDaily;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestTest {

    public static void main(String[] args) {

        String token = "747bb40fdd3bd5683926ae848c5248bc1f4a1a23eb22f1dd12ecbe9311cd4273";      //API Token relativo al mio account

        try {

            //Prova per la creazione di una room
            URL roomUrl = new URL("https://api.daily.co/v1/rooms");     //Endpoint per la creazione delle room
            HttpURLConnection roomConnection = (HttpURLConnection) roomUrl.openConnection();
            roomConnection.setDoOutput(true);
            roomConnection.setDoInput(true);
            roomConnection.setRequestMethod("POST");
            roomConnection.setRequestProperty("connection", "keep-alive");
            roomConnection.setRequestProperty("Authorization", "Bearer " + token);
            roomConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            roomConnection.setRequestProperty("Accept", "application/json");
            Gson g = new Gson();
            String jsonInputStringRoom = g.toJson(new CreateRoomBody("test-room", "private"));
            try (OutputStream os = roomConnection.getOutputStream()) {
                byte[] input = jsonInputStringRoom.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(roomConnection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

            //Prova per l'ottenimento di un token
            URL tokenUrl = new URL("https://api.daily.co/v1/meeting-tokens");
            HttpURLConnection tokenConnection = (HttpURLConnection) tokenUrl.openConnection();
            tokenConnection.setDoOutput(true);
            tokenConnection.setDoInput(true);
            tokenConnection.setRequestMethod("POST");
            tokenConnection.setRequestProperty("connection", "keep-alive");
            tokenConnection.setRequestProperty("Authorization", "Bearer " + token);
            tokenConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            tokenConnection.setRequestProperty("Accept", "application/json");
            String jsonInputStringToken = g.toJson(new TokenPropertiesWrapper(new TokenProperties(true, "Enzo", "test-room")));
            try (OutputStream os = tokenConnection.getOutputStream()) {
                byte[] input = jsonInputStringToken.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(tokenConnection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

            //Prova per l'eliminazione di una room
            URL deleteRoomUrl = new URL("https://api.daily.co/v1/rooms/test-room");     //Endpoint per la creazione delle room
            HttpURLConnection deleteRoomConnection = (HttpURLConnection) deleteRoomUrl.openConnection();
            deleteRoomConnection.setDoOutput(true);
            deleteRoomConnection.setDoInput(true);
            deleteRoomConnection.setRequestMethod("DELETE");
            deleteRoomConnection.setRequestProperty("connection", "keep-alive");
            deleteRoomConnection.setRequestProperty("Authorization", "Bearer " + token);
            deleteRoomConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(deleteRoomConnection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
