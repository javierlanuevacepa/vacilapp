package com.example.vacilapp.tipousuario;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioServicio {

    private final TipoUsuarioRepository tipoUsuarioRepo;


    public TipoUsuarioServicio(TipoUsuarioRepository tipoUsuarioRepo){
        this.tipoUsuarioRepo = tipoUsuarioRepo;
    }

    public List<TipoUsuario> getTipoUsuarios(){
        return this.tipoUsuarioRepo.findAll();
    }

    public TipoUsuario getTipoUsuarioConId(Long idBuscar){
        return this.tipoUsuarioRepo.findById(idBuscar).orElseThrow(()->new IllegalStateException("Tipo de usuario con:"+idBuscar+" no encontrado."));
    }


}
