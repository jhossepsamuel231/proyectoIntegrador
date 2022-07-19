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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "organizaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organizacion implements Serializable{
    
    @Id
    @Column(name="idorganizaciones")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    
    
    @Column(name="organizacion")
    private String nombreOrganizacion;
    
    private String codigo;
    
    
    @ManyToOne
    @JoinColumn(name = "idnivel_org")
    private NivelOrganizacion nivelOrg;
    
    @ManyToOne
    @JoinColumn(name = "idtipo_org")
    private TipoOrganizacion tipoOrg;
    
    
    @OneToMany(mappedBy="organizaciones")
    private Set<JuntaDirectiva> juntaDirectivas;
    
    @ManyToOne
    @JoinColumn(name="id_local", nullable=false)
    private Local local;
}
