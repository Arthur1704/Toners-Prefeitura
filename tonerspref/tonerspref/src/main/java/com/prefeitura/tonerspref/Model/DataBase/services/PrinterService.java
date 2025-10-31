package com.prefeitura.tonerspref.Model.DataBase.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.prefeitura.tonerspref.Model.DataBase.repositories.PrinterRepository;
import com.prefeitura.tonerspref.Model.entities.Printer;

@Service
public class PrinterService {

    @Autowired
    PrinterRepository printerRepository;
    
    public void insert(Printer printer){
        try{
            printerRepository.save(printer);
        }
        catch(DataAccessException e){
            System.out.println("Erro ao inserir impressora: " + e.getMessage());
        }
    }

    public void update(Printer printer){
        try{
            printerRepository.save(printer);
        }
        catch(DataAccessException e){
            System.out.println("Erro ao atualizar impressora: " + e.getMessage());
        }
    }


    public void delete(Long id){
        try{
            printerRepository.deleteById(id);
        }
        catch(DataAccessException e){
            System.out.println("Erro ao deletar impressora: " + e.getMessage());
        }
    }

    public Printer findById(Long id){
        try{
            return printerRepository.findById(id).orElse(null);
        }
        catch(DataAccessException e){
            System.out.println("Erro ao buscar impressora: " + e.getMessage());
            return null;
        }
    }

    public List<Printer> findAll(){
        try{
            return printerRepository.findAll();
        }
        catch(DataAccessException e){
            System.out.println("Erro ao buscar impressoras: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
