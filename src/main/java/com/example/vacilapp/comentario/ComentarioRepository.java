package com.example.vacilapp.comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.vacilapp.usuario.Usuario;

import java.util.Optional;
import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Long>{

    

    @Query(value="SELECT c FROM Comentario WHERE c.userComentador = :idUserComent AND c.eventoComentado = :idEventoComent",nativeQuery = true)
    Optional<Comentario> getIdComentarioConUserEvento(@Param("idUserComent") Long idUserComent,@Param("idEventoComent") Long idEventoComen);



}
