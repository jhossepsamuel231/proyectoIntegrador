/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.controller;

import com.example.EjercicioUno.entity.Solicitud;
import com.example.EjercicioUno.service.SolicitudService;
import com.example.EjercicioUno.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping("/principal/menu/subgerencia")
public class SubGerenciaController {

    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public String menu() {
        return "menu/sub-gerencia";
    }

    @GetMapping("/actualizacionesRUOS")
    public String registrarActualizaciones() {
        return "subgerencia/registrar-actualizaciones";
    }

    @GetMapping("/perfil")
    public String perfil() {
        return "subgerencia/perfil";
    }

    @GetMapping("/registrarRUOS")
    public String registrarRUOS(Model model) {
        model.addAttribute("listarSolicitud", solicitudService.listarSoliParaInformeTecnico());
        return "subgerencia/registrar-solicitud-ruos";
    }

    @GetMapping("/subirInformTecnico/{idSolicitud}")
    public String subirInformeTecnico(Model model, @PathVariable("idSolicitud") Long idsolicitud) {
        Solicitud solicitud = solicitudService.encontrarSolicitud(idsolicitud);
        model.addAttribute("solicitud", solicitud);
        return "subgerencia/subir-informe-tecnico";
    }

    @PostMapping("/logear")
    public String logearSubGerencia() {
        return "menu/sub-gerencia";
    }

    @PostMapping("/subiendoInfoTecnico")
    public String registrarInformeTecnico(@RequestParam("idSolicitud") Long idSolicitud,
            @RequestParam("informeTecnico") MultipartFile informeTecnico) {
        Solicitud solicitud = solicitudService.encontrarSolicitud(idSolicitud);
        String urlDoc = usuarioService.subirArchivos(informeTecnico);
        solicitud.setDocumentotecnico(urlDoc);
        solicitud.setEstadoSolicitud(3);
        solicitudService.actualizarInformeTecnico(solicitud);
        return "redirect:/principal/menu/subgerencia/registrarRUOS";
    }
}
