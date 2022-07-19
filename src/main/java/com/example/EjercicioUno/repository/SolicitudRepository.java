/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.EjercicioUno.repository;

import com.example.EjercicioUno.entity.Solicitud;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long>{
    
    @Query("SELECT solicitud FROM Solicitud solicitud WHERE solicitud.estadoSolicitud=0")
    List<Solicitud> findByEstadoSolicitud();
    
    @Query("SELECT solicitud FROM Solicitud solicitud WHERE solicitud.estadoSolicitud=2")
    List<Solicitud> listarSoliParaInformeTecnico();
    
    @Query("SELECT solicitud FROM Solicitud solicitud WHERE solicitud.estadoSolicitud=1")
    List<Solicitud> listarsoliParaGerente();
    
    @Query("SELECT solicitud FROM Solicitud solicitud WHERE solicitud.estadoSolicitud=3")
    List<Solicitud> crearOrganizacion();
    
   
}
