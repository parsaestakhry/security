package com.parsa.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloConteoller {
    @GetMapping("")
    public String greet() {
        return "Hellooooo";

    }
}
