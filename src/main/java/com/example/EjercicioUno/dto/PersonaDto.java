/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.dto;

import java.util.Date;
import javax.persistence.Column;
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
public class PersonaDto {

    private Long idPersona;

    private String nombre;

    private String apelPaterno;

    private String apelMaterno;

    private String dni;
    private String correo;
    private String direccion;

    
    private String fecNacimiento;

    private Long idUsuario;

    private String usu;

    private String contrasenia;

}
