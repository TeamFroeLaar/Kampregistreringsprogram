package Logic;

import java.util.List;

import Data.DBfacade;
import Domain.Event;
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

	// Create Event
	private DBfacade createEventInfo = new DBfacade();

	public void createEvent(Event event) {
		createEventInfo.createEventInfo(event);
	}

	// Select Team
	private static DBfacade teamAccessor = new DBfacade();

	public static List<Team> getTeams() {
		return teamAccessor.selectTeamInfo();
	}

	// Select Matches
	private static DBfacade matchAccessor = new DBfacade();

	public static List<Match> getMatch() {
		return matchAccessor.selectMatchInfo();
	}
	
	// Select Match
	private static DBfacade dbFacade = new DBfacade();
	
	public static Match selectMatch(String id) {
		return dbFacade.selectMatch(id);
	}

	// Select Event
	private static DBfacade eventAccessor = new DBfacade();

	public static List<Event> getEvent(Event event) {
		return eventAccessor.selectEventInfo(event);
	}
	
	//Select number goals
	private static DBfacade goalAccessor = new DBfacade();
	
	public int selectNumberGoalsInfo(String id1, String id2) {
		return goalAccessor.selectNumberGoalsInfo(id1, id2);
	}

	// Create League
	// private DBfacade createLeagueInfo = new DBfacade();
	// public void createLeague(League league)
	// {
	// createLeagueInfo.createLeagueInfo(league);
	// }
	// // Select League
	// private static DBfacade leagueAccessor = new DBfacade();
	// public static List<League> getLeague()
	// {
	// return leagueAccessor.selectLeagueInfo();
	// }
}
