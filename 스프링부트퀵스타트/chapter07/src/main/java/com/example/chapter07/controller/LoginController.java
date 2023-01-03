package com.example.chapter07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{
    @GetMapping("/accessDenied")
    public void accessDenied() {

    }

    @GetMapping("/login")
    public void login() {

    }

    @GetMapping("/loginSuccess")
    public void loginSuccess() {

    }
}
