/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.EjercicioUno.service;

import com.example.EjercicioUno.entity.Documentos;
import com.example.EjercicioUno.entity.Solicitud;
import java.util.List;

/**
 *
 * @author HP
 */
public interface EvaluarSolicitudService {
    
    List<Solicitud> Listar();
    
    Documentos encontrarDoc(Solicitud solicitud);
}
