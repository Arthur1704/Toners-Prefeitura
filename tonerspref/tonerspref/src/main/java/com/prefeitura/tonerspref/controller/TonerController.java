package com.prefeitura.tonerspref.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.prefeitura.tonerspref.Model.DataBase.services.TonerService;
import com.prefeitura.tonerspref.Model.entities.Toner;

@Controller
public class TonerController {

    @Autowired
    private TonerService tonerService;

    @GetMapping("/toners")
    public ModelAndView viewTonersPage() {
        ModelAndView mv = new ModelAndView("toners");
        mv.addObject("toners", tonerService.findAll());
        return mv;
    }

    @GetMapping("/inserirToner")
    public ModelAndView viewInserirTonerPage() {
        return new ModelAndView("inserirToner");
    }

    @PostMapping("/toners/salvar")
    public ModelAndView inserirToner(@RequestParam String modelo, @RequestParam int quantidade) {
        tonerService.insert(new Toner(modelo, quantidade));
        return new ModelAndView("redirect:/toners");
    }
}
