package co.edu.unbosque.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import model.Player;
import model.enums.UserRole;
import model.persistence.dao.PlayerDAO;
import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas unitarias para verificar el funcionamiento del DAO de jugadores (PlayerDAO).
 * Se evalúan operaciones de agregar, eliminar, actualizar, buscar y recuperar todos los jugadores.
 */
public class PlayerDAOTest {

    private PlayerDAO playerDAO;
    private Player playerSnipeX;
    private Player playerNovaStrike;

    /**
     * Inicializa los datos de prueba antes de cada test.
     * También elimina los jugadores si ya existían para evitar duplicados.
     */
    @Before
    public void setUp() {
        playerDAO = new PlayerDAO();

        playerSnipeX = new Player(101, "Jake", "Hunter", "snipex@valor.gg", "headshot99", "USA", "Dallas",
                LocalDate.of(1998, 3, 14), UserRole.PLAYER);

        playerNovaStrike = new Player(202, "Lena", "Park", "novastrike@aetheresports.com", "nova2024", "South Korea", "Seoul",
                LocalDate.of(2001, 8, 22), UserRole.PLAYER);

        if (playerDAO.find(playerSnipeX) != null) {
            playerDAO.delete(playerSnipeX);
        }

        if (playerDAO.find(playerNovaStrike) != null) {
            playerDAO.delete(playerNovaStrike);
        }
    }

    /**
     * Verifica que un jugador nuevo se agregue correctamente al DAO.
     */
    @Test
    public void addNewPlayerShouldBeAddedSuccessfully() {
        boolean wasAdded = playerDAO.add(playerSnipeX);
        assertTrue(wasAdded);

        Player foundPlayer = playerDAO.find(playerSnipeX);
        assertNotNull(foundPlayer);
        assertEquals("Jake", foundPlayer.getFirstName());
    }

    /**
     * Verifica que un jugador duplicado no pueda ser agregado nuevamente.
     */
    @Test
    public void addDuplicatePlayerShouldNotBeAdded() {
        playerDAO.add(playerSnipeX);
        boolean wasAddedAgain = playerDAO.add(playerSnipeX);
        assertFalse(wasAddedAgain);
    }

    /**
     * Verifica que un jugador existente pueda ser eliminado correctamente.
     */
    @Test
    public void deleteExistingPlayerShouldBeRemoved() {
        playerDAO.add(playerNovaStrike);
        boolean wasDeleted = playerDAO.delete(playerNovaStrike);
        assertTrue(wasDeleted);

        Player foundPlayer = playerDAO.find(playerNovaStrike);
        assertNull(foundPlayer);
    }

    /**
     * Verifica que un jugador existente pueda ser actualizado con nuevos datos.
     */
    @Test
    public void updateExistingPlayerShouldReplaceWithNewData() {
        playerDAO.add(playerSnipeX);

        Player updatedSnipeX = new Player(101, "Jake", "Hunter", "snipex@neworg.gg", "elite99", "USA", "San Francisco",
                LocalDate.of(1998, 3, 14), UserRole.PLAYER);

        boolean wasUpdated = playerDAO.update(playerSnipeX, updatedSnipeX);
        assertTrue(wasUpdated);

        Player foundUpdatedPlayer = playerDAO.find(updatedSnipeX);
        assertNotNull(foundUpdatedPlayer);
        assertEquals("San Francisco", foundUpdatedPlayer.getCity());
        assertEquals("snipex@neworg.gg", foundUpdatedPlayer.getEmail());
    }

    /**
     * Verifica que la lista de todos los jugadores contenga aquellos que fueron agregados.
     */
    @Test
    public void getAllPlayersShouldContainAddedPlayers() {
        playerDAO.add(playerSnipeX);
        playerDAO.add(playerNovaStrike);

        List<Player> allPlayers = playerDAO.getAll();
        boolean foundSnipeX = false;
        boolean foundNovaStrike = false;

        for (Player player : allPlayers) {
            if (player.getEmail().equals("snipex@valor.gg")) {
                foundSnipeX = true;
            }
            if (player.getEmail().equals("novastrike@aetheresports.com")) {
                foundNovaStrike = true;
            }
        }

        assertTrue(foundSnipeX);
        assertTrue(foundNovaStrike);
    }
}
