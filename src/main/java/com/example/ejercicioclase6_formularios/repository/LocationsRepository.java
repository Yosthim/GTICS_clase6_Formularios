package com.example.ejercicioclase6_formularios.repository;

import com.example.ejercicioclase6_formularios.entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationsRepository extends JpaRepository<Locations,Integer> {
}
