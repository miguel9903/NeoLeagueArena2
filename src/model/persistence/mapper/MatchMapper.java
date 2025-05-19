package model.persistence.mapper;

import java.util.ArrayList;
import java.util.List;

import model.Match;
import model.Team;
import model.Tournament;
import model.enums.MatchStatus;
import model.persistence.dto.MatchDTO;

public class MatchMapper {

	public static Match convertMatchDTOToMatch(MatchDTO dto) {
	    if (dto == null) return null;

	    Match match = new Match();

	    Team teamA = new Team();
	    teamA.setId(dto.getTeamAId());
	    teamA.setName(dto.getTeamAName());
	    
	    Team teamB = new Team();
	    teamB.setId(dto.getTeamBId());
	    teamB.setName(dto.getTeamBName());

	    Team winner = null;
	    if (dto.getWinnerId() != null) {
	        winner = new Team();
	        winner.setId(dto.getWinnerId());
	    }

	    Tournament tournament = null;
	    if (dto.getTournamentId() != null) {
	        tournament = new Tournament();
	        tournament.setId(dto.getTournamentId());
	    }

	    MatchStatus status = MatchStatus.fromString(dto.getStatus());
	    if (dto.getId() != null) {
	        match.setId(dto.getId());
	    }
	    match.setTeamA(teamA);
	    match.setTeamB(teamB);
	    match.setDate(dto.getDate());
	    match.setStartTime(dto.getStartTime());
	    match.setEndTime(dto.getEndTime());
	    match.setWinner(winner);
	    match.setTournament(tournament);
	    match.setTeamAScore(dto.getTeamAScore());
	    match.setTeamBScore(dto.getTeamBScore());
	    match.setSummary(dto.getSummary());
	    match.setStatus(status);

	    return match;
	}

    public static MatchDTO convertMatchToMatchDTO(Match match) {
        if (match == null) return null;

        MatchDTO dto = new MatchDTO();

        dto.setId(match.getId());

        if (match.getTeamA() != null) {
            dto.setTeamAId(match.getTeamA().getId());
        }

        if (match.getTeamB() != null) {
            dto.setTeamBId(match.getTeamB().getId());
        }

        if (match.getTournament() != null) {
            dto.setTournamentId(match.getTournament().getId());
        }

        dto.setDate(match.getDate());
        dto.setStartTime(match.getStartTime());
        dto.setEndTime(match.getEndTime());

        if (match.getWinner() != null) {
            dto.setWinnerId(match.getWinner().getId());
        }

        dto.setTeamAScore(match.getTeamAScore());
        dto.setTeamBScore(match.getTeamBScore());
        dto.setSummary(match.getSummary());
        
        dto.setTeamAName(match.getTeamA().getName());
        dto.setTeamBName(match.getTeamB().getName());

        if (match.getStatus() != null) {
            dto.setStatus(match.getStatus().name());
        } else {
            dto.setStatus(null);
        }

        return dto;
    }

    public static List<MatchDTO> convertMatchListToMatchDTOList(List<Match> matches) {
        List<MatchDTO> dtos = new ArrayList<>();

        if (matches != null) {
            for (Match match : matches) {
                dtos.add(convertMatchToMatchDTO(match));
            }
        }

        return dtos;
    }

    public static List<Match> convertMatchDTOListToMatchList(List<MatchDTO> dtos) {
        List<Match> matches = new ArrayList<>();

        if (dtos != null) {
            for (MatchDTO dto : dtos) {
                matches.add(convertMatchDTOToMatch(dto));
            }
        }

        return matches;
    }
}
