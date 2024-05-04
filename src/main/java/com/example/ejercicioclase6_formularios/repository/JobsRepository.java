package com.example.ejercicioclase6_formularios.repository;

import com.example.ejercicioclase6_formularios.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, String> {
}
