/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.EjercicioUno.service;

import com.example.EjercicioUno.entity.Local;
import java.util.List;

/**
 *
 * @author HP
 */
public interface LocalOrgService {
    List<Local> listadLocalOrg();

    Local encontrarLocalById(Long idLocal);
}
