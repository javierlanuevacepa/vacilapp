package com.example.vacilapp.tipousuario;

import com.example.vacilapp.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class TipoUsuario {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_usuario_seq")
    @SequenceGenerator(name = "tipo_usuario_seq", sequenceName = "tipo_usuario_sequence", allocationSize = 1)
    private Long idTipo;

    @Column(nullable = false, unique = true)
    private String descripcionTipoUs;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoUsuario", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;


    public TipoUsuario(){}

    public TipoUsuario(Long idTipo,String descripcionTipoUs){
        this.idTipo = idTipo;
        this.descripcionTipoUs = descripcionTipoUs;
    }

    public TipoUsuario(String descripcionTipoUs){
        this.descripcionTipoUs = descripcionTipoUs;
    }



    public Long getIdTipo(){
        return this.idTipo;
    }

    public void setIdTipo(Long id){
        this.idTipo = id;
    }

    public String getDesc(){
        return this.descripcionTipoUs;
    }

    public void setDesc(String di){
        this.descripcionTipoUs = di;
    }

    public List<Usuario> getUsuarios(){
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
