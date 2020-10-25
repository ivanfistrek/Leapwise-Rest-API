package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

@RestController
public class Vjezba {

    @RequestMapping("/boot/")
    public static void main(String[] args)
    {
        String myString = "A lot of people got infected by the Covid19 virus.";
        List<String> myWords = Arrays.asList("Covid19");

        int index = 0;
        int result = -1; // uvijek vraca rezultat u slucaju nulla
        String matchWord = null;

        StringTokenizer token = new StringTokenizer(myString, " ", true);

        while(result < 0 && token.hasMoreElements())
        {
            String nextString = token.nextToken();

            if(myWords.contains(nextString))
            {
                result = index;
                matchWord = nextString;
            }
            else
            {
                index += nextString.length();
            }
        }

        if(matchWord == null)
        {
            System.out.println("Not found. Nothing.");
        }
        else
        {
            System.out.println("Found: " + matchWord + " at index: " + result);
        }
    }
}
