package com.example.vacilapp.usuario;




import com.example.vacilapp.tipousuario.TipoUsuario;
import com.example.vacilapp.usuario.Usuario;
import java.time.LocalDateTime;
import com.example.vacilapp.evento.Evento;
import com.example.vacilapp.like.LikesDTO;
import com.example.vacilapp.like.Likes;
import java.util.List;



public class UsuarioDTO {


    private Long idUs;
    private String nombreUser;
    private String correo;
    private LocalDateTime fechaRegistro;
    private String tipoUsuario;
    private List<Evento> eventos;
    private List<LikesDTO> likesUser;
    private int likesDados;

    public UsuarioDTO(Usuario user){
        this.idUs = user.getId();
        this.nombreUser = user.getNombreUsuario();
        this.correo = user.getCorreo();
        this.fechaRegistro = user.getFechaRegistro();
        this.tipoUsuario = user.getTipoUsuarioDesc();
        this.eventos = user.getEventos();
        this.likesDados = user.getLikesDadosPorUsuario();
       // this.likesDTOGenerator(user.getLikesDetalles());
    }

    public void likesDTOGenerator(List<Likes> x){
        if (!x.isEmpty()){
            for (Likes a : x){
                this.likesUser.add(new LikesDTO(a));
            }
        }
    }

 

    public Long getId(){
        return this.idUs;
    }

    public String getUser(){
        return this.nombreUser;
    }

    public String getCorreo(){
        return this.correo;
    }

    public LocalDateTime getFechaRegistro(){
        return this.fechaRegistro;
    }

    public String getTipoUsuario(){
        return this.tipoUsuario;
    }

    public List<LikesDTO> getLikesUsuario(){
        return this.likesUser;
    }

    public List<Evento> getEvento(){
        return this.eventos;
    }

    public int getLikesDados(){
        return this.likesDados;
    }




}
