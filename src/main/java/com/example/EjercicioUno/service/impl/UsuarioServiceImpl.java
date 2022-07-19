/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.service.impl;

import com.example.EjercicioUno.entity.Documentos;
import com.example.EjercicioUno.entity.Solicitud;
import com.example.EjercicioUno.entity.Usuario;
import com.example.EjercicioUno.repository.DocumentoRepository;
import com.example.EjercicioUno.repository.UsuarioRepository;
import com.example.EjercicioUno.service.UsuarioService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private DocumentoRepository documentoRpository;
    
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    

    @Override
    public Usuario logearUsuario(String usuario, String contrasenia) {
        return usuarioRepository.findByUsuAndContrasenia(usuario, contrasenia);
    }

    @Override
    public String subirArchivos(MultipartFile archivo) {
        String folder ="archivos//";
        if (!archivo.isEmpty()) {
            try {
                byte[] bytes = archivo.getBytes();
                Path path = Paths.get(folder + archivo.getOriginalFilename());
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return folder+archivo.getOriginalFilename();
    }

    @Override
    public void registrarArchivos(List<MultipartFile> listaArchivos, Solicitud solicitud) {
        Documentos nuevos = new Documentos();
        
        nuevos.setSolicitud(solicitud);
        
        nuevos.setArchivoUno(
                subirArchivos(listaArchivos.get(0))
        );
        nuevos.setArchivoDos(
                subirArchivos(listaArchivos.get(1))
        );
        nuevos.setArchivoTres(
                subirArchivos(listaArchivos.get(2))
        );
        nuevos.setArchivoCuatro(
                subirArchivos(listaArchivos.get(3))
        );
        nuevos.setArchivoCinco(
                subirArchivos(listaArchivos.get(4))
        );
        nuevos.setArchivoSeis(
                subirArchivos(listaArchivos.get(5))
        );
        nuevos.setArchivoSiete(
                subirArchivos(listaArchivos.get(6))
        );
        nuevos.setArchivoOcho(
                subirArchivos(listaArchivos.get(7))
        );
        nuevos.setArchivoNueve(
                subirArchivos(listaArchivos.get(8))
        );
        documentoRpository.save(nuevos);
    }
       
    
}
