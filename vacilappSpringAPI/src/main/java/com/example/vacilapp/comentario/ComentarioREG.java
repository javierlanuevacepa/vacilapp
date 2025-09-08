package com.example.vacilapp.comentario;




public class ComentarioREG {


    private Long idUsuario;
    private Long idEvento;
    private String comentario;

    public ComentarioREG(Long idUsuario,Long idEvento,String comentario){
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
        this.comentario = comentario;
    }

    public Long getIdUsuario(){
        return this.idUsuario;
    }

    public void setIdUsuario(Long idse){
        this.idUsuario = idse;
    }

    public Long getIdEvento(){
        return this.idEvento;
    }

    public void setIdEvento(Long ids){
        this.idEvento = ids;
    }

    public String getComentario(){
        return this.comentario;
    }
    
    public void setComentario(String como){
        this.comentario = como;
    }

    


}
