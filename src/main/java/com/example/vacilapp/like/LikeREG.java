package com.example.vacilapp.like;

public class LikeREG {


    private Long idEventoLikeado;
    private Long idLikeadorEvento;


    public LikeREG(Long idEventoLikeado,Long idLikeadorEvento){
        this.idEventoLikeado = idEventoLikeado;
        this.idLikeadorEvento = idLikeadorEvento;
    }

    public Long getIdEventoLikeado(){
        return this.idEventoLikeado;
    }

    public void setIdEventoLikeado(Long idEve){
        this.idEventoLikeado = idEve;
    }

    public Long getIdLikeadorEvento(){
        return this.idLikeadorEvento;
    }

    public void setIdLikeadorEvento(Long idAva){
        this.idEventoLikeado = idAva;
    }

    


}
