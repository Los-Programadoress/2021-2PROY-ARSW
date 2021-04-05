package edu.eci.arsw.lacman.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.lacman.logic.Game;

@Repository
public interface LacmanRepository extends JpaRepository<Game, Long> {
	
	/**
     * Obtiene el código de acceso con el nombre de la Sala de Juego
     *
     * @param name - nombre de la Sala de Juego
     * @return El codigo de la Sala de Juego
     */
    @Query(value = "select passcode from games where name =:name", nativeQuery = true)
    String getPasscodeByName(@Param("name") String name);
}