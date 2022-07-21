/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.EjercicioUno.service;

import com.example.EjercicioUno.dto.SolicitudDto;
import com.example.EjercicioUno.entity.Solicitud;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
public interface SolicitudService {
    
    Solicitud registrarSolicitud(SolicitudDto solicitudDto);
    
    Solicitud registrarInformeTecnico(Long idSolicitud, MultipartFile archivo);

    Solicitud encontrarSolicitud(Long idSolcitud);
    
    
    Solicitud actualizarsolicitud(Long idSolicitud,String estado);

    Solicitud derivarDOc(Solicitud solicitud);
    
    List<Solicitud> listarSoli();
    
    List<Solicitud> listarSoliParaInformeTecnico();
    
    Solicitud actualizarInformeTecnico(Solicitud solicitud);
    
    List<Solicitud> listarInformeParaGerente();
    
    void Eliminar(Long id);

    List<Solicitud> listarSolicitudesCreacion();
}
