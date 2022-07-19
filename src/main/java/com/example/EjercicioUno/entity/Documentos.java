package com.example.EjercicioUno.entity;


import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "documentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Documentos implements Serializable{

    @Id
    @Column(name = "iddocumentos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumentos;

    @Column(name="archivo_uno")
    private String archivoUno;

    @Column(name="archivo_dos")
    private String archivoDos;

    @Column(name="archivo_tres")
    private String archivoTres;

    @Column(name="archivo_cuatro")
    private String archivoCuatro;

    @Column(name="archivo_cinco")
    private String archivoCinco;

    @Column(name="archivo_seis")
    private String archivoSeis;

    @Column(name="archivo_siete")
    private String archivoSiete;

    @Column(name="archivo_ocho")
    private String archivoOcho;

    @Column(name="archivo_nueve")
    private String archivoNueve;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_solicitud", referencedColumnName = "id_solicitud")
    private Solicitud solicitud;
}
