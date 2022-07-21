/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.controller;

import com.example.EjercicioUno.dto.OrganizacionDto;
import com.example.EjercicioUno.entity.Organizacion;
import com.example.EjercicioUno.entity.Solicitud;
import com.example.EjercicioUno.service.OrganizacionService;
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

    @Autowired
    private OrganizacionService organizacionService;
    
    
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
    public String generarExpdiente(Model model){

        model.addAttribute("solicitudes", solicitudService.listarSolicitudesCreacion());

        return "gerencia/subir-expediente";
    }
    
    
    @GetMapping("/crearOrg/{idSolicitud}")
    public String CrearOrg(Model model, @PathVariable("idSolicitud") Long idSolicitud){

        Solicitud solicitudEncontrado = solicitudService.encontrarSolicitud(idSolicitud);

        OrganizacionDto organizacionDto = new OrganizacionDto();

        organizacionDto.setNombreOrganizacion(solicitudEncontrado.getNombre_org());
        organizacionDto.setNivelOrg(solicitudEncontrado.getNivelOrganizacion().getId().intValue());
        organizacionDto.setTipoOrg(solicitudEncontrado.getTipoOrganizacion().getId().intValue());
        organizacionDto.setLocal(solicitudEncontrado.getLocal().getId().intValue());

        model.addAttribute("idSolicitud", idSolicitud);
        model.addAttribute("solicitud", solicitudEncontrado);
        model.addAttribute("organizacionDto", organizacionDto);

        return "gerencia/Crear-Organizacion";

    }
    
    @PostMapping("/crearJunta")
    public String crearJunta(OrganizacionDto organizacionDto) {

        organizacionService.registrarOrganizacion(organizacionDto);

        return "gerencia/Crear-Junta";

    }
    
    @PostMapping("/logear")
    public String logearGerencia() {
        return "menu/gerencia";
    }

}
