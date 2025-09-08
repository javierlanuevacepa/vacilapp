package com.example.vacilapp.like;

import java.time.LocalDateTime;



public class LikesDTO {

    private Long idEventoLikeado;
    private String nombreUserLiker;
    private String nombreEventLiked;
    private LocalDateTime fechaRegistro;

    public LikesDTO(){}

    public LikesDTO(Likes lik){
        this.idEventoLikeado = lik.getEventoLikeado().getIdEvento();
        this.nombreEventLiked = lik.getEventoLikeado().getNombreCarrete();
        this.nombreUserLiker = lik.getUsuarioLikeador().getNombreUsuario();
        this.fechaRegistro = lik.getFechaRegistro();
    }


    public Long getIdEvento(){
        return this.idEventoLikeado;
    }


    public String getUser(){
        return this.nombreUserLiker;
    }

    public String getEventLiked(){
        return this.nombreEventLiked;
    }

    public LocalDateTime getFechaRegistro(){
        return this.fechaRegistro;
    }




}
