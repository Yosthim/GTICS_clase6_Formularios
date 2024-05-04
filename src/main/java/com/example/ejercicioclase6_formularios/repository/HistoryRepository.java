package com.example.ejercicioclase6_formularios.repository;

import com.example.ejercicioclase6_formularios.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {

    //COMPLETAR

}
