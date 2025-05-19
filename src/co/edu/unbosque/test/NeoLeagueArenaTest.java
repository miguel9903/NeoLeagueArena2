package co.edu.unbosque.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import model.NeoLeagueArena;
import model.enums.UserRole;
import model.persistence.dto.PlayerDTO;
import model.persistence.dto.TeamDTO;
import model.persistence.dto.UserDTO;

import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas unitarias para la clase NeoLeagueArena.
 *
 * Este conjunto de pruebas valida funciones esenciales de la plataforma,
 * incluyendo el registro, autenticación y gestión de jugadores y equipos.
 */
public class NeoLeagueArenaTest {

    private NeoLeagueArena arena;
    private PlayerDTO fakerPlayer;
    private TeamDTO t1Team;

    /**
     * Inicializa los datos de prueba antes de cada test.
     *
     * Crea un jugador (Faker) y un equipo (T1), y los guarda en el sistema para su uso en las pruebas.
     */
    @Before
    public void setUp() {
        arena = new NeoLeagueArena();

        fakerPlayer = new PlayerDTO();
        fakerPlayer.setId(101);
        fakerPlayer.setFirstName("Lee");
        fakerPlayer.setLastName("Sang-hyeok");
        fakerPlayer.setEmail("faker@t1.gg");
        fakerPlayer.setPassword("unkillable");
        fakerPlayer.setCountry("South Korea");
        fakerPlayer.setCity("Seoul");
        fakerPlayer.setBirthDate(LocalDate.of(1996, 5, 7).toString());
        fakerPlayer.setNickName("Faker");
        fakerPlayer.setRole(UserRole.PLAYER.name());

        arena.addPlayer(fakerPlayer);


        t1Team = new TeamDTO();
        t1Team.setId(301);
        t1Team.setName("T1");
        t1Team.setDescription("Legendary South Korean esports team");

        arena.addTeam(t1Team);
        arena.saveTeams();
        arena.loadTeams();
    }


    /**
     * Verifica que el sistema rechace una autenticación con credenciales incorrectas.
     */
    @Test
    public void authenticateUserInvalidCredentials_returnsNull() {
        UserDTO result = arena.authenticateUser("faker@t1.gg", "wrongpass");
        assertNull("Authentication should fail with invalid credentials", result);
    }

    /**
     * Verifica que un nombre de equipo existente sea correctamente identificado como registrado.
     */
    @Test
    public void teamNameExistsExistingTeam_returnsTrue() {
        List<TeamDTO> teams = arena.getAllTeams();
        assertNotNull("Team list should not be null", teams);
        assertFalse("Team list should not be empty", teams.isEmpty());

        boolean found = false;
        for (TeamDTO team : teams) {
            if (team.getName().equalsIgnoreCase("T1")) {
                found = true;
                break;
            }
        }

        assertTrue("Team name 'T1' should exist", found);
    }

    /**
     * Verifica que un nombre de equipo no existente sea detectado como disponible.
     */
    @Test
    public void teamNameExistsNonExistingTeam_returnsFalse() {
        boolean exists = arena.teamNameExists("G2 Esports");
        assertFalse("Team name 'G2 Esports' should not exist", exists);
    }

    /**
     * Verifica que los datos de un jugador puedan actualizarse correctamente y reflejarse al consultarlos.
     */
    @Test
    public void updatePlayerUpdatesSuccessfully() {
        PlayerDTO updatedFaker = new PlayerDTO();
        updatedFaker.setId(101);
        updatedFaker.setFirstName("Lee");
        updatedFaker.setLastName("Sang-hyeok");
        updatedFaker.setEmail("faker@t1.gg");
        updatedFaker.setPassword("legendary");
        updatedFaker.setCountry("South Korea");
        updatedFaker.setCity("Busan");
        updatedFaker.setNickName("Faker");
        updatedFaker.setBirthDate(LocalDate.of(1996, 5, 7).toString());
        updatedFaker.setRole(UserRole.PLAYER.name());

        boolean updated = arena.updatePlayer(fakerPlayer, updatedFaker);
        assertTrue("Player should be updated successfully", updated);

        PlayerDTO found = arena.findPlayer(updatedFaker);
        assertEquals("Busan", found.getCity());
    }

    /**
     * Verifica que el jugador registrado se encuentre en la lista general de jugadores.
     */
    @Test
    public void getAllPlayersContainsTestPlayer() {
        List<PlayerDTO> players = arena.getAllPlayers();
        assertNotNull("Player list should not be null", players);

        boolean found = false;
        for (PlayerDTO player : players) {
            if (player.getEmail().equals("faker@t1.gg")) {
                found = true;
                break;
            }
        }

        assertTrue("Player Faker should be in the list", found);
    }
}
