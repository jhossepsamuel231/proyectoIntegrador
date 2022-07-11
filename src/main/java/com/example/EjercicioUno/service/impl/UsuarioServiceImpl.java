/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.service.impl;

import com.example.EjercicioUno.entity.Usuario;
import com.example.EjercicioUno.repository.UsuarioRepository;
import com.example.EjercicioUno.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario logearUsuario(String usuario, String contrasenia) {
        return usuarioRepository.findByUsuAndContrasenia(usuario, contrasenia);
    }
    
}
