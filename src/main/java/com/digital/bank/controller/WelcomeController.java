package com.digital.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String home() {
        return """
                <h1>Welcome to Digital Bank Rest API</h1>
                <p>Here you can do many requisitions to a bank prototype</p>
                
                <br>
                <p>I hope you have fun and self learning with this. Good studies!</p>
                <br>
                <p>Link to github repository: <a href="https://github.com" target="_blank">Github Repository Here</a></p>
                """;
    }
}
