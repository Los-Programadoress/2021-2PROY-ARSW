package edu.eci.arsw.lacmanapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LacmanAPIAplication implements CommandLineRunner{
	public static void main(String[] args){
        SpringApplication.run(LacmanAPIAplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
