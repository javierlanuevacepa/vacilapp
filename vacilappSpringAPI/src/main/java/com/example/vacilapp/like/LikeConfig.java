package com.example.vacilapp.like;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;



@Configuration
public class LikeConfig {

     @Bean
    CommandLineRunner likeCommandLineRunner(LikeRepository likeRepository){
        return args ->{


        };
    }
}
