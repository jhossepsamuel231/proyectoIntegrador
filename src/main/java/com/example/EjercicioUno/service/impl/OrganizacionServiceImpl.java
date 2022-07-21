package com.example.EjercicioUno.service.impl;

import com.example.EjercicioUno.dto.OrganizacionDto;
import com.example.EjercicioUno.entity.Local;
import com.example.EjercicioUno.entity.NivelOrganizacion;
import com.example.EjercicioUno.entity.Organizacion;
import com.example.EjercicioUno.entity.TipoOrganizacion;
import com.example.EjercicioUno.repository.OrganizacionRepository;
import com.example.EjercicioUno.service.LocalOrgService;
import com.example.EjercicioUno.service.NivelOrgService;
import com.example.EjercicioUno.service.OrganizacionService;
import com.example.EjercicioUno.service.TipoOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizacionServiceImpl implements OrganizacionService {

    @Autowired
    private OrganizacionRepository organizacionRepository;

    @Autowired
    private LocalOrgService localOrgService;

    @Autowired
    private NivelOrgService nivelOrgService;

    @Autowired
    private TipoOrgService tipoOrgService;


    @Override
    public List<Organizacion> ListarTodo() {
        return null;
    }

    @Override
    public Organizacion registrarOrganizacion(OrganizacionDto organizacionDto) {

        Organizacion organizacion = new Organizacion();

        Local local = localOrgService.encontrarLocalById((long) organizacionDto.getLocal());
        NivelOrganizacion  nivelOrganizacion = nivelOrgService.encontrarNivelById((long) organizacionDto.getNivelOrg());
        TipoOrganizacion tipoOrganizacion = tipoOrgService.encontrarTipoOrgById((long) organizacionDto.getTipoOrg());

        organizacion.setNombreOrganizacion(organizacionDto.getNombreOrganizacion());
        organizacion.setCodigo(organizacionDto.getCodigo());
        organizacion.setLocal(local);
        organizacion.setNivelOrg(nivelOrganizacion);
        organizacion.setTipoOrg(tipoOrganizacion);

        return organizacionRepository.save(organizacion);
    }
}
