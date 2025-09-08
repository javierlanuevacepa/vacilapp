package com.example.vacilapp.like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vacilapp.tipousuario.TipoUsuarioServicio;
import com.example.vacilapp.usuario.UsuarioREG;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;


@RestController

@RequestMapping(path = "carretapp/v0/like")
public class LikesController {


    private final LikeService likeServicio;

    @Autowired
    public LikesController(LikeService likeServicio){
        this.likeServicio = likeServicio;
    }

    


    @PostMapping(path = "usuario/{idUserLiker}/evento/{idEventoLiked}")
    public void likearEvento(@PathVariable("idUserLiker") Long idUsuarioLike,@PathVariable("idEventoLiked") Long idEventLiked){
        likeServicio.eventoLikear(new LikeREG(idEventLiked,idUsuarioLike));;
    }


}
