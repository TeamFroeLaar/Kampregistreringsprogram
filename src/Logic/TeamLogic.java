package Logic;

import Data.CreateTeamDB;
import Domain.Team;

public class TeamLogic {

	// Create Team
	private CreateTeamDB teamInfo = new CreateTeamDB();

	public void createTeam(Team team) {
		teamInfo.createTeam(team);

	}
}
