/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EjercicioUno.service.impl;

import com.example.EjercicioUno.dto.SolicitudDto;
import com.example.EjercicioUno.entity.Local;
import com.example.EjercicioUno.entity.NivelOrganizacion;
import com.example.EjercicioUno.entity.Solicitud;
import com.example.EjercicioUno.entity.TipoOrganizacion;
import com.example.EjercicioUno.repository.LocalOrgRepository;
import com.example.EjercicioUno.repository.NivelOrgRepository;
import com.example.EjercicioUno.repository.SolicitudRepository;
import com.example.EjercicioUno.repository.TipoOrgRepository;
import com.example.EjercicioUno.service.LocalOrgService;
import com.example.EjercicioUno.service.NivelOrgService;
import com.example.EjercicioUno.service.SolicitudService;
import com.example.EjercicioUno.service.TipoOrgService;
import com.example.EjercicioUno.service.UsuarioService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
@Service
public class SolicitudServiceImpl implements SolicitudService{

    @Autowired
    private SolicitudRepository solicitudRepository;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private LocalOrgRepository localOrgRepo;
    
    @Autowired
    private NivelOrgRepository nivelOrgRepo;
    
    @Autowired
    private TipoOrgRepository tipoOrgRepo;
    
    @Override
    public Solicitud registrarSolicitud(SolicitudDto solicitudDto) {
        Solicitud solicitud = new Solicitud();
    
        TipoOrganizacion tipoOrg = tipoOrgRepo.findById(solicitudDto.getTipoOrg()).orElse(null);
        NivelOrganizacion nivelOrg = nivelOrgRepo.findById(solicitudDto.getNivelOrg()).orElse(null);
        Local local = localOrgRepo.findById(solicitudDto.getLocal()).orElse(null);
        
        solicitud.setNombre_org(solicitudDto.getNombreOrg());
        solicitud.setTipoOrganizacion(tipoOrg);
        solicitud.setNivelOrganizacion(nivelOrg);
        solicitud.setLocal(local);
        solicitud.setFecha_registro(new Date());
        
        return solicitudRepository.save(solicitud);
    }

    @Override
    public Solicitud registrarInformeTecnico(Long idSolicitud, MultipartFile archivo) {
        String url = usuarioService.subirArchivos(archivo);
        Solicitud solicitudEncotrado = solicitudRepository.findById(idSolicitud).orElse(null);
        solicitudEncotrado.setDocumentotecnico(url);
        return solicitudRepository.save(solicitudEncotrado);
    }

    @Override
    public Solicitud encontrarSolicitud(Long idSolcitud) {
        return solicitudRepository.findById(idSolcitud).orElse(null);
    }

    @Override
    public Solicitud actualizarsolicitud(Long idSolicitud, String estado) {
        Solicitud solicitudEncontrado = solicitudRepository.findById(idSolicitud).orElse(null);
        if (estado.equals("proceso")) {
            
            solicitudEncontrado.setEstadoSolicitud(1);
            
        } else if (estado.equals("desarrollo")) {
            
            solicitudEncontrado.setEstadoSolicitud(2);
            
        }
        return solicitudRepository.save(solicitudEncontrado);
    }

    @Override
    public List<Solicitud> listarSoli() {
        return solicitudRepository.findByEstadoSolicitud();
    }

    @Override
    public Solicitud derivarDOc(Solicitud solicitud) {
        solicitud.setEstadoSolicitud(1);
        return solicitudRepository.save(solicitud);
    }

    @Override
    public List<Solicitud> listarSoliParaInformeTecnico() {
        return solicitudRepository.listarSoliParaInformeTecnico();
    }

    @Override
    public Solicitud actualizarInformeTecnico(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    @Override
    public List<Solicitud> listarInformeParaGerente() {
        return solicitudRepository.listarsoliParaGerente();
    }

    @Override
    public void Eliminar(Long id) {
        solicitudRepository.deleteById(id);
    }
   
}
