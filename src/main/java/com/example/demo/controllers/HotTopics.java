package com.example.demo.controllers;

import com.example.demo.entities.RSSFeed;
import com.example.demo.interfaces.HotTopicsRepository;
import com.example.demo.services.HotTopicsService;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.hibernate.usertype.UserType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.feed.RssChannelHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@RestController
public class HotTopics {

    @Autowired
    private HotTopicsService hotTopicsService;

    @RequestMapping("/analyse/new")
    public List<String> hotTopics()
    {
        return hotTopicsService.XMLToJson();
    }

}
