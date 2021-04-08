package edu.eci.arsw.lacman.persistence.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.lacman.logic.Game;
import edu.eci.arsw.lacman.persistence.LacmanNotFoundException;
import edu.eci.arsw.lacman.persistence.LacmanPersistence;
import edu.eci.arsw.lacman.persistence.LacmanPersistenceException;
import edu.eci.arsw.lacman.persistence.repository.LacmanRepository;

@Repository
public class LacmanPersistenceImpl implements LacmanPersistence {

	@Autowired
	LacmanRepository lr;

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void addGameRoom(Game gameRoom) throws LacmanPersistenceException {
		Query query = entityManager.createNativeQuery("insert into games (name,passcode) values (?,?)", Game.class);
		query.setParameter(1, gameRoom.getName()).setParameter(2, gameRoom.getPasscode());
		Game newgame = new Game();
		newgame.setName(gameRoom.getName());
		newgame.setPasscode(gameRoom.getPasscode());
		lr.save(newgame);
	}

	@Override
	public String getPasscodeByName(String name) throws LacmanNotFoundException {
		String passcode = lr.getPasscodeByName(name);
		if (passcode == null) {
			throw new LacmanNotFoundException("The passcode does not exist with player's name: " + name);
		}
		return passcode;
	}

	@Override
	public List<Game> getAllGameRooms() throws LacmanNotFoundException {
		if (lr.count() == 0) {
			throw new LacmanNotFoundException("Games not found!");
		}
		return lr.findAll();
	}
}
