package co.edu.unbosque.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.model.Admin;
import co.edu.unbosque.model.AdminDTO;
import co.edu.unbosque.model.Coach;
import co.edu.unbosque.model.CoachDTO;
import co.edu.unbosque.model.Game;
import co.edu.unbosque.model.GameDTO;
import co.edu.unbosque.model.Match;
import co.edu.unbosque.model.MatchDTO;
import co.edu.unbosque.model.Player;
import co.edu.unbosque.model.PlayerDTO;
import co.edu.unbosque.model.Team;
import co.edu.unbosque.model.TeamDTO;
import co.edu.unbosque.model.Tournament;
import co.edu.unbosque.model.TournamentDTO;

public class FileManager<T> {

	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	private File fileLocation;

	public FileManager(String filePath) {
		this.fileLocation = new File(filePath);

		try {
			File parentDir = fileLocation.getParentFile();
			if (parentDir != null && !parentDir.exists()) {
				parentDir.mkdirs();
			}

			if (!fileLocation.exists()) {
				fileLocation.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeToFile(ArrayList<T> objects, Class<T> className) {
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(fileLocation));

			if (className == Admin.class) {
				ArrayList<Admin> admins = (ArrayList<Admin>) (ArrayList<?>) objects;
				List<AdminDTO> dtos = AdminMapper.convertAdminListToAdminDTOList(admins);
				outputStream.writeObject(dtos);

			} else if (className == Coach.class) {
				ArrayList<Coach> coaches = (ArrayList<Coach>) (ArrayList<?>) objects;
				List<CoachDTO> dtos = CoachMapper.convertCoachListToCoachDTOList(coaches);
				outputStream.writeObject(dtos);

			} else if (className == Player.class) {
				ArrayList<Player> players = (ArrayList<Player>) (ArrayList<?>) objects;
				List<PlayerDTO> dtos = PlayerMapper.convertPlayerListToPlayerDTOList(players);
				outputStream.writeObject(dtos);

			} else if (className == Team.class) {
				ArrayList<Team> teams = (ArrayList<Team>) (ArrayList<?>) objects;
				List<TeamDTO> dtos = TeamMapper.convertTeamListToTeamDTOList(teams);
				outputStream.writeObject(dtos);

			} else if (className == Game.class) {
				ArrayList<Game> games = (ArrayList<Game>) (ArrayList<?>) objects;
				List<GameDTO> dtos = GameMapper.convertGameListToGameDTOList(games);
				outputStream.writeObject(dtos);

			} else if (className == Tournament.class) {
				ArrayList<Tournament> tournaments = (ArrayList<Tournament>) (ArrayList<?>) objects;
				List<TournamentDTO> dtos = TournamentMapper.convertTournamentListToTournamentDTOList(tournaments);
				outputStream.writeObject(dtos);

			} else if (className == Match.class) {
	            ArrayList<Match> matches = (ArrayList<Match>) (ArrayList<?>) objects;
	            List<MatchDTO> dtos = MatchMapper.convertMatchListToMatchDTOList(matches);
	            outputStream.writeObject(dtos);

	        }  else {
				outputStream.writeObject(objects);
			}

			outputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<T> readFromFile(Class<T> className) {
		ArrayList<T> objects = null;

		if (fileLocation.length() != 0) {
			try {
				inputStream = new ObjectInputStream(new FileInputStream(fileLocation));

				if (className == Admin.class) {
					List<AdminDTO> dtos = (List<AdminDTO>) inputStream.readObject();
					List<Admin> adminList = AdminMapper.convertAdminDTOListToAdminList(dtos);
					objects = new ArrayList<>((List<T>) adminList);

				} else if (className == Player.class) {
					List<PlayerDTO> dtos = (List<PlayerDTO>) inputStream.readObject();
					List<Player> playerList = PlayerMapper.convertPlayerDTOListToPlayerList(dtos);
					objects = new ArrayList<>((List<T>) playerList);

				} else if (className == Coach.class) {
					List<CoachDTO> dtos = (List<CoachDTO>) inputStream.readObject();
					List<Coach> coachList = CoachMapper.convertCoachDTOListToCoachList(dtos);
					objects = new ArrayList<>((List<T>) coachList);

				} else if (className == Team.class) {
					List<TeamDTO> dtos = (List<TeamDTO>) inputStream.readObject();
					List<Team> teamList = TeamMapper.convertTeamDTOListToTeamList(dtos);
					objects = new ArrayList<>((List<T>) teamList);

				} else if (className == Game.class) {
					List<GameDTO> dtos = (List<GameDTO>) inputStream.readObject();
					List<Game> gameList = GameMapper.convertGameDTOListToGameList(dtos);
					objects = new ArrayList<>((List<T>) gameList);

				} else if (className == Tournament.class) {
					List<TournamentDTO> dtos = (List<TournamentDTO>) inputStream.readObject();
					List<Tournament> tournamentList = TournamentMapper.convertTournamentDTOListToTournamentList(dtos);
					objects = new ArrayList<>((List<T>) tournamentList);
				} else if (className == Match.class) {
	                List<MatchDTO> dtos = (List<MatchDTO>) inputStream.readObject();
	                List<Match> matchList = MatchMapper.convertMatchDTOListToMatchList(dtos);
	                objects = new ArrayList<>((List<T>) matchList);

	            }

				inputStream.close();

			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return objects;
	}

	public ObjectInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ObjectInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public ObjectOutputStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(ObjectOutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public File getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(File fileLocation) {
		this.fileLocation = fileLocation;
	}
}
