package com.hiring.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Theodore on 7/7/2017.
 */
@Controller
public class HelloWorldController {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "John Doe");
        return "welcome";
    }
}
