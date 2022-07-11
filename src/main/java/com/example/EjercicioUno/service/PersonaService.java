/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.EjercicioUno.service;

import com.example.EjercicioUno.dto.PersonaDto;
import com.example.EjercicioUno.entity.Persona;
import com.example.EjercicioUno.entity.Usuario;

/**
 *
 * @author HP
 */
public interface PersonaService {
     
    Persona crear(PersonaDto personaDto);
    
}
