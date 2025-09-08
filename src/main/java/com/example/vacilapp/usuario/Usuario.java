package com.example.vacilapp.usuario;

import java.time.LocalDateTime;


import com.example.vacilapp.like.Likes;
import com.example.vacilapp.like.LikesDTO;
import com.example.vacilapp.evento.Evento;
import com.example.vacilapp.comentario.Comentario;
import com.example.vacilapp.tipousuario.TipoUsuario;
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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_sequence", allocationSize = 1)
    private Long idUs;

    @Column(nullable = false,unique = true)
    private String nombreUsuario;

    @Column(nullable = false,unique = true)
    private String correo;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    @Lob
    @Column(nullable = true)
    private byte[] fotoPerfil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_usuario_id", nullable = false)
    @JsonBackReference
    private TipoUsuario tipoUsuario;


    

    @OneToMany(mappedBy = "dadorDeLike", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Likes> likesDados;


     
    @OneToMany(mappedBy = "organizador",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Evento> eventos;

    @OneToMany(mappedBy = "userComentador",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Comentario> comentariosUsuario;


    public Usuario(){}

    public Usuario(Long idUs,String nombreUsuario,String correo,String contrasena,LocalDateTime fechaRegistro,byte[] fotoPerfil,TipoUsuario tipoUsuario){
        this.idUs = idUs;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
        this.fotoPerfil = fotoPerfil;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String nombreUsuario,String correo,String contrasena,byte[] fotoPerfil,TipoUsuario tipoUsuario){
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fechaRegistro = LocalDateTime.now();
        this.fotoPerfil = fotoPerfil;
        this.tipoUsuario = tipoUsuario;
    }


    public Long getId(){
        return this.idUs;
    }

    public void setId(Long id){
        this.idUs = id;
    }

    public String getNombreUsuario(){
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String user){
        this.nombreUsuario = user;
    }

    public String getCorreo(){
        return this.correo;
    }

    public byte[] getFotoPerfil(){
        return this.fotoPerfil;
    }

    public void setFotoPerfil(byte[] x){
        this.fotoPerfil = x;
    }

    public void setCorreo(String corre){
        this.correo = corre;
    }

    public LocalDateTime getFechaRegistro(){
        return this.fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime x){
        this.fechaRegistro = x;
    }

    public TipoUsuario getTipoUsuario(){
        return this.tipoUsuario;
    }

    public String getTipoUsuarioDesc(){
        return this.tipoUsuario.getDesc();
    }

    public void setTipoUsuario(TipoUsuario ga){
        this.tipoUsuario = ga;
    }

    public int getLikesDadosPorUsuario(){
        return this.likesDados.size();
    }

    public List<LikesDTO> getLikesDetalles(){
        List<LikesDTO> likesFormateados = new ArrayList<>();
        if (!this.likesDados.isEmpty()){

            for (Likes x : this.likesDados){
                likesFormateados.add(new LikesDTO(x));
            }
        }
        return likesFormateados;
    }

    public List<Evento> getEventos(){
        return this.eventos;
    }

    public List<UserComentariosDTO> getComentariosDetalles(){
        List<UserComentariosDTO> comentariosDelUser = new ArrayList<>();
        if (!this.comentariosUsuario.isEmpty()){
            for (Comentario x : this.comentariosUsuario){
                comentariosDelUser.add(new UserComentariosDTO(x.getEventoComentado().getIdEvento(),x.getUsuarioComentador().getId(),x.getFechaRegistro(),x.getComentario()));
            }
        }
        return comentariosDelUser;
    }


}
