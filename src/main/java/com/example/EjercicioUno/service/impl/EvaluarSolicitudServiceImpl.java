/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.service.impl;

import com.example.EjercicioUno.entity.Documentos;
import com.example.EjercicioUno.entity.Solicitud;
import com.example.EjercicioUno.repository.DocumentoRepository;
import com.example.EjercicioUno.repository.EvaluarSolicitudRepository;
import com.example.EjercicioUno.repository.SolicitudRepository;
import com.example.EjercicioUno.service.EvaluarSolicitudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class EvaluarSolicitudServiceImpl implements EvaluarSolicitudService{

    @Autowired
    private EvaluarSolicitudRepository evaluarSoliRepo;
    
    @Autowired
    private DocumentoRepository documentoRepo;
    
    @Autowired
    private SolicitudRepository solicitudRepo;
    
    @Override
    public List<Solicitud> Listar() {
        return evaluarSoliRepo.findAll();
    }

    @Override
    public Documentos encontrarDoc(Solicitud solicitud) {
        return documentoRepo.findBySolicitud(solicitud);
    }
    
}
