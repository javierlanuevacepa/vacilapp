package com.example.vacilapp.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{


    @Query("SELECT u FROM Usuario u WHERE u.nombreUsuario = :Uzel AND u.contrasena = :password")
    Optional<Usuario> loginUsuarioDevolver(@Param("Uzel") String Uzel, @Param("password") String password);


}
