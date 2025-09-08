package com.example.vacilapp.evento;
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

@RequestMapping(path = "carretapp/v0/evento")
public class EventoController {

    private final EventoServicio eventoServicio;

    @Autowired
    public EventoController(EventoServicio eventoServicio){
        this.eventoServicio = eventoServicio;
    }

    @GetMapping
    public List<Evento> getAllEventos(){
        return eventoServicio.getAllEventos();
    }

    @PostMapping
    public void registrarEvento(@RequestBody EventoREG evento){
        eventoServicio.registrarEvento(evento);
    }


    @GetMapping("enRadiode/{latitudUser}/{longitudUser}/{cuantosKm}")
    public List<Evento> getEventosEnRadioDe(@PathVariable("latitudUser") double latitudUser,@PathVariable("longitudUser") double longitudUser,@PathVariable("cuantosKm") double cuantosKm){
        return eventoServicio.getEventosEnElRadio(latitudUser, longitudUser, cuantosKm);
    }
    

    


}
