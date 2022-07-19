/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author HP
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="solicitudes")
public class Solicitud {
    
    @Id
    @Column(name="id_solicitud")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre_org;
    
    private Date fecha_registro;
    
    private String documentotecnico;
    
    @Column(name = "estado_solicitud")
    private int estadoSolicitud; 
    
    @OneToOne(mappedBy = "solicitud")
    private Documentos documentos;
    
    @ManyToOne
    @JoinColumn(name="idtipo_organizacion", nullable=false)
    private TipoOrganizacion tipoOrganizacion;
    
    @ManyToOne
    @JoinColumn(name="idnivel_organizacion", nullable=false)
    private NivelOrganizacion nivelOrganizacion;
    
    @ManyToOne
    @JoinColumn(name="id_local", nullable=false)
    private Local local;
}
