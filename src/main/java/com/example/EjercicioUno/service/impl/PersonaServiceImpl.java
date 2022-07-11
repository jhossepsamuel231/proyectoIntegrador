/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.service.impl;

import com.example.EjercicioUno.dto.PersonaDto;
import com.example.EjercicioUno.entity.Persona;
import com.example.EjercicioUno.entity.Usuario;
import com.example.EjercicioUno.repository.PersonaRepository;
import com.example.EjercicioUno.repository.UsuarioRepository;
import com.example.EjercicioUno.service.PersonaService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {
    
    @Autowired
    private PersonaRepository personaRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Persona crear(PersonaDto personaDto) {
        
        Persona personaIngresa = new Persona();
        
        personaIngresa.setNombre(personaDto.getNombre());
        personaIngresa.setApelPaterno(personaDto.getApelPaterno());
        personaIngresa.setApelMaterno(personaDto.getApelMaterno());
        personaIngresa.setCorreo(personaDto.getCorreo());
        personaIngresa.setDireccion(personaDto.getDireccion());
        personaIngresa.setDni(personaDto.getDni());
        try {
            personaIngresa.setFecNacimiento(new SimpleDateFormat("dd/MM/yyyy").parse(personaDto.getFecNacimiento()));
        } catch (ParseException ex) {
            Logger.getLogger(PersonaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Persona personaCreada = personaRepository.save(personaIngresa);
                
        Usuario usuarioIngresa = new Usuario();        
        usuarioIngresa.setIdPersona(personaCreada.getIdPersona());
        usuarioIngresa.setUsu(personaDto.getNombre());
        usuarioIngresa.setContrasenia(personaDto.getContrasenia());
     
        usuarioRepository.save(usuarioIngresa);
        
        return personaCreada;  
        
    }
    
}
