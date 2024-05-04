package com.example.ejercicioclase6_formularios.repository;

import com.example.ejercicioclase6_formularios.entity.Departments;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments,Integer> {


}
