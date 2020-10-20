package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OccuranceFrequency {

    @RequestMapping("/frequency/{id}")
    public String occuranceFrequency()
    {
        return "Ovo je frekvencija prikazivanja!";
    }
}
