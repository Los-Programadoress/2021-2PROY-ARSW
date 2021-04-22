package lacman;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import edu.eci.arsw.lacman.logic.Game;
import edu.eci.arsw.lacman.persistence.repository.LacmanRepository;
import edu.eci.arsw.lacmanapi.LacmanAPIAplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LacmanAPIAplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")

public class LacmanRepositoryTest {
	
	@Autowired
	LacmanRepository lacmanRepository;
	
	/**
     * Debe permitir obtener un código por el nombre.
     * Obtención válida: Debe existir el nombre para relacionarlo con el código.
     */
	@Test 
	public void shouldGetPasscodeByName(){
        Game game = new Game();
        game.setName("Milena");
        game.setPasscode("sala1");
        
        lacmanRepository.save(game);
        lacmanRepository.flush();
        
        assertEquals("sala1", lacmanRepository.getPasscodeByName("Milena"));
	}
	
	/**
     * No debe permitir obtener un código por el nombre.
     * Obtención Inválida: No debe obtener un código que no corresponde a el nombre.
     */
	@Test 
	public void shouldNotGetPasscodeByName(){
        Game game = new Game();
        game.setName("Milena");
        game.setPasscode("sala1");
        
        lacmanRepository.save(game);
        lacmanRepository.flush();
        
        assertNotSame("sala", lacmanRepository.getPasscodeByName("Milena"));
	}
}
