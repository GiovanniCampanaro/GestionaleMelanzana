package com.mycompany.app;
/*
Creare una applicazione Java che consenta di visualizzare le condizioni meteo della città di
Milano. Per poterlo fare è necessario accedere ai servizi di https://openweathermap.org/api
previa registrazione (attenzione che vi inviano una email contenente api key per effettuare le
        richieste web).
L’applicazione deve visualizzare le seguenti informazioni:
Nome città
Temperatura in °C
        Umidità
Sintesi (esempio “nuvoloso”, “temporale”, “bufera”)

• Le coordinate della città di Milano sono: latitudine = 45.464664 longitudine = 9.188540

API KEY: e620c7bc8d268e5bfdd2c3a01b069621
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Main {
    private static final String API_KEY = "e620c7bc8d268e5bfdd2c3a01b069621"; // Sostituire con la tua API Key
    private static final String CITY = "Milano";
    private static final String URL_STRING = "http://api.openweathermap.org/data/2.5/weather?q=" + CITY + "&appid=" + API_KEY + "&units=metric&lang=it";

    public static void main(String[] args) {
        try {
            // Creazione dell'URL
            URL url = new URL(URL_STRING);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Lettura della risposta
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Chiusura delle connessioni
            in.close();
            connection.disconnect();

            // Parsing del JSON
            JSONObject json = new JSONObject(content.toString());

            String cityName = json.getString("name");
            double temperature = json.getJSONObject("main").getDouble("temp");
            int humidity = json.getJSONObject("main").getInt("humidity");
            String description = json.getJSONArray("weather").getJSONObject(0).getString("description");

            // Stampa delle informazioni meteo
            System.out.println("Nome città: " + cityName);
            System.out.println("Temperatura: " + temperature + " °C");
            System.out.println("Umidità: " + humidity + "%");
            System.out.println("Sintesi: " + description);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
