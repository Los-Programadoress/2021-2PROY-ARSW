package lacman;

import edu.eci.arsw.lacmanapi.LacmanAPIAplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = LacmanAPIAplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")

public class LacmanControllerTest {
	
	@Autowired
	WebApplicationContext wac;
	MockMvc mockMvc;
	

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
     * Debe permitir obtener todas las sala de juego
     * Registro Válido: Se deben obtener las salas de juego registradas en la base de datos.
     */
	@Test
	public void shoulGetAllGameRooms() throws Exception{
        mockMvc.perform(get("/lacman")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isAccepted());
	}
	
	/**
     * Debe permitir obtener al menos una sala de juego
     * Registro Válido: Se debe obtener al menos una sala de juego de todas las registradas en la base de datos.
     */
	@Test
	public void shoulGetAtLeastOneGameRoom() throws Exception{
        mockMvc.perform(get("/lacman")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isAccepted())
        		.andExpect(jsonPath("$[0].name", is("prueba")))
        		.andExpect(jsonPath("$[0].passcode", is("pruebit4")));
        
	}
	
	/**
     * Debe permitir obtener un código por el nombre.
     * Registro Válido: Se debe obtener el código de la sala por el nombre.
     */
	@Test
	public void shoulGetPasscodeByName() throws Exception{
		 mockMvc.perform(get("/lacman/prueba")
	        		.contentType(MediaType.APPLICATION_JSON))
	        		.andExpect(status().isAccepted())
	        		.andExpect(content().string("pruebit4"));
		
	}
}
