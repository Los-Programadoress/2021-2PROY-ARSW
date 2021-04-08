package edu.eci.arsw.lacman.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.lacman.logic.Game;
import edu.eci.arsw.lacman.persistence.LacmanNotFoundException;
import edu.eci.arsw.lacman.persistence.LacmanPersistence;
import edu.eci.arsw.lacman.persistence.LacmanPersistenceException;

@Service
public class LacmanServices {

    @Autowired
    LacmanPersistence lp = null;

    /**
     * Metodo que agrega una nueva sala de juego
     * 
     * @param gameRoom - Sala de juego
     * @throws LacmanPersistenceException
     */
    public void addGameRoom(Game gameRoom) throws LacmanPersistenceException {
        lp.addGameRoom(gameRoom);
    }

    /**
     * Metodo que retorna el código de acceso de una sala de juego por el nombre
     * 
     * @param name - nombre de la sala de juego
     * @return passcode - código de acceso
     * @throws LacmanNotFoundException
     */
    public String getPasscodeByName(String name) throws LacmanNotFoundException {
        return lp.getPasscodeByName(name);
    }

    /**
     * Metodo que devuelve todas las Salas de Juego.
     * 
     * @return Colección de salas de juego
     * @throws LacmanNotFoundException
     */
    public List<Game> getAllGameRooms() throws LacmanNotFoundException {
        return lp.getAllGameRooms();
    }

}