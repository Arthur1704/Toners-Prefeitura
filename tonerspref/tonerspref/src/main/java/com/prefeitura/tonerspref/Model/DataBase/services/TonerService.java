package com.prefeitura.tonerspref.Model.DataBase.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.prefeitura.tonerspref.Model.DataBase.repositories.PrinterRepository;
import com.prefeitura.tonerspref.Model.DataBase.repositories.TonerRepository;
import com.prefeitura.tonerspref.Model.entities.Printer;
import com.prefeitura.tonerspref.Model.entities.Toner;

@Service
public class TonerService {

    @Autowired
    TonerRepository tonerRepository;

    @Autowired
    private PrinterRepository printerRepository;

    public void insert(Toner toner){
        try{
        tonerRepository.save(toner);
        } catch (DataAccessException e) {
            System.out.println("Erro ao inserir toner: " + e.getMessage());
        }
    }

    public void delete(Long id) {
        try{
        tonerRepository.deleteById(id);
        } catch (DataAccessException e) {
            System.out.println("Erro ao deletar toner: " + e.getMessage());
        }
    }

    public Toner findById(Long id) {
        try{
        return tonerRepository.findById(id).orElse(null);
        } catch (DataAccessException e) {
            System.out.println("Erro ao buscar toner: " + e.getMessage());
            return null;
        }
    }

    public List<Toner> findAll() {
        try{
        return tonerRepository.findAll();
        } catch (DataAccessException e) {
            System.out.println("Erro ao buscar toners: " + e.getMessage());
            return null;
        }
    }

    public void update(Toner toner) {
        try{
        tonerRepository.save(toner);
        } catch (DataAccessException e) {
            System.out.println("Erro ao atualizar toner: " + e.getMessage());
        }
    }   

    public void salvarComImpressoras(Toner toner, List<Long> printerIds) {

        List<Printer> printers = printerRepository.findAllById(printerIds);

        toner.setPrinters(printers);

        tonerRepository.save(toner);
    }

    public List<Toner> findAllWithPrinters() {
        return tonerRepository.findAllWithPrinters();
    }


    public void atualizarQuantidade(Long id, int quantidade) {
        Toner toner = tonerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Toner não encontrado"));

        toner.setQuantity(quantidade);
        tonerRepository.save(toner);
    }


}
