package com.prefeitura.tonerspref.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

   

    @GetMapping("/")
    public ModelAndView viewHomePage() {
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView viewPageHome() {
        return new ModelAndView("pageHome");
    }

    
}