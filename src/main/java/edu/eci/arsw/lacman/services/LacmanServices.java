package edu.eci.arsw.lacman.services;

import java.util.List;
import java.util.Set;

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

    public void addGameRoom(Game gameRoom) throws LacmanPersistenceException {
    	System.out.println("entro");
        lp.addGameRoom(gameRoom);
    }

    public String getPasscodeByName(String name) throws LacmanNotFoundException {
        return lp.getPasscodeByName(name);
    }
    
    /**
     * Metodo encargado de retornar todos las Salas de Juego
     * 
     * @return Colección de salas de juego
     * @throws BlueprintNotFoundException
     */
	public List<Game> getAllGameRooms() throws LacmanNotFoundException {
		return lp.getAllGameRooms();
	}

}