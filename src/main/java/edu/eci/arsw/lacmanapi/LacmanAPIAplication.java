package edu.eci.arsw.lacmanapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("edu.eci.arsw.lacman.persistence")
@EntityScan("edu.eci.arsw.lacman.logic")
@ComponentScan(basePackages = {"edu.eci.arsw.lacman"})
public class LacmanAPIAplication{
	public static void main(String[] args){
        SpringApplication.run(LacmanAPIAplication.class, args);
    }
}