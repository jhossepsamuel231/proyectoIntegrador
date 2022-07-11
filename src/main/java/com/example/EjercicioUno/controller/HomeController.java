/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.controller;

import com.example.EjercicioUno.dto.PersonaDto;
import com.example.EjercicioUno.entity.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP
 */
@Controller
public class HomeController {
    @GetMapping
    public String inicio(){
        return "inicio";
    }
    
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("usuario", new Usuario());
        return "login";
    }
    
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("personaDto", new PersonaDto());
        return "register";
    }
}
