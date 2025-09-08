package com.example.vacilapp.tipousuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;


@RestController

@RequestMapping(path = "carretapp/v0/tipousuario")
public class TipoUsuarioController {

    
    private final TipoUsuarioServicio tipoUsuarioServicio;


    @Autowired
    public TipoUsuarioController(TipoUsuarioServicio tipoUsuarioServicio){
        this.tipoUsuarioServicio = tipoUsuarioServicio;
    }

    @GetMapping
    public List<TipoUsuario> getTipoUsuarios() {
        return tipoUsuarioServicio.getTipoUsuarios();
    }
    


}
