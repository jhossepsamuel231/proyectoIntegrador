package com.example.EjercicioUno.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="personas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    
    @Id
    @Column(name="id_persona")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    
    private String nombre;
    
    @Column(name="apel_paterno")
    private String apelPaterno;
    
    @Column(name="apel_materno")
    private String apelMaterno;
    
    
    private String dni;
    private String correo;
    private String direccion;
    
    
    @DateTimeFormat(pattern="yyyy/MM/dd/")
    @Column(name = "fe_nacimiento")
    private Date fecNacimiento;
    
    @OneToOne(mappedBy = "persona")
    private Usuario usuario;
    
    @OneToMany(mappedBy="personas")
    private Set<JuntaDirectiva> juntaDirectivas;
    
}
