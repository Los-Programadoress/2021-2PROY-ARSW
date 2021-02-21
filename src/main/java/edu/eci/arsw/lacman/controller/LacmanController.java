package edu.eci.arsw.lacman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.lacman.service.LacmanServices;


/**
 * Controlador principal del proyecto Lacman
 */
@RestController
@RequestMapping(value = "/lacman")
public class LacmanController {
	
	@Autowired
	LacmanServices ls;
    
	/**
     * Clase de hello lacman
     * @return - String de bienvenido
     */
    @RequestMapping("/hello-lacman")
    public String helloLacman() {
        return "Bienvenidos a Lacman";
    }
}
