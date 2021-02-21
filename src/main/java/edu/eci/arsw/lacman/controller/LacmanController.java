package edu.eci.arsw.lacman.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador principal del proyecto Lacman
 */
@RestController
@RequestMapping(value = "/lacman")
public class LacmanController {
	/**
     * Clase de hello lacman
     * @return - String de bienvenido
     */
    @RequestMapping("/hello-lacman")
    public String helloLacman() {
        return "Bienvenidos a Lacman";
    }
}
