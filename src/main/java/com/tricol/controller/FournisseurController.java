package com.tricol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FournisseurController {
    @GetMapping("/")
    public String index() {
        return "index"; // correspond à /webapp/views/index.jsp
    }
}

