package model.persistence.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class MatchDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer teamAId;
    private Integer teamBId;
    private Integer tournamentId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer winnerId;
    private double teamAScore;
    private double teamBScore;
    private String summary;
    private String status;
    private String teamAName; 
    private String teamBName;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTeamAId() {
		return teamAId;
	}
	public void setTeamAId(Integer teamAId) {
		this.teamAId = teamAId;
	}
	public Integer getTeamBId() {
		return teamBId;
	}
	public void setTeamBId(Integer teamBId) {
		this.teamBId = teamBId;
	}
	public Integer getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(Integer tournamentId) {
		this.tournamentId = tournamentId;
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
	public Integer getWinnerId() {
		return winnerId;
	}
	public void setWinnerId(Integer winnerId) {
		this.winnerId = winnerId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTeamAName() {
		return teamAName;
	}
	public void setTeamAName(String teamAName) {
		this.teamAName = teamAName;
	}
	public String getTeamBName() {
		return teamBName;
	}
	public void setTeamBName(String teamBName) {
		this.teamBName = teamBName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}  
    
    

}