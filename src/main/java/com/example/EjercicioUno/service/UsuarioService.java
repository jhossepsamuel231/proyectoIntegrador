package com.example.EjercicioUno.service;

import com.example.EjercicioUno.entity.Usuario;

/**
 *
 * @author HP
 */
public interface UsuarioService {
    
    Usuario logearUsuario(String usuario, String contrasenia);
    
}
