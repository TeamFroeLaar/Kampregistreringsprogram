package Logic;

import Data.CreateTeamDB;
import Data.SelectTeamDB;
import Domain.Team;

public class TeamLogic {

	// Create Team
	private CreateTeamDB createTeamInfo = new CreateTeamDB();

	public void createTeamInfo(Team team) {
		createTeamInfo.createTeam(team);
	}

	// Select Team
	private SelectTeamDB selectTeamInfo = new SelectTeamDB();

	public void selectTeamInfo(Team team) {
		selectTeamInfo.selectTeam(team);
	}
}
