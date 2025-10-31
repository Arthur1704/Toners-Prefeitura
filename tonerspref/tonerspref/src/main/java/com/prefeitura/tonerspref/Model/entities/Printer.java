package com.prefeitura.tonerspref.Model.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "printers")
public class Printer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;

    @ManyToMany(mappedBy = "printers")
    private List<Toner> toners = new ArrayList<>();

    public Printer() {
    }

    public Printer(String model) {
        this.model = model;
    }

    public Printer(String model, List<Toner> toners) {
        this.model = model;
        this.toners = toners;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Toner> getToners() {
        return toners;
    }

    public void addToners(Toner toners) {
        this.toners.add(toners);
    }

    
}
