package edu.eci.arsw.lacman.persistence;

import java.util.List;
import java.util.Set;
import edu.eci.arsw.lacman.logic.Game;


public interface LacmanPersistence {

	void addGameRoom(Game gameRoom) throws LacmanPersistenceException;

	String getPasscodeByName(String name) throws LacmanNotFoundException;

	List<Game> getAllGameRooms() throws LacmanNotFoundException;
}
