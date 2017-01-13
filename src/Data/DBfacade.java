package Data;

import Domain.Match;
import Domain.Team;

public class DBfacade {
	private CreateMatchDB createMatchInfo = new CreateMatchDB();
			
	private void createMatchInfo(Match match) 
		{
			createMatchInfo.createMatch(match);
		}
	private CreateTeamDB createTeamInfo = new CreateTeamDB();
	
	private void createTeamInfo(Team team)
	{
			createTeamInfo.createTeam(team);
	}
	
}
