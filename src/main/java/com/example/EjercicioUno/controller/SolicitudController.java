/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.controller;

import com.example.EjercicioUno.dto.SolicitudDto;
import com.example.EjercicioUno.entity.Solicitud;
import com.example.EjercicioUno.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */

@Controller
@RequestMapping("/solicitud")
public class SolicitudController {
    
    @Autowired
    private SolicitudService solicitudService;
    
    @PostMapping("/registrarSolicitud")
    public String registrarSolicitud(Model model, SolicitudDto solicitudDto){
       
       Solicitud solicitudCreada = solicitudService.registrarSolicitud(solicitudDto);
       
       model.addAttribute("idSolicitud", solicitudCreada.getId());
              
       return "user/registrar-archivos";
    }
    
    
    public String registrarDocumentoTecnico( @RequestParam("informeTecnico") MultipartFile archivoFileInforme, @RequestParam("idSolicitud") Long idSolicitud){
        solicitudService.registrarInformeTecnico(idSolicitud, archivoFileInforme);
        return "";
    }
}
