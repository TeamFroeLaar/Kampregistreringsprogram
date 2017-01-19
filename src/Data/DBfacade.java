package Data;

import java.util.List;

import Domain.Event;
import Domain.League;
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
	
	// Create Event
	private CreateEventDB createEventInfo = new CreateEventDB();
	
	public void createEventInfo(Event event) {
		createEventInfo.createEvent(event);
	}
	
	// Create League
//	private DBfacade createLeagueInfo = new DBfacade();
//	public void createLeague(League league) 
//	{
//		createLeagueInfo.createLeagueInfo(league);
//	}
//	// Select League
//	private static DBfacade leagueAccessor = new DBfacade();
//	public static List<League> getLeague()
//	{
//		return leagueAccessor.selectLeagueInfo();
//	}

}
