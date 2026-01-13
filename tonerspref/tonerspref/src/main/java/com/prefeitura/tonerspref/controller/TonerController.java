package com.prefeitura.tonerspref.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.prefeitura.tonerspref.Model.DataBase.services.PrinterService;
import com.prefeitura.tonerspref.Model.DataBase.services.TonerService;
import com.prefeitura.tonerspref.Model.entities.Toner;

@Controller
public class TonerController {

    @Autowired
    private TonerService tonerService;

    @Autowired
    private PrinterService printerService;

    @GetMapping("/toners")
    public ModelAndView viewTonersPage() {
        ModelAndView mv = new ModelAndView("toners");
        mv.addObject("toners", tonerService.findAll());
        return mv;
    }

    @GetMapping("/inserirToner")
    public ModelAndView viewInserirTonerPage() {

        ModelAndView mv = new ModelAndView("inserirToner");
        mv.addObject("printers", printerService.findAll());

        return mv;
    }

    @PostMapping("/toners/salvar")
    public ModelAndView inserirToner(
        @RequestParam String modelo,
        @RequestParam int quantidade,
        @RequestParam List<Long> printerIds
    ) {

        Toner toner = new Toner(modelo, quantidade);

        if (printerIds != null && !printerIds.isEmpty()) {
            tonerService.salvarComImpressoras(toner, printerIds);
        } else {
            tonerService.insert(toner); 
        }
        return new ModelAndView("redirect:/toners");
        
    }

    @PostMapping("/toners/atualizarQuantidade")
    public ModelAndView atualizarQuantidadeToner(
        @RequestParam Long id,
        @RequestParam int quantidade
    ) {
        Toner toner = tonerService.findById(id);
        if (toner != null) {
            toner.setQuantity(quantidade);
            tonerService.update(toner);
        }
        return new ModelAndView("redirect:/toners");
    }

    @PostMapping("/toners/deletar")
    public ModelAndView deletarToner(@RequestParam Long id) {
        tonerService.delete(id);
        return new ModelAndView("redirect:/toners");
    }

    @PostMapping("/toners/diminuir")
    @ResponseBody
    public Integer diminuirQuantidadeToner(
        @RequestParam Long id
    ) {
        Toner toner = tonerService.findById(id);

        if (toner != null) {
            int novaQuantidade = toner.getQuantity() - 1;
            if (novaQuantidade < 0) {
                novaQuantidade = 0;
            }
            toner.setQuantity(novaQuantidade);
            tonerService.update(toner);
            return novaQuantidade;
        }
        return null;
    }
}
