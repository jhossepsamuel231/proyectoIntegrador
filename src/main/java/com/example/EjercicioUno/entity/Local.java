/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "local")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Local {
    
    @Id
    @Column(name="id_local")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    
    private String local;
    
    
    @OneToMany(mappedBy="local")
    private Set<Organizacion> organizaciones;
    
    @OneToMany(mappedBy="local")
    private Set<Solicitud> solicitudes;
        
}
