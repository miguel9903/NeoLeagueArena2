package co.edu.unbosque.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.GamePlatform;
import co.edu.unbosque.model.Match;
import co.edu.unbosque.model.Team;
import co.edu.unbosque.model.Tournament;
import co.edu.unbosque.model.TournamentPhase;

/**
 * Clase de prueba unitaria para la clase Tournament.
 * Se verifican operaciones básicas como la asignación de equipos,
 * partidos, plataforma, fases del torneo y comportamiento del enum TournamentPhase.
 */
public class TournamentTest {

   
    private Tournament tournament;
    private Team teamA, teamB;
    private Match match;

    /**
     * Configuración inicial antes de cada prueba.
     * Se crean objetos Team y Match con valores predefinidos.
     */
    @Before
    public void setUp() {
        tournament = new Tournament();

        teamA = new Team();
        teamA.setName("Team Alpha");

        teamB = new Team();
        teamB.setName("Team Beta");

        match = new Match();
        match.setId(101);
    }

    /**
     * Verifica que se puedan asignar equipos al torneo correctamente.
     */
    @Test
    public void testAddTeamsToTournament() {
        List<Team> teamList = new ArrayList<>();
        teamList.add(teamA);
        teamList.add(teamB);

        tournament.setTeams(teamList);

        assertEquals("El número de equipos es incorrecto", 2, tournament.getTeams().size());
        assertEquals("Nombre del primer equipo incorrecto", "Team Alpha", tournament.getTeams().get(0).getName());
        assertEquals("Nombre del segundo equipo incorrecto", "Team Beta", tournament.getTeams().get(1).getName());
    }

    /**
     * Verifica que se puedan asignar partidos al torneo correctamente.
     */
    @Test
    public void testAddMatchesToTournament() {
        List<Match> matchList = new ArrayList<>();
        matchList.add(match);

        tournament.setMatches(matchList);

        assertEquals("El número de partidos es incorrecto", 1, tournament.getMatches().size());
        assertEquals("El ID del partido asignado es incorrecto", 101, tournament.getMatches().get(0).getId());
    }

    /**
     * Verifica que se pueda asignar una fase del torneo y su nombre visible (displayName).
     */
    @Test
    public void testSetAndGetPhase() {
        tournament.setPhase(TournamentPhase.QUARTERFINALS);
        assertEquals("Fase incorrecta", TournamentPhase.QUARTERFINALS, tournament.getPhase());
        assertEquals("DisplayName incorrecto", "Quarterfinals", tournament.getPhase().getDisplayName());
    }

    /**
     * Verifica el método estático fromString() del enum TournamentPhase,
     * usando diferentes formatos válidos de entrada.
     */
    @Test
    public void testFromStringInTournamentPhase() {
        TournamentPhase phase1 = TournamentPhase.fromString("Semifinals");
        TournamentPhase phase2 = TournamentPhase.fromString("group_stage");
        TournamentPhase phase3 = TournamentPhase.fromString("KNOCKOUT");

        assertEquals("Fase no reconocida correctamente", TournamentPhase.SEMIFINALS, phase1);
        assertEquals("Fase no reconocida correctamente", TournamentPhase.GROUP_STAGE, phase2);
        assertEquals("Fase no reconocida correctamente", TournamentPhase.KNOCKOUT, phase3);
    }

    /**
     * Verifica que se pueda asignar una plataforma de juego al torneo.
     */
    @Test
    public void testSetAndGetPlatform() {
        tournament.setPlatform(GamePlatform.PC);
        assertEquals("Plataforma incorrecta", GamePlatform.PC, tournament.getPlatform());
    }

    /**
     * Verifica que fromString devuelva null si se le pasa un valor inválido.
     */
    @Test
    public void testFromStringInvalidPhase() {
        TournamentPhase phase = TournamentPhase.fromString("NoExiste");
        assertNull("Se esperaba null para una fase no válida", phase);
    }

    /**
     * Verifica que fromString devuelva null si se le pasa null como argumento.
     */
    @Test
    public void testFromStringNull() {
        TournamentPhase phase = TournamentPhase.fromString(null);
        assertNull("Se esperaba null para entrada null", phase);
    }
}
