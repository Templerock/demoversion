package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    @GetMapping("/")
    public ModelAndView index() {
        Map map = new HashMap();
        map.put("name","Привет Гость");
        return new ModelAndView("hello", map);
    }
}
