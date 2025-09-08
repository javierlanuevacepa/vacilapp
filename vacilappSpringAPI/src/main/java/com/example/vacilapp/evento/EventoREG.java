package com.example.vacilapp.evento;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class EventoREG {


    private Long idOrganizador;
    private String nombreCarrete;
    private byte[] flyerFoto;
    private LocalDate fechaCarrete; 
    private LocalTime horaEmpieza;
    private LocalTime horaTermino;
    private String direccion;
    private Double latitud;
    private Double longitud;
    private String descripcion;


    public EventoREG(){}

    public EventoREG(Long idOrganizador,String nombreCarrete,byte[] flyerFoto,LocalDate fechaCarrete,LocalTime horaEmpieza,LocalTime horaTermino,
    String direccion,Double latitud,Double longitud,String descripcion){
        this.idOrganizador = idOrganizador;
        this.nombreCarrete = nombreCarrete;
        this.flyerFoto = flyerFoto;
        this.fechaCarrete = fechaCarrete;
        this.horaEmpieza = horaEmpieza;
        this.horaTermino = horaTermino;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
    }

    public Long getIdOrganizador(){
        return this.idOrganizador;
    }

    public void setIdOrganizador(Long mi){
        this.idOrganizador = mi;
    }

    public String getNombreCarrete(){
        return this.nombreCarrete;
    }

    public void setNombreCarrete(String gaga){
        this.nombreCarrete = gaga;
    }

    public byte[] getFlyerFoto(){
        return this.flyerFoto;
    }

    public void setFlyerFoto(byte[] gaga){
        this.flyerFoto = gaga;
    }

    public LocalDate getFechaCarrete(){
        return this.fechaCarrete;
    }

    public void setFechaCarrete(LocalDate fechaNueva){
        this.fechaCarrete = fechaNueva;
    }

    public LocalTime getHoraEmpieza(){
        return this.horaEmpieza;
    }

    public void setHoraEmpieza(LocalTime hora){
        this.horaEmpieza = hora;
    }

    public LocalTime getHoraTermino(){
        return this.horaTermino;
    }

    public void setHoraTermino(LocalTime ga){
        this.horaTermino = ga;
    }

    public String getDireccion(){
        return this.direccion;
    }

    public void setDireccion(String ga){
        this.direccion = ga;
    }

    public Double getLatitud(){
        return this.latitud;
    }

    public void setLatitud(Double x){
        this.latitud = x;
    }

    public Double getLongitud(){
        return this.longitud;
    }

    public void setLongitud(Double ga){
        this.longitud = ga;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String ga){
        this.descripcion = ga;
    }

}
