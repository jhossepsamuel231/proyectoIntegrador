/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.controller;

import com.example.EjercicioUno.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping("/principal/menu/gerencia")
public class GerenciaController {
    
    @Autowired
    private SolicitudService solicitudService;
    
    
    @GetMapping
    public String menuGerencia(){
        return "menu/gerencia";
    }
    
    @GetMapping("/derivar")
    public String derivarRUOS(Model model){
        model.addAttribute("listarSolicitudGerente", solicitudService.listarInformeParaGerente());
        return "gerencia/derivar-solicitudes";
    }
    
    @GetMapping("/derivarRUOS/{idSolicitud}")
    public String derivarSolicitudRUOS(Model model, @PathVariable("idSolicitud") Long idSolicitud){
       solicitudService.actualizarsolicitud(idSolicitud, "desarrollo");
        return "redirect:/principal/menu/gerencia/derivar";
    }
    
    
       
    @GetMapping("/perfil")
    public String perfilGerencia(){
        return "gerencia/perfil";
    }
    
    @GetMapping("/subirExpediente")
    public String generarExpdiente(){
        return "gerencia/subir-expediente";
    }
    
    
    @GetMapping("/crearOrg")
    public String CrearOrg(){
        return "gerencia/Crear-Organizacion";
    }
    
    @GetMapping("/crearJunta")
    public String crearJunta(){
        return "gerencia/Crear-Junta";
    }
    
    @PostMapping("/logear")
    public String logearGerencia() {
        return "menu/gerencia";
    }
}
