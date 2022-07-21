package com.example.EjercicioUno.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizacionDto {

    private Long id;

    private String nombreOrganizacion;

    private String codigo;

    private int nivelOrg;

    private int tipoOrg;

    private int local;



}
