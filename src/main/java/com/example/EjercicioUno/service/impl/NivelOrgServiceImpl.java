/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.service.impl;

import com.example.EjercicioUno.entity.NivelOrganizacion;
import com.example.EjercicioUno.repository.NivelOrgRepository;
import com.example.EjercicioUno.service.NivelOrgService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class NivelOrgServiceImpl implements NivelOrgService{

    
    @Autowired
    private NivelOrgRepository nivelOrgRepository;
    
    @Override
    public List<NivelOrganizacion> listaNivelOrg() {
        return nivelOrgRepository.findAll();
    }

    @Override
    public NivelOrganizacion encontrarNivelById(Long id) {
        return nivelOrgRepository.findById(id).orElse(null);
    }

}
