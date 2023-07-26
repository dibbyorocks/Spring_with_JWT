package com.example.spring.with.jwt.token.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Contacts_Controller {
    @GetMapping("/contact")
    public String contactDetails()
    {
        return "following are your details";
    }
}
