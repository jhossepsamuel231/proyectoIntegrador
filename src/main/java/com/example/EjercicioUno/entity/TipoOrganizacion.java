/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "tipo_organizaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoOrganizacion implements Serializable{
    
   
    @Id
    @Column(name="idtipo_organizacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    
    
    @Column(name="nombre_tipo")
    private String nombreTipo;
    
    
    @OneToMany(mappedBy="tipoOrganizacion")
    private Set<Solicitud> solicitudes;
    
    @OneToMany(mappedBy="tipoOrg")
    private Set<Organizacion> organizaciones;
}
