package edu.eci.arsw.lacman.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.lacman.logic.Game;
import edu.eci.arsw.lacman.persistence.LacmanNotFoundException;
import edu.eci.arsw.lacman.persistence.LacmanPersistenceException;
import edu.eci.arsw.lacman.services.LacmanServices;

/**
 * Controlador principal del proyecto Lacman
 */
@RestController
@RequestMapping(value = "/lacman")
@CrossOrigin(origins = "*")
public class LacmanController {

    @Autowired
    LacmanServices ls = null;

    /**
     * Obtiene las Salas de juego
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllGameRooms() {
        try {
            return new ResponseEntity<>(ls.getAllGameRooms(), HttpStatus.ACCEPTED);
        } catch (LacmanNotFoundException e) {
            Logger.getLogger(LacmanController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Agrega una nueva Sala de juego
     * 
     * @param gameRoom - Sala de Juego
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addGameRoom(@RequestBody Game gameRoom) {
        try {
            ls.addGameRoom(gameRoom);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (LacmanPersistenceException ex) {
            Logger.getLogger(LacmanController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
    
    /**
     * Obtiene el código de acceso por el nombre de la Sala de juego
     * 
     * @param name - nombre de la Sala de Juego lacman/name
     */
    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getPasscodeByName(@PathVariable("name") String name) {
        try {
            return new ResponseEntity<>(ls.getPasscodeByName(name), HttpStatus.ACCEPTED);
        } catch (LacmanNotFoundException ex) {
            Logger.getLogger(LacmanController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     * Validar si es código pertence a una sala existente
     * 
     * @param passcode - Código de la Sala de Juego lacman/passcode
     */
    @RequestMapping(path = "/passcode",method = RequestMethod.POST)
    public ResponseEntity<?> isPasscode(@RequestBody String passcode){
        try {
        	ls.isPasscode(passcode);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (LacmanNotFoundException ex) {
            Logger.getLogger(LacmanController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}