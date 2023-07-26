package com.example.spring.with.jwt.token.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Balance_Controller {


    @GetMapping("/yourbalance")
    public String DisplayBalance()
    {
        return "Here are the balance details";
    }
}
