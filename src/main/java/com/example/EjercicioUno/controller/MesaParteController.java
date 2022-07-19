/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.controller;

import com.example.EjercicioUno.entity.Solicitud;
import com.example.EjercicioUno.service.EvaluarSolicitudService;
import com.example.EjercicioUno.service.SolicitudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping("/principal/menu/mesadeparte")
public class MesaParteController {

    @Autowired
    private EvaluarSolicitudService evaluarSoliService;

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping
    public String mesaParte() {
        return "menu/mesa-parte";
    }

    @GetMapping("/actualizarRUOS")
    public String actualizarRUOS() {
        return "mesadeparte/actualizaciones";
    }

    @GetMapping("/perfil")
    public String perfil() {
        return "mesadeparte/perfil";
    }

    @GetMapping("/validarRUOS")
    public String validarRUOS(Model model) {
        model.addAttribute("validarSolicitud", solicitudService.listarSoli());
        return "mesadeparte/registrar-ruos";
    }

    @GetMapping("/archivoRuos/{idSolicitud}")
    public String archivosSolicitud(Model model, @PathVariable("idSolicitud") Long idsolicitud) {
        Solicitud solicitud = solicitudService.encontrarSolicitud(idsolicitud);
        model.addAttribute("documentos", evaluarSoliService.encontrarDoc(solicitud));
        return "mesadeparte/archivos-ruos";
    }

    @PostMapping("/logear")
    public String logearMesaParte() {
        return "menu/mesa-parte";
    }

    @GetMapping("/enviarGerencia")
    public String enviarSolicitudaGerencia(@RequestParam("idSolicitud") Long idSolicitud) {
        solicitudService.actualizarsolicitud(idSolicitud, "proceso");

        return "redirect:/principal/menu/mesadeparte";
    }

    @PostMapping("/aceptandoDocs")
    public String aceptandoArchivos(@RequestParam("idSolicitud") Long idSolicitud) {
        Solicitud solicitud = solicitudService.encontrarSolicitud(idSolicitud);
        solicitudService.derivarDOc(solicitud);
        return "redirect:/principal/menu/mesadeparte/validarRUOS";
    }
    
    
     @GetMapping("/eliminarSoli/{idSolicitud}")
    public String eliminarSoli(Model model, @PathVariable("idSolicitud") Long idsolicitud) {
        solicitudService.Eliminar(idsolicitud);
        return "redirect:/principal/menu/mesadeparte/validarRUOS    ";
    }
    
    /*
    @GetMapping("/del/{id}")
    public String eliminarPedido(Model model, @PathVariable("id") Long idPedido){
        pedidosService.delete(idPedido);
        return "redirect:/pedidos/listado";
    }
    */

}
