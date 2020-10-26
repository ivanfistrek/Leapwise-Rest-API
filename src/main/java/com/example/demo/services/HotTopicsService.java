package com.example.demo.services;

import com.example.demo.entities.RSSFeed;
import com.example.demo.interfaces.HotTopicsRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.feed.RssChannelHttpMessageConverter;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotTopicsService {

    @Autowired
    HotTopicsRepository hotTopicsRepository;

    public List<RSSFeed> getAllHotTopics() {
        List<RSSFeed> hotTopics = new ArrayList<RSSFeed>();
        hotTopicsRepository.findAll().forEach(hotTopic -> hotTopics.add(hotTopic));
        return hotTopics;
    }

    public RSSFeed getHotTopicsById(Long id) {
        return hotTopicsRepository.findById(id).get();
    }

    public List<String> XMLToJson()
    {
        String xmlString = readURLToString("https://news.google.com/rss?cf=all&hl=en-US&pz=1&gl=US&ceid=US:en");
        JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
        JSONArray jsonArray = xmlJSONObj.getJSONObject("rss").getJSONObject("channel").getJSONArray("item");
        String jsonPrettyPrintString = jsonArray.toString(4); // json pretty print
        //System.out.println(jsonPrettyPrintString);

        String titlesFound;
        String hotTopicCovid = "Covid";
        String hotTopicTrump = "Trump";
        List<String> matchesFound = new ArrayList<>();

        for (Object value:jsonArray) {
            if(value instanceof JSONObject) {
                titlesFound = ((JSONObject) value).getString("title");
                if(titlesFound.contains(hotTopicCovid) || titlesFound.contains(hotTopicTrump)) {

                    System.out.println(((JSONObject) value).getString("title"));
                    matchesFound.add(((JSONObject) value).getString("title"));
                }
            }
        }
        return matchesFound;
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
