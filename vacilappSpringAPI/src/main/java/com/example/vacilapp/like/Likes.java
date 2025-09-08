package com.example.vacilapp.like;

import jakarta.persistence.*;
import com.example.vacilapp.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.example.vacilapp.evento.Evento;

import java.time.LocalDateTime;



@Entity
public class Likes {

    @EmbeddedId
    private LikesKey id;

   

    private LocalDateTime fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idEventoLikeado")
    @JoinColumn(name = "id_evento_likeado", nullable = false)
    @JsonIgnore
    private Evento eventoLikeado;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idLikeadorEvento")
    @JoinColumn(name = "id_likeador_evento", nullable = false)
    @JsonIgnore
    private Usuario dadorDeLike;


    public Likes(){}

    public Likes(LikesKey id,LocalDateTime fechaRegistro,Evento eventoLikeado,Usuario dadorDeLike){
        this.id = id;
        this.fechaRegistro = fechaRegistro;
        this.eventoLikeado = eventoLikeado;
        this.dadorDeLike = dadorDeLike;
    }

    public Likes(LikesKey id,Evento eventoLikeado,Usuario dadorDeLike){
        this.id = id;
        this.fechaRegistro = LocalDateTime.now();
        this.eventoLikeado = eventoLikeado;
        this.dadorDeLike = dadorDeLike;
    }

    public LikesKey getIdLike(){
        return this.id;
    }

    public void setIdLike(LikesKey ga){
       this.id = ga;
    }

    public Evento getEventoLikeado(){
        return this.eventoLikeado;
    }

    public Usuario getUsuarioLikeador(){
        return this.dadorDeLike;
    }



    public LocalDateTime getFechaRegistro(){
        return this.fechaRegistro; 
    }




}
