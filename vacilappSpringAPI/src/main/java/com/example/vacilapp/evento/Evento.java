package com.example.vacilapp.evento;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import com.example.vacilapp.like.Likes;
import com.example.vacilapp.comentario.Comentario;
import com.example.vacilapp.like.LikesDTO;
import com.example.vacilapp.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Evento {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_sequence", allocationSize = 1)
    private Long idEvento;

    @ManyToOne
    @JoinColumn(name = "id_organizador", nullable = false)
    @JsonBackReference
    private Usuario organizador;

    @Column(nullable = false)
    private String nombreCarrete;

    @Lob
    @Column(name = "flyer", nullable = true)
    private byte[] flyer;

    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(nullable = false)
    private LocalDate fechaCarrete;

    @Column(nullable = false)
    private LocalTime horaEmpieza;

    private LocalTime horaTermino;


    @Column(nullable = false)
    private String direccion;

    //@Column(name = "latitud", precision = 9, scale = 6)
    private Double latitud;

    //@Column(name = "longitud", precision = 9, scale = 6)
    private Double longitud;

   
    private String descripcion;


    @OneToMany(mappedBy = "eventoLikeado", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Likes> likesEvento;


    @OneToMany(mappedBy = "eventoComentado", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Comentario> comentariosEvento;


    @Transient
    int diasParaMambo;

    


    

    public Evento(){}

    public Evento(Long idEvento,String nombreCarrete,Usuario organizador,byte[] flyer,LocalDateTime fechaRegistro,
    LocalDate fechaCarrete,LocalTime horaEmpieza,LocalTime horaTermino,String direccion,
    Double latitud,Double longitud,String descripcion){
        this.idEvento = idEvento;
        this.organizador = organizador;
        this.nombreCarrete = nombreCarrete;
        this.flyer = flyer;
        this.fechaRegistro = fechaRegistro;
        this.fechaCarrete = fechaCarrete;
        this.horaEmpieza = horaEmpieza;
        this.horaTermino = horaTermino;

        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
    }

    public Evento(Usuario organizador,String nombreCarrete,byte[] flyer,LocalDate fechaCarrete,LocalTime horaEmpieza,LocalTime horaTermino,String direccion,Double latitud,Double longitud,String descripcion){
        this.organizador = organizador;
        this.nombreCarrete = nombreCarrete;
        this.flyer = flyer;
        this.fechaRegistro = LocalDateTime.now();
        this.fechaCarrete = fechaCarrete;
        this.horaEmpieza = horaEmpieza;
        this.horaTermino = horaTermino;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
    }

    public Long getIdEvento(){
        return this.idEvento;
    }

    public void setIdEvento(Long da){
        this.idEvento = da;
    }

    public Usuario getOrganizador(){
        return this.organizador;
    }

    public void setOrganizador(Usuario ga){
        this.organizador = ga;
    }

    public String getUserNameOrganizador(){
        return this.organizador.getNombreUsuario();
    }

    public String getNombreCarrete(){
        return this.nombreCarrete; 
    }

    public void setNombreCarrete(String ga){
        this.nombreCarrete = ga;
    }

    public byte[] getFlyer(){
        return this.flyer;
    }

    public void setFlyer(byte[] newFLyer){
        this.flyer = newFLyer;
    }

    public LocalDateTime getFechaRegistro(){
        return this.fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime x){
        this.fechaRegistro = x;
    }

    public LocalDate getFechaCarrete(){
        return this.fechaCarrete;
    }

    public void setFechaCarrete(LocalDate se){
        this.fechaCarrete = se; 
    }

    public LocalTime getHoraEmpieza(){
        return this.horaEmpieza;
    }

    public void setHoraEmpieza(LocalTime x){
        this.horaEmpieza = x;
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

    public void setDireccion(String ns){
        this.direccion = ns;
    }

    public Double getLatitud(){
        return this.latitud;
    }

    public void setLatitud(Double ga){
        this.latitud = ga;
    }

    public Double getLongitud(){
        return this.longitud;
    }

    public void setLongitud(Double sa){
        this.longitud = sa;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String nana){
        this.descripcion = nana;
    }

    public int getLikesEventoSaa(){
        return this.likesEvento.size();
    }


    public List<LikesDTO> getLikesDetalles(){
        List<LikesDTO> likesFormateados = new ArrayList<>();
        if (!this.likesEvento.isEmpty()){
            for (Likes x : this.likesEvento){
                likesFormateados.add(new LikesDTO(x));
            }
        }
        return likesFormateados;
    }

    public List<EventoComentariosDTO> getComentariosF(){
        List<EventoComentariosDTO> comentariosFormateados = new ArrayList<>();

        if (!comentariosEvento.isEmpty()){
            for (Comentario x : comentariosEvento){
                comentariosFormateados.add(new EventoComentariosDTO(x.getIdComentario(), x.getUsuarioComentador().getFotoPerfil(),
                 x.getUsuarioComentador().getNombreUsuario(), x.getFechaRegistro(),x.getComentario()));
            }
        }
        return comentariosFormateados;
    }


    
    public Integer getDiasParaEvento() {
        Integer diasFaltan = Period.between(LocalDate.now(),this.fechaCarrete).getDays();
        return diasFaltan;
    }

}
