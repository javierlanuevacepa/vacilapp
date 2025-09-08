package com.example.vacilapp.comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vacilapp.tipousuario.TipoUsuarioServicio;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;

@RestController
@RequestMapping(path = "carretapp/v0/comentario")
public class ComentarioController {
    private final ComentarioServicio comentarioServicio; 

    @Autowired
    public ComentarioController(ComentarioServicio comentarioServicio){
        this.comentarioServicio = comentarioServicio;
    }

    @PostMapping()
    public void comentarEvento(@RequestBody ComentarioREG comen){
        comentarioServicio.registrarComentario(comen);
    }
    



}
