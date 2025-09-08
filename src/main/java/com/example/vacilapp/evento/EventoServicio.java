package com.example.vacilapp.evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vacilapp.tipousuario.TipoUsuarioServicio;
import com.example.vacilapp.usuario.Usuario;
import com.example.vacilapp.usuario.UsuarioREG;
import com.example.vacilapp.usuario.UsuarioServicio;

import java.util.List;

@Service
public class EventoServicio {
    private final EventoRepository eventoRepository;



    private final UsuarioServicio usuarioService;
    
    @Autowired
    public EventoServicio(EventoRepository eventoRepository,UsuarioServicio usuarioService){
        this.eventoRepository = eventoRepository;
        this.usuarioService = usuarioService;

    }

    public List<Evento> getAllEventos(){
        return this.eventoRepository.findAll();
    }

    public void registrarEvento(EventoREG event){
        //OBVIAMENTE AÑADIRLE TODAS LAS VALIDACIONES

        Usuario organizador = usuarioService.getUsuarioConId(event.getIdOrganizador());
        

        eventoRepository.save(new Evento(organizador,event.getNombreCarrete(),event.getFlyerFoto(),event.getFechaCarrete(),event.getHoraEmpieza(),
        event.getHoraTermino(),event.getDireccion(),event.getLatitud(),event.getLongitud(),event.getDescripcion()));
    }

    public Evento getEventoConId(Long ids){
        return eventoRepository.findById(ids).orElseThrow(()->new IllegalStateException("Evento con Id:"+ids+" no encontrado."));
    }


    public List<Evento> getEventosEnElRadio(double latitudUser,double longitudUser,double cuantosKm){
        return eventoRepository.encontrarEventosEnElRadioDe(latitudUser, longitudUser, cuantosKm);
    }

}
