package Logic;

import java.util.List; 
import Data.DBfacade;
import Data.SelectTeamDB;
import Domain.Match;
import Domain.Team;

public class KRPLogic {

	// Create Team
	private DBfacade createTeamInfo = new DBfacade();
	public void createTeamInfo(Team team) {
		createTeamInfo.createTeamInfo(team);
	}

	// Create Match
	private DBfacade createMatchInfo = new DBfacade();
	public void createMatch(Match match) {
		createMatchInfo.createMatchInfo(match);
	}

	// Select Team
	private static DBfacade teamAccessor = new DBfacade();
	public static List<Team> getTeams() {
		return teamAccessor.selectTeamInfo();
	}
}
