package com.prefeitura.tonerspref.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.prefeitura.tonerspref.Model.DataBase.services.UserService;

@Controller
public class AuthController {

     @Autowired
    private UserService loginDB;


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

}
