package com.prefeitura.tonerspref.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.prefeitura.tonerspref.Model.DataBase.services.PrinterService;
import com.prefeitura.tonerspref.Model.entities.Printer;

@Controller
public class PrinterController {

    @Autowired
    private PrinterService printerService;

    @GetMapping("/printer")
    public ModelAndView viewPrinterPage() {

        ModelAndView mv = new ModelAndView("printer");
        mv.addObject("printers", printerService.findAll());
        return mv;
    }   

    @GetMapping("/inserirPrinter")
    public ModelAndView viewInserirPrinterPage() {
        return new ModelAndView("inserirPrinter");
    }

    @PostMapping("/printer/salvar")
    public ModelAndView inserirPrinter(@RequestParam String modelo) {
        printerService.insert(new Printer(modelo));
        return new ModelAndView("redirect:/printer");
        
    }
}
