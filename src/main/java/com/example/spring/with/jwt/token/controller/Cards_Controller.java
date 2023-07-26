package com.example.spring.with.jwt.token.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cards_Controller {
    @GetMapping("/yourcards")
    public String DisplayCards()
    {
        return "Here are the card details";
    }
}
