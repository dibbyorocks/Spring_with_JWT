package com.example.spring.with.jwt.token.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Notice_Controller {
    @GetMapping("/notices")
    public String DisplayNotice()
    {
        return "here are the current notices";
    }
}
