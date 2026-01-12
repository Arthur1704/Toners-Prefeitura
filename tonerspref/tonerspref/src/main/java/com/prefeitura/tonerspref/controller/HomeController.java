package com.prefeitura.tonerspref.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prefeitura.tonerspref.Model.DataBase.services.TonerService;

@Controller
public class HomeController {

    @Autowired
    private TonerService tonerService;
   

    @GetMapping("/index")
    public ModelAndView viewHomePage() {
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView viewPageHome() {

        ModelAndView mv = new ModelAndView("pageHome");
        mv.addObject("toners", tonerService.findAllWithPrinters());
        return mv;
    }

    
}