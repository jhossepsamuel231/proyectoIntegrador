/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.service.impl;

import com.example.EjercicioUno.entity.Local;
import com.example.EjercicioUno.repository.LocalOrgRepository;
import com.example.EjercicioUno.service.LocalOrgService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class LocalOrgServiceImpl implements LocalOrgService{

    @Autowired
    private LocalOrgRepository localOrgRepository;
    
    
    @Override
    public List<Local> listadLocalOrg() {
       return localOrgRepository.findAll();
    }
    
}
