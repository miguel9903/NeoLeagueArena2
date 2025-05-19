package co.edu.unbosque.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.Player;
import co.edu.unbosque.model.Team;
import co.edu.unbosque.model.UserRole;

/**
 * Clase de prueba unitaria para la clase Player.
 * Se enfoca en validar el correcto funcionamiento de los atributos y métodos propios de Player,
 * así como los heredados de la clase User.
 */

public class PlayerTest {

    private Player player;
    /**
     * Objeto Team simulado que se usará para probar la asignación de equipo en el jugador.
     */
    private Team mockTeam;

    /**
     * Método de configuración que se ejecuta antes de cada prueba.
     * Inicializa un objeto Player con datos válidos y un equipo simulado.
     */
    @Before
    public void setUp() {
        player = new Player(1, "Gabriel", "Amortegui", "gamorteguih@unbosque.edu.co", "124534", "Colombia", "Bogotá",
                LocalDate.of(2000, 1, 1), UserRole.PLAYER);

        mockTeam = new Team();
        mockTeam.setName("Team A");
    }
    
    /**
     * Verifica que el constructor de Player inicializa correctamente todos los atributos heredados de User.
     */
    @Test
    public void testConstructorConDatos() {
       
        assertEquals("Player ID not set correctly", 1, player.getId());
        assertEquals("First name mismatch", "Gabriel", player.getFirstName());
        assertEquals("Last name mismatch", "Amortegui", player.getLastName());
        assertEquals("Email mismatch", "gamorteguih@unbosque.edu.co", player.getEmail());
        assertEquals("Country mismatch", "Colombia", player.getCountry());
        assertEquals("City mismatch", "Bogotá", player.getCity());
        assertEquals("Birth date mismatch", LocalDate.of(2000, 1, 1), player.getBirthDate());
        assertEquals("User role mismatch", UserRole.PLAYER, player.getRole());
    }
    
    
    /**
     * Verifica que se pueda asignar y recuperar correctamente el apodo (nickName) del jugador.
     */
    @Test
    public void testSetAndGetNickName() {
  
        player.setNickName("Juanchito");
        assertEquals("Nickname was not set correctly", "Juanchito", player.getNickName());
    }

    /**
     * Verifica que se pueda asignar y recuperar correctamente el nivel de experiencia del jugador.
     */
    @Test
    public void testSetAndGetExperienceLevelValido() {
      
        player.setExperienceLevel(5);
        assertEquals("Experience level mismatch", 5, player.getExperienceLevel());
    }
    
    /**
     * Verifica que se pueda asignar y recuperar correctamente el equipo actual del jugador.
     */
     @Test
    public void testAsignarEquipo() {
      
        player.setCurrentTeam(mockTeam);
        assertNotNull("Current team should not be null", player.getCurrentTeam());
        assertEquals("Team name mismatch", "Team A", player.getCurrentTeam().getName());
    }
}
