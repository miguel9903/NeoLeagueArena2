package co.edu.unbosque.persistence;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.model.Player;
import co.edu.unbosque.model.PlayerDTO;
import co.edu.unbosque.model.Team;
import co.edu.unbosque.model.UserRole;

public class PlayerMapper {

    public static Player convertPlayerDTOToPlayer(PlayerDTO dto) {
        if (dto == null) return null;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Player player = new Player();
        player.setId(dto.getId());
        player.setFirstName(dto.getFirstName());
        player.setLastName(dto.getLastName());
        player.setNickName(dto.getNickName());
        player.setEmail(dto.getEmail());
        player.setPassword(dto.getPassword());
        player.setCountry(dto.getCountry());
        player.setCity(dto.getCity());
        player.setExperienceLevel(dto.getExperienceLevel());
        player.setRole(UserRole.PLAYER);

        if (dto.getCurrentTeamId() != null) {
            Team team = new Team();
            team.setId(dto.getCurrentTeamId());
            team.setName(dto.getCurrentTeamName());
            player.setCurrentTeam(team);
        }

        if (dto.getBirthDate() != null && !dto.getBirthDate().isEmpty()) {
            player.setBirthDate(LocalDate.parse(dto.getBirthDate(), formatter));
        }
        
        return player;
    }

    public static PlayerDTO convertPlayerToPlayerDTO(Player player) {
        if (player == null) return null;

        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getId());
        dto.setFirstName(player.getFirstName());
        dto.setLastName(player.getLastName());
        dto.setEmail(player.getEmail());
        dto.setPassword(player.getPassword());
        dto.setCountry(player.getCountry());
        dto.setCity(player.getCity());
        
        if (player.getCurrentTeam() != null) {
            dto.setCurrentTeamId(player.getCurrentTeam().getId());
            dto.setCurrentTeamName(player.getCurrentTeam().getName());
        } else {
            dto.setCurrentTeamId(null);
            dto.setCurrentTeamName(null); 
        }

        dto.setRole(UserRole.PLAYER.getDisplayName());
        dto.setNickName(player.getNickName());
        dto.setExperienceLevel(player.getExperienceLevel());
        dto.setAge(player.getAge());

        if (player.getBirthDate() != null) {
            dto.setBirthDate(player.getBirthDate().toString());
        } else {
            dto.setBirthDate(null);
        }

        return dto;
    }

    
    public static List<PlayerDTO> convertPlayerListToPlayerDTOList(List<Player> players) {
        List<PlayerDTO> dtos = new ArrayList<>();
        if (players != null) {
            for (Player player : players) {
                dtos.add(convertPlayerToPlayerDTO(player));
            }
        }
        return dtos;
    }

    public static List<Player> convertPlayerDTOListToPlayerList(List<PlayerDTO> dtos) {
        List<Player> players = new ArrayList<>();
        if (dtos != null) {
            for (PlayerDTO dto : dtos) {
                players.add(convertPlayerDTOToPlayer(dto));
            }
        }
        return players;
    }
}
