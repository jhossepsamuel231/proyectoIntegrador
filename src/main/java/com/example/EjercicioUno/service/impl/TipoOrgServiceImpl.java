/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.service.impl;

import com.example.EjercicioUno.entity.TipoOrganizacion;
import com.example.EjercicioUno.repository.TipoOrgRepository;
import com.example.EjercicioUno.service.TipoOrgService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class TipoOrgServiceImpl implements TipoOrgService{

    @Autowired
    private TipoOrgRepository tipoOrgRepository;
    
    @Override
    public List<TipoOrganizacion> listadTipoOrg() {
        return tipoOrgRepository.findAll();
    }

    @Override
    public TipoOrganizacion encontrarTipoOrgById(Long id) {
        return tipoOrgRepository.findById(id).orElse(null);
    }

}
