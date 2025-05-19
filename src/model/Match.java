package model;

import java.time.LocalDate;
import java.time.LocalTime;

import model.enums.MatchStatus;

public class Match {

    private int id;
    private Team teamA;
    private Team teamB;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Team winner;
    private Tournament tournament;
    private double teamAScore;
    private double teamBScore;
    private String summary;
    private MatchStatus status;
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Team getTeamA() {
		return teamA;
	}
	
	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}
	
	public Team getTeamB() {
		return teamB;
	}
	
	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}
	
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	
	public LocalTime getEndTime() {
		return endTime;
	}
	
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
	public Team getWinner() {
		return winner;
	}
	
	public void setWinner(Team winner) {
		this.winner = winner;
	}
	
	public Tournament getTournament() {
		return tournament;
	}
	
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	
	public double getTeamAScore() {
		return teamAScore;
	}
	
	public void setTeamAScore(double teamAScore) {
		this.teamAScore = teamAScore;
	}
	
	public double getTeamBScore() {
		return teamBScore;
	}
	
	public void setTeamBScore(double teamBScore) {
		this.teamBScore = teamBScore;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public MatchStatus getStatus() {
		return status;
	}
	
	public void setStatus(MatchStatus status) {
		this.status = status;
	}
    
    

    
}
