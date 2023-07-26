package com.example.spring.with.jwt.token.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Account_Controller {
    @GetMapping("/youraccount")
    public String getDisplayAccount()
    {
        return "display account details";
    }
}
