package com.example.vacilapp.comentario;

import java.time.LocalDateTime;
import com.example.vacilapp.usuario.Usuario;
import com.example.vacilapp.evento.Evento;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;



@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comentario_seq")
    @SequenceGenerator(name = "comentario_seq", sequenceName = "comentario_sequence", allocationSize = 1)
    private Long idComentario;



    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "id_comentador_evento", nullable = false)
    @JsonIgnore
    private Usuario userComentador;


    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "id_evento_comentado", nullable = false)
    @JsonIgnore
    private Evento eventoComentado;
    
    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    private String comentario;

    public Comentario(){}

    public Comentario(Long idComentario,Usuario userComentador,Evento eventoComentado,String comentario){
        this.idComentario = idComentario;
        this.userComentador = userComentador;
        this.eventoComentado = eventoComentado;
        this.comentario = comentario;
    }

    public Comentario(Usuario userComentador,Evento eventoComentado,String comentario){
        this.userComentador = userComentador;
        this.eventoComentado = eventoComentado;
        this.fechaRegistro = LocalDateTime.now();
        this.comentario = comentario;
    }

    public Long getIdComentario(){
        return this.idComentario;
    }


    public LocalDateTime getFechaRegistro(){
        return this.fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime x){
        this.fechaRegistro = x;
    }



    public void setIdComentario(Long id){
        this.idComentario = id;
    }

    public Usuario getUsuarioComentador(){
        return this.userComentador;
    }

    public Evento getEventoComentado(){
        return this.eventoComentado;
    }

    public String getComentario(){
        return this.comentario;
    }

    public void setComentario(String x){
        this.comentario = x;
    }
    

}


