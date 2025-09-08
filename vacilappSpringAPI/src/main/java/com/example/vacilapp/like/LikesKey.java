package com.example.vacilapp.like;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;



@Embeddable
public class LikesKey implements Serializable {


    private Long idEventoLikeado;


    private Long idLikeadorEvento;

    

    public LikesKey(){}

    public LikesKey(Long idEventoLikeado,Long idLikeadorEvento){
        this.idEventoLikeado = idEventoLikeado;
        this.idLikeadorEvento = idLikeadorEvento;
    }

    public Long getIdEventoLikeado(){
        return this.idEventoLikeado;
    }

    public void setIdEventoLikeado(Long id){
        this.idEventoLikeado = id;
    }

    public Long getIdLikeadorEvento(){
        return this.idLikeadorEvento;
    }

    public void setIdLikeadorEvento(Long ids){
        this.idLikeadorEvento = ids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikesKey that = (LikesKey) o;
        return idEventoLikeado == that.idEventoLikeado &&
                idLikeadorEvento == that.idLikeadorEvento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEventoLikeado, idLikeadorEvento);
    }

}
