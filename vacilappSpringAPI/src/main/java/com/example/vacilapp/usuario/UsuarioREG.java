package com.example.vacilapp.usuario;

public class UsuarioREG {


    private String nombreUsuario;
    private String correo;
    private String contrasena;
    private byte[] fotoPerfil;
    private Long idTipoUsuario;

    public UsuarioREG(){}

    public UsuarioREG(String nombreUsuario,String correo,String contrasena,byte[] fotoPerfil,Long idTipoUsuario){
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fotoPerfil = fotoPerfil;
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNombreUsuario(){
        return this.nombreUsuario;
    }

    public String getCorreo(){
        return this.correo;
    }

    public String getContrasena(){
        return this.contrasena;
    }

    public byte[] getFotoPerfil(){
        return this.fotoPerfil;
    }

    public Long getIdTipoUsuario(){
        return this.idTipoUsuario;
    }



}
