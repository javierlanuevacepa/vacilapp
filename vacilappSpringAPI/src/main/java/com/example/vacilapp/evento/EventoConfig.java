package com.example.vacilapp.evento;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.example.vacilapp.usuario.Usuario;


import com.example.vacilapp.usuario.UsuarioServicio;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;



@Configuration
public class EventoConfig {
    @Bean
    CommandLineRunner EventoCommandLineRunner(EventoRepository eventoRepository){
        return args ->{


        };
    }
}
