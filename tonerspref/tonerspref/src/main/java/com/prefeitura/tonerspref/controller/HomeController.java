package com.prefeitura.tonerspref.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.prefeitura.tonerspref.Model.DataBase.services.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService loginDB;;

    @GetMapping("/")
    public ModelAndView viewHomePage() {
        return new ModelAndView("index");
    }

    @PostMapping("/login")
    public ModelAndView logar(@RequestParam String name, @RequestParam String password) {
        if (loginDB.validateLogin(name, password)) {
            ModelAndView mv = new ModelAndView("pageHome");
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("index");
            mv.addObject("error", "Invalid credentials");
            return mv;
        }
    }

    @GetMapping("/toners")
    public ModelAndView viewTonersPage() {
        return new ModelAndView("toners");
    }

}
