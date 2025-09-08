package com.example.vacilapp.usuario;

import java.time.LocalDateTime;


public class UserComentariosDTO {

    private Long idEventoComentado;
    private Long idComentario;
    private LocalDateTime fechaRegistro;
    private String comentario;

    public UserComentariosDTO(Long idEventoComentado,Long idComentario,LocalDateTime fechaRegistro,String comentario){
        this.idEventoComentado = idEventoComentado;
        this.idComentario = idComentario;
        this.fechaRegistro = fechaRegistro;
        this.comentario = comentario;
    }

   public Long getIdComentario(){
    return this.idComentario;
   }
   public Long getIdEventoComentario(){
    return this.idEventoComentado;
   }
   public LocalDateTime getFechaRegistro(){
    return this.fechaRegistro;
   }
   public String getComentario(){
    return this.comentario;
   }
}
