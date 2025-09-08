package com.example.vacilapp.like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface LikeRepository extends JpaRepository<Likes, LikesKey>{

    @Query("SELECT l FROM Likes l WHERE l.eventoLikeado = ?1 AND l.dadorDeLike = ?2")
    Optional<Likes> existeLikeIdEventoIdLikeador(Long idEventoLikeado, Long idLikeadorEvento);


}
