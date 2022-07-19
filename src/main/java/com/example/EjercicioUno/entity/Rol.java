package com.example.EjercicioUno.entity;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="roles")
public class Rol {
    
    @Id
    @Column(name="id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    
    private String nombre;
    
    @ManyToMany(mappedBy = "usuarioRoles")
    private Collection<Usuario> usuarios;
    
}
