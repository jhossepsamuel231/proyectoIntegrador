package com.example.EjercicioUno.repository;

import com.example.EjercicioUno.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    Usuario findByUsuAndContrasenia(String usu, String contrasenia);

}
