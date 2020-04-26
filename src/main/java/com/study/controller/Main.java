package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Main {

    @GetMapping("/")
    public String main(@RequestParam(required = false, defaultValue = "User") String name, Model model) {
        model.addAttribute("name", name);
        return "main";
    }
}
