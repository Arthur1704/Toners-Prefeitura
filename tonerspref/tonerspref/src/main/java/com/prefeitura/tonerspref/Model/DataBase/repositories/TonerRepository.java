package com.prefeitura.tonerspref.Model.DataBase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prefeitura.tonerspref.Model.entities.Toner;

@Repository
public interface TonerRepository extends JpaRepository<Toner, Long>{

}
