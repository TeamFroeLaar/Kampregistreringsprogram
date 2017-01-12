package Logic;

import java.util.List;

import Data.CreateMatchDB;
import Data.SelectTeamDB;
import Domain.Match;
import Domain.Team;

public class MatchLogic {
	 
	// Create Match
	private CreateMatchDB matchInfo = new CreateMatchDB();

	public void createMatch(Match match) {
		matchInfo.createMatch(match);
	}
	
	// Select Team
	private SelectTeamDB listeTeams = new SelectTeamDB();
	
	public List<Team> listTeam(Team team) {
		return listeTeams.selectTeam(team); 
	}
}
