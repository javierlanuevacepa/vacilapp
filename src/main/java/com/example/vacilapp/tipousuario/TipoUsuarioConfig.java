package com.example.vacilapp.tipousuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.example.vacilapp.evento.Evento;
import com.example.vacilapp.evento.EventoRepository;
import com.example.vacilapp.usuario.Usuario;
import com.example.vacilapp.usuario.UsuarioRepository;
import com.example.vacilapp.usuario.UsuarioServicio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Configuration
public class TipoUsuarioConfig {
    @Bean
    CommandLineRunner TipoUsuariocommandLineRunner(TipoUsuarioRepository repositoryTup,TipoUsuarioServicio tipoService,UsuarioRepository usuarioRepository,
    UsuarioServicio userService,EventoRepository eventReposit){
        return args ->{


            repositoryTup.saveAll(
                List.of(new TipoUsuario("Usuario verificado"),new TipoUsuario("Usuario no verificado"),new TipoUsuario("Recinto"))
            );

            usuarioRepository.saveAll(
                List.of(new Usuario("Magno","wesker@gmail.com","123",null,tipoService.getTipoUsuarioConId(1L)))
            );

            eventReposit.saveAll(
                List.of(new Evento(userService.getUsuarioConId(1L),"Carrete Casa Magno Demonio",null,LocalDate.of(2024, 12, 12),LocalTime.of(22, 0, 0),
            null,"Jose Joaquin Prieto 5363",-33.499748,-70.666624,"Casa wesker mambo"),
            
            new Evento(userService.getUsuarioConId(1L),"La facultad Discoteca",null,LocalDate.of(2024, 10, 05),LocalTime.of(22, 0, 0),
            null,"Pío Nono 398",-33.430645,-70.636272,"La facultad mambo discoteca"),

            new Evento(userService.getUsuarioConId(1L),"Parselaso",null,LocalDate.of(2024, 10, 05),LocalTime.of(22, 0, 0),
            null,"Gagaga",-33.276762, -70.756246,"Parselado"),

            new Evento(userService.getUsuarioConId(1L),"Martido",null,LocalDate.of(2024, 10, 05),LocalTime.of(22, 0, 0),
            null,"Mardito",-33.448362, -70.699634,"Martido"),

            new Evento(userService.getUsuarioConId(1L),"Martido sutro agilao",null,LocalDate.of(2024, 10, 05),LocalTime.of(22, 0, 0),
            null,"Mardito 123",-33.463854, -70.660798,"Mardito sutro agilao")

            )
            );






        };
    }
}
