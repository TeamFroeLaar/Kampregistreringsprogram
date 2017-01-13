package Logic;

import java.util.List;

import Data.CreateMatchDB;
import Data.CreateTeamDB;
import Data.SelectTeamDB;
import Domain.Match;
import Domain.Team;

public class KRPLogic {

	// Create Team
	private CreateTeamDB createTeamInfo = new CreateTeamDB();

	public void createTeamInfo(Team team) {
		createTeamInfo.createTeam(team);
	}
	
	// Create Match
	private CreateMatchDB matchInfo = new CreateMatchDB();

	public void createMatch(Match match) {
		matchInfo.createMatch(match);
	}

	// Select Team
	private static SelectTeamDB teamAccessor = new SelectTeamDB();

	public static List<Team> getTeams() {
		return teamAccessor.selectTeam();
	}
} 
