package com.example.vacilapp.usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import java.util.List;


@Configuration
public class UsuarioConfig {

    @Bean
    CommandLineRunner UsuarioCommandLineRunner(UsuarioRepository usuarioRepository){
        return args ->{
            

        };
    }

}
