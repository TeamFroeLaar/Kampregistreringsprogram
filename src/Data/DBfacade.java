package Data;

import java.util.List;

import Domain.Match;
import Domain.Team;

public class DBfacade {
	// Create Match
	private CreateMatchDB createMatchInfo = new CreateMatchDB();

	public void createMatchInfo(Match match) {
		createMatchInfo.createMatch(match);
	}

	// Select Match
	private SelectMatchDB selectMatchInfo = new SelectMatchDB();

	public List<Match> selectMatchInfo() {
		return selectMatchInfo.selectMatch();
	}

	// Create Team
	private CreateTeamDB createTeamInfo = new CreateTeamDB();

	public void createTeamInfo(Team team) {
		createTeamInfo.createTeam(team);
	}

	// Select Team
	private SelectTeamDB selectTeamInfo = new SelectTeamDB();

	public List<Team> selectTeamInfo() {
		return selectTeamInfo.selectTeam();
	}

}
