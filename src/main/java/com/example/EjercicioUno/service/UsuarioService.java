package com.example.EjercicioUno.service;

import com.example.EjercicioUno.entity.Solicitud;
import com.example.EjercicioUno.entity.Usuario;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
public interface UsuarioService {
    
    Usuario logearUsuario(String usuario, String contrasenia);
    
    String subirArchivos(MultipartFile archivo);
    
    void registrarArchivos(List<MultipartFile> listaArchivos, Solicitud solicitud);
    
    
}
