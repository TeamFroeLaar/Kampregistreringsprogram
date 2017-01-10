package Logic;

import Data.CreateTeamDB;
import Domain.Team;

public class TeamLogic {

	// Create Team
	private CreateTeamDB createTeamInfo = new CreateTeamDB();

	public void createTeamInfo(Team team) {
		createTeamInfo.createTeam(team);
	}
}
