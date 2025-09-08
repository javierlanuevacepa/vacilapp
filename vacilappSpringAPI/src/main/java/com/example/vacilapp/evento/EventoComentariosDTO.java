package com.example.vacilapp.evento;


import java.time.LocalDateTime;


public class EventoComentariosDTO {


    private Long idComentario;
    private byte[] fotoPerfilComentador;
    private String nombreUsuarioComentador;
    private LocalDateTime fechaRegistro;
    private String comentario;

    public EventoComentariosDTO(Long idComentario,byte[] fotoPerfilComentador,String nombreUsuarioComentador,LocalDateTime fechaRegistro,String comentario){
        this.idComentario = idComentario;
        this.fotoPerfilComentador = fotoPerfilComentador;
        this.nombreUsuarioComentador = nombreUsuarioComentador;
        this.fechaRegistro = fechaRegistro;
        this.comentario = comentario;
    }

    public Long getIdComentario(){
        return this.idComentario;
    }

    public byte[] getFotoPerfilComentador(){
        return this.fotoPerfilComentador;
    }

    public String getNombreUsuarioComentador(){
        return this.nombreUsuarioComentador;
    }

    public LocalDateTime getFechaRegistro(){
        return this.fechaRegistro;
    }

    public String getComentario(){
        return this.comentario;
    }

}
