package Logic;

import java.util.List;

import Data.DBfacade;
import Domain.Match;
import Domain.Team;
import Domain.Event;
import Domain.League;

public class KRPLogic {

	// Create Team
	private DBfacade createTeamInfo = new DBfacade();
	public void createTeamInfo(Team team) 
	{
		createTeamInfo.createTeamInfo(team);
	}

	// Create Match
	private DBfacade createMatchInfo = new DBfacade();
	public void createMatch(Match match) 
	{
		createMatchInfo.createMatchInfo(match);
	}
	
	//Create Event
	private DBfacade createEventInfo = new DBfacade();
	public void createEvent(Event event) 
	{
		createEventInfo.createEventInfo(event);
	}

	// Select Team
	private static DBfacade teamAccessor = new DBfacade();
	public static List<Team> getTeams() {
		return teamAccessor.selectTeamInfo();
}
	
	// Select Match
	private static DBfacade matchAccessor = new DBfacade();
	public static List<Match> getMatch()
	{
		return matchAccessor.selectMatchInfo();
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
