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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "junta_directiva")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JuntaDirectiva {
    
    @Id
    @Column(name="idjunta_directiva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    
    private boolean estado;
    
    @ManyToOne
    @JoinColumn(name="idorganizaciones", nullable=false)
    private Organizacion organizaciones;
    
    @ManyToOne
    @JoinColumn(name="id_persona", nullable=false)
    private Persona personas;
    
    @ManyToOne
    @JoinColumn(name="idcargo_junta", nullable=false)
    private CargoJunta cargoJunta;
}
