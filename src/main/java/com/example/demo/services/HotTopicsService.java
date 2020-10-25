package com.example.demo.services;

import com.example.demo.entities.RSSFeed;
import com.example.demo.interfaces.HotTopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.feed.RssChannelHttpMessageConverter;
import org.springframework.stereotype.Service;

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
}
