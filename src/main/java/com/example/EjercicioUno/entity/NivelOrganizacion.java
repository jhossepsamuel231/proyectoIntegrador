/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.entity;

import java.io.Serializable;
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
@Table(name = "nivel_organizacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NivelOrganizacion implements Serializable{
 
    @Id
    @Column(name="idnivel_organizacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    
    
    @Column(name="nivel_org")
    private String nivelOrg;
    
    @OneToMany(mappedBy="nivelOrganizacion")
    private Set<Solicitud> solicitudes;
    
    @OneToMany(mappedBy="nivelOrg")
    private Set<Organizacion> organizaciones;
}
