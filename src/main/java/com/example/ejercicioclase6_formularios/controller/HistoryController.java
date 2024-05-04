package com.example.ejercicioclase6_formularios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/history")
public class HistoryController {

    @GetMapping(value = {"","/"})
    public String historialEmpleado(){
        //COMPLETAR
        return "history/lista";
    }



}
