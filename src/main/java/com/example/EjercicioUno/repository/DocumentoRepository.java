/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.EjercicioUno.repository;

import com.example.EjercicioUno.entity.Documentos;
import com.example.EjercicioUno.entity.Persona;
import com.example.EjercicioUno.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface DocumentoRepository extends JpaRepository<Documentos, Long>{
    Documentos findBySolicitud(Solicitud solicitud);
}
