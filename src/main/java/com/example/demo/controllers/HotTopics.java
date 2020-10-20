package com.example.demo.controllers;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class HotTopics {

    @RequestMapping("/analyse/new")
    public String hotTopics()
    {
        XMLToJson();
        return "Ovo je controller za Hot Topics iz RSS feeda!";
    }

    public void frequency(String json)
    {
        System.out.println(json);
    }

    public void XMLToJson()
    {
        String xmlString = readURLToString("https://news.google.com/rss?cf=all&hl=en-US&pz=1&gl=US&ceid=US:en");
        JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
        String jsonPrettyPrintString = xmlJSONObj.toString(4);
        frequency(jsonPrettyPrintString);
    }

    public String readURLToString(String url) {
        BufferedReader reader = null;
        String result = null;

        try {
            URL u = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setReadTimeout(2 * 1000);
            conn.connect();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            result = builder.toString();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try { reader.close(); } catch (IOException ignoreOnClose) { }
            }
        }
        return result;
    }
}
