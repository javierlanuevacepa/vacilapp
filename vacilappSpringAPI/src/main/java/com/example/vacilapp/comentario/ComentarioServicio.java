package com.example.vacilapp.comentario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.vacilapp.evento.EventoServicio;
import com.example.vacilapp.evento.Evento;
import com.example.vacilapp.usuario.UsuarioServicio;
import com.example.vacilapp.usuario.Usuario;

@Service
public class ComentarioServicio {

    private final ComentarioRepository comentarioRepository;

    private final UsuarioServicio usuarioServicio;

    private final EventoServicio eventoServicio;


    @Autowired
    public ComentarioServicio(ComentarioRepository comentarioRepository,UsuarioServicio usuarioServicio,EventoServicio eventoServicio){
        this.comentarioRepository = comentarioRepository;
        this.usuarioServicio = usuarioServicio;
        this.eventoServicio = eventoServicio;
    }


    public void registrarComentario(ComentarioREG comen){
        comentarioRepository.save(new Comentario(usuarioServicio.getUsuarioConId(comen.getIdUsuario()),eventoServicio.getEventoConId(comen.getIdEvento()),comen.getComentario()));
    }

    public void eliminarComentario(Long userId,Long eventId){
       comentarioRepository.deleteById(getComentarioOb(userId, eventId).getIdComentario());;
   }

   public Comentario getComentarioOb(Long userId,Long eventId){
       return comentarioRepository.getIdComentarioConUserEvento(userId, eventId).orElseThrow(()->new IllegalStateException("Usuario o evento no encontrado."));
    }







}
