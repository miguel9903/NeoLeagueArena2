package co.edu.unbosque.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.Match;
import co.edu.unbosque.model.MatchStatus;
import co.edu.unbosque.model.Team;

/**
 * Clase de prueba unitaria para la clase Match.
 * Se realizan pruebas sobre los métodos relacionados con la asignación
 * de equipos, fecha, hora, estado, resumen y puntajes.
 */
public class MatchTest {

	private Team teamA;
	private Team teamB;
	private Match match;

	/**
	 * Método que se ejecuta antes de cada prueba.
	 * Inicializa dos equipos de prueba y un objeto Match con datos válidos.
	 */
	@Before
	public void setUp() {
		teamA = new Team();
		teamA.setName("Team Heretics");

		teamB = new Team();
		teamB.setName("Team MadLions");

		match = new Match();  
		match.setId(1);
		match.setTeamA(teamA);
		match.setTeamB(teamB);
		match.setDate(LocalDate.of(2025, 5, 20));
		match.setStartTime(LocalTime.of(14, 0));
		match.setEndTime(LocalTime.of(15, 30));
		match.setWinner(null);
		match.setTeamAScore(0.0);
		match.setTeamBScore(0.0);
		match.setSummary("");
		match.setStatus(MatchStatus.SCHEDULED);
	}

	@Test
	public void testConstructorWithData() {
		assertEquals("Match ID mismatch", 1, match.getId());
		assertEquals("Team A mismatch", teamA, match.getTeamA());
		assertEquals("Team B mismatch", teamB, match.getTeamB());
		assertEquals("Date mismatch", LocalDate.of(2025, 5, 20), match.getDate());
		assertEquals("Start time mismatch", LocalTime.of(14, 0), match.getStartTime());
		assertEquals("End time mismatch", LocalTime.of(15, 30), match.getEndTime());
		assertNull("Winner should be null", match.getWinner());
		assertEquals("Team A score mismatch", 0.0, match.getTeamAScore(), 0.001);
		assertEquals("Team B score mismatch", 0.0, match.getTeamBScore(), 0.001);
		assertEquals("Summary should be empty", "", match.getSummary());
		assertEquals("Status mismatch", MatchStatus.SCHEDULED, match.getStatus());
	}

	@Test
	public void testSetAndGetWinner() {
		match.setWinner(teamA);
		assertEquals("Winner not set correctly", teamA, match.getWinner());
	}

	@Test
	public void testSetAndGetScores() {
		match.setTeamAScore(3.5);
		match.setTeamBScore(2.0);

		assertEquals("Team A score incorrect", 3.5, match.getTeamAScore(), 0.001);
		assertEquals("Team B score incorrect", 2.0, match.getTeamBScore(), 0.001);
	}

	@Test
	public void testSetSummaryAndStatus() {
		match.setSummary("Exciting match between Alpha and Beta");
		match.setStatus(MatchStatus.COMPLETED);

		assertEquals("Summary not set correctly", "Exciting match between Alpha and Beta", match.getSummary());
		assertEquals("Status not updated correctly", MatchStatus.COMPLETED, match.getStatus());
	}
}
