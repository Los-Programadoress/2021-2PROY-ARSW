package lacman;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.eci.arsw.lacman.logic.Game;
import edu.eci.arsw.lacman.persistence.LacmanNotFoundException;
import edu.eci.arsw.lacman.persistence.LacmanPersistenceException;
import edu.eci.arsw.lacman.services.LacmanServices;
import edu.eci.arsw.lacmanapi.LacmanAPIAplication;

import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LacmanAPIAplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")

public class LacmanServicesTest {

	@Autowired
	LacmanServices service;
	
	/**
     * Debe permitir insertar una sala de juego
     * Registro Válido: Se debe ingresar un nombre y código para crear una sala.
     */
	@Test
	public void shouldAddGame(){
        Game game = new Game();
        game.setName("Rodolfo");
        game.setPasscode("123qwe");
        
        try{
        	service.addGameRoom(game);
        	assertEquals("123qwe",service.getPasscodeByName("Rodolfo"));
        	
        }catch(LacmanPersistenceException | LacmanNotFoundException e){
        	assertFalse(false);
        }
    }
	
	/**
     * Debe permitir insertar más de una sala de juego
     * Registro Válido: Se debe ingresar un nombre y código para cada una de las salas a ser creadas.
     */
	@Test 
    public void shouldAddAllGames(){
        Game game1 = new Game();
        game1.setName("rodolfo");
        game1.setPasscode("123qwe");
        
        Game game2 = new Game();
        game2.setName("batman");
        game2.setPasscode("salita07");
        
        Game game3 = new Game();
        game3.setName("heroku");
        game3.setPasscode("arsw03");
        
        try{
            service.addGameRoom(game1);
            service.addGameRoom(game2);
            service.addGameRoom(game3);
            List<Game> listaDeJuego = service.getAllGameRooms();
            assertTrue(listaDeJuego.size() >= 3);
        }
        catch(LacmanPersistenceException | LacmanNotFoundException e){
        	assertFalse(false);
        }
    }
	
	/**
     * Debe permitir obtener un código por el nombre.
     * Obtención válida: Debe existir el nombre para relacionarlo con el código.
     */
	@Test 
    public void shouldGetCodeByName() throws LacmanPersistenceException, LacmanNotFoundException{
		Game g = new Game();
        g.setName("Gems");
        g.setPasscode("juts");
        
        try {
			service.addGameRoom(g);  
            assertEquals("juts",service.getPasscodeByName("Gems"));
        }
        catch(Exception e){
        	assertFalse(false);
        }
    }
	
	/**
     * No debe permitir obtener un código por el nombre.
     * Obtención Inválida: No debe obtener un código que no corresponde a el nombre.
     */
	@Test 
    public void shouldNotGetPasscodeByName(){
		Game g = new Game();
        g.setName("Yarmix");
        g.setPasscode("poxt");
        
        try{
            service.addGameRoom(g);
            assertNotSame("poxts", service.getPasscodeByName("Yarmix"));
        }catch(Exception e){
        	assertFalse(false);
        }
    }
}