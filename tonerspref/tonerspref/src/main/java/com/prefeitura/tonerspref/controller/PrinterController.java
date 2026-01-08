package com.prefeitura.tonerspref.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrinterController {

    @GetMapping("/printer")
    public ModelAndView viewPrinterPage() {
        return new ModelAndView("printer");
    }

    @GetMapping("/inserirPrinter")
    public ModelAndView viewInserirPrinterPage() {
        return new ModelAndView("inserirPrinter");
    }
}
