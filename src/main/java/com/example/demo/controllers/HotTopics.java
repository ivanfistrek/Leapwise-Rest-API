package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotTopics {

    @RequestMapping("/analyse/new")
    public String hotTopics()
    {
        return "Ovo je controller za Hot Topics iz RSS feeda!";
    }
}
