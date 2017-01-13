package Data;

import Domain.Match;
import Domain.Team;

public class DBfacade 
{
	private CreateMatchDB createMatchInfo = new CreateMatchDB();

	public void createMatchInfo(Match match) 
	{
		createMatchInfo.createMatch(match);
	}
	private SelectMatchDB selectMatchInfo = new SelectMatchDB();
	
	public void selectMatchInfo() 
	{
		selectMatchInfo.selectMatch();
	}

	private CreateTeamDB createTeamInfo = new CreateTeamDB();

	public void createTeamInfo(Team team) 
	{
		createTeamInfo.createTeam(team);
	}

}
 