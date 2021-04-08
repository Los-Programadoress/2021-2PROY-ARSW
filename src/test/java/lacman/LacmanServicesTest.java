package lacman;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LacmanAPIAplication.class)
public class LacmanServicesTest {

	@Autowired
	LacmanServices service;
	
	/*@Test 
	public void shouldAddGame(){
        Game g = new Game();
        g.setName("rodolfo");
        g.setPasscode("123qwe");

        try{
            service.addGameRoom(g);
            List<Game> listaDeJuego = service.getAllGameRooms();
            for(Game lista : listaDeJuego) {
            	if(lista.getName().equals("rodolfo") && lista.getPasscode().equals("123qwe")) {
            		assertEquals(g.getName(),lista.getName());
            		break;
            	}
            }
        }catch(LacmanPersistenceException e){
            fail("No fue posible agregar la sala de juego");
        }
        catch(LacmanNotFoundException e ) {
        	fail("No se encontró el juego en la sala");
        }
    }*/
	
	/*@Test 
    public void shouldAddAllGames(){
        Game g1 = new Game();
        g1.setName("rodolfo");
        g1.setPasscode("123qwe");
        
        Game g2 = new Game();
        g2.setName("batman");
        g2.setPasscode("salita07");
        
        Game g3 = new Game();
        g3.setName("heroku");
        g3.setPasscode("arsw03");
        
        try{
            service.addGameRoom(g1);
            service.addGameRoom(g2);
            service.addGameRoom(g3);
            List<Game> listaDeJuego = service.getAllGameRooms();
            assertEquals(listaDeJuego.size(),3);
        }
        catch(LacmanPersistenceException e){
            fail("No fue posible agregar la sala de juego");
        }
        catch(LacmanNotFoundException e ) {
        	fail("No se encontro el juego en la sala");
        }
    }*/
	
	/*@Test 
    public void shouldGetCodeByName() throws LacmanPersistenceException, LacmanNotFoundException{
		Game g = new Game();
        g.setName("rodolfo");
        g.setPasscode("123qwe");
        try {
			service.addGameRoom(g);  
            assertEquals("123qwe",service.getPasscodeByName("rodolfo"));
        }catch(Exception e){
            fail("Debería obtener el código de la sala de juego.");
        }
    }*/
	
	/*@Test 
    public void shouldNotGetCodeByName(){
		Game g = new Game();
        g.setName("rodolfo");
        g.setPasscode("123qwe");
        try{
            service.addGameRoom(g);
            assertNotSame(service.getPasscodeByName("rodolfo"),"123qwer");
        }catch(Exception e){
            fail("No deberia obtener el codigo del juego.");
        }
    }*/
}