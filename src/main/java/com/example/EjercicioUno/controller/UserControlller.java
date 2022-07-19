/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.controller;

import com.example.EjercicioUno.dto.PersonaDto;
import com.example.EjercicioUno.dto.SolicitudDto;
import com.example.EjercicioUno.entity.Persona;
import com.example.EjercicioUno.entity.Solicitud;
import com.example.EjercicioUno.entity.Usuario;
import com.example.EjercicioUno.service.LocalOrgService;
import com.example.EjercicioUno.service.NivelOrgService;
import com.example.EjercicioUno.service.PersonaService;
import com.example.EjercicioUno.service.SolicitudService;
import com.example.EjercicioUno.service.TipoOrgService;
import com.example.EjercicioUno.service.UsuarioService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping("/principal/menu/user")
public class UserControlller {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private PersonaService personaService;
    
    @Autowired
    private SolicitudService solicitudService;
    
    @Autowired
    private LocalOrgService localOrgService;
    
    @Autowired
    private NivelOrgService nivelOrgService;
    
    @Autowired
    private TipoOrgService tipoOrgService;
    
    @GetMapping("/uploadDate")
    public String actualizacionDatos() {
        return "user/actualizacion-datos";
    }
    
    @GetMapping("/perfil")
    public String perfil() {
        
        return "user/perfil";
    }
    
    @GetMapping("/plantillas")
    public String plantillasSoli() {
        return "user/plantillas-solicitudes";
    }
    
    @GetMapping("/registroRuos")
    public String registroRUOS(Model model) {
        model.addAttribute("listaLocalOrg", localOrgService.listadLocalOrg());
        model.addAttribute("listaNivelOrg", nivelOrgService.listaNivelOrg());
        model.addAttribute("listaTipoOrg", tipoOrgService.listadTipoOrg());
        model.addAttribute("solicitudDto", new SolicitudDto());
        return "user/registro-ruos";
    }
    
    
    @GetMapping("/registrarArchivos")
    public String registraArchivoRuos(){
        return "user/registrar-archivos";
    }
    
    @GetMapping("/solicisEnviadas")
    public String solicitudesEnviadas() {
        return "user/solicitudes-enviadas";
    }
    
    @PostMapping("/logear")
    public String logearUsuario(Usuario usuario) {
        
        Usuario usuarioLogeado = usuarioService.logearUsuario(
                usuario.getUsu(),
                usuario.getContrasenia()
        );
        
        System.out.println("Datos controller" + usuario.getUsu());
        
        if (usuarioLogeado == null) {
            // no se ah logeado correctamente
            return "/inicio";
        }
        
        return "menu/user";        
        
    }
    
    @PostMapping("/crear-persona")
    public String crearPersona(PersonaDto personaDto) {        
        personaService.crear(personaDto);
        return "redirect:/login";
    }
    
    
    
    @PostMapping("/subir-Archivos")
    public String subirArchivos(
            @RequestParam("idSolicitud") Long idSolicitud,
            @RequestParam("primerArchivo") MultipartFile archivoFile1,
            @RequestParam("segundoArchivo") MultipartFile archivoFile2,
            @RequestParam("tercerArchivo") MultipartFile archivoFile3,
            @RequestParam("cuartoArchivo") MultipartFile archivoFile4,
            @RequestParam("quintoArchivo") MultipartFile archivoFile5,
            @RequestParam("sextoArchivo") MultipartFile archivoFile6,
            @RequestParam("septimoArchivo") MultipartFile archivoFile7,
            @RequestParam("octavoArchivo") MultipartFile archivoFile8,
            @RequestParam("novenoArchivo") MultipartFile archivoFile9) {
        List<MultipartFile> todos = new ArrayList<>();
        todos.add(archivoFile1);
        todos.add(archivoFile2);
        todos.add(archivoFile3);
        todos.add(archivoFile4);
        todos.add(archivoFile5);
        todos.add(archivoFile6);
        todos.add(archivoFile7);
        todos.add(archivoFile8);
        todos.add(archivoFile9);
        
        Solicitud solicitud = solicitudService.encontrarSolicitud(idSolicitud);
        
        usuarioService.registrarArchivos(todos, solicitud);
        return "redirect:/principal/menu/user";
    }
    
    
}
