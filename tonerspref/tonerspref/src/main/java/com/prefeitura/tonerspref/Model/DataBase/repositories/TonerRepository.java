package com.prefeitura.tonerspref.Model.DataBase.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prefeitura.tonerspref.Model.entities.Toner;

@Repository
public interface TonerRepository extends JpaRepository<Toner, Long>{

     @Query("""
        SELECT DISTINCT t
        FROM Toner t
        LEFT JOIN FETCH t.printers
        ORDER BY t.id
    """)
    List<Toner> findAllWithPrinters();

}
