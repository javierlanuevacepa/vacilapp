package com.example.vacilapp.like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.vacilapp.evento.EventoServicio;
import com.example.vacilapp.usuario.UsuarioServicio;
import com.example.vacilapp.evento.Evento;
import com.example.vacilapp.usuario.Usuario;


@Service
public class LikeService {

    private final LikeRepository likeRepository;

    
    private final UsuarioServicio userService;
    
    private final EventoServicio eventService;

    @Autowired
    public LikeService(LikeRepository likeRepository,UsuarioServicio userService,EventoServicio eventService){
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.eventService = eventService;
    }

    public void eventoLikear(LikeREG like){

        LikesKey existe = new LikesKey(like.getIdEventoLikeado(),like.getIdLikeadorEvento());

        if (likeRepository.existsById(existe)){
            likeRepository.deleteById(existe);
        }else{
        Usuario userLiker = userService.getUsuarioConId(like.getIdLikeadorEvento());
        Evento eventLiked = eventService.getEventoConId(like.getIdEventoLikeado());
        likeRepository.save(new Likes(existe,eventLiked,userLiker));
        }
    }






}
