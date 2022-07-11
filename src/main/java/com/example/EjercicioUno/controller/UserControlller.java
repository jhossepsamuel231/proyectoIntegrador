/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.controller;

import com.example.EjercicioUno.dto.PersonaDto;
import com.example.EjercicioUno.entity.Persona;
import com.example.EjercicioUno.entity.Usuario;
import com.example.EjercicioUno.service.PersonaService;
import com.example.EjercicioUno.service.UsuarioService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    
    @GetMapping("/uploadDate")
    public String actualizacionDatos(){
        return "user/actualizacion-datos";
    }
    
    @GetMapping("/perfil")
    public String perfil(){
        return "user/perfil";
    }
    
    
    @GetMapping("/plantillas")
    public String plantillasSoli(){
        return "user/plantillas-solicitudes";
    }
    
    
    
    
    
    @GetMapping("/registroRuos")
    public String registroRUOS(){
        return "user/registro-ruos";
    }
    
    @GetMapping("/solicisEnviadas")
    public String solicitudesEnviadas(){
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
            return "inicio";
        }
        
        return "menu/user";    
        
    }
    
    @PostMapping("/crear-persona")
    public String crearPersona(PersonaDto personaDto) {  
        personaService.crear(personaDto);
        return "redirect:/login";
    }
    
    
    
    /*
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes)
            throws IOException {

        if (file == null || file.isEmpty()) {
            attributes.addFlashAttribute("message", "Por favor seleccione un archivo");
            return "redirect:user/registro-ruos";
        }

        StringBuilder builder = new StringBuilder();
        builder.append(System.getProperty("user.home"));
        builder.append(File.separator);
        builder.append("Archivos");
        builder.append(File.separator);
        builder.append(file.getOriginalFilename());

        byte[] fileBytes = file.getBytes();
        Path path = Paths.get(builder.toString());
        Files.write(path, fileBytes);

        attributes.addFlashAttribute("message", "Archivo cargado correctamente [" + builder.toString() + "]");

        return "redirect:/status";
    }

    @GetMapping("/status")
    public String status() {
        return "status";
    }*/
    
    
}

