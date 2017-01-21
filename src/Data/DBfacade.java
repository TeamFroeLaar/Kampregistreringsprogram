package Data;

import java.util.List;

import Domain.Event;
import Domain.Match;
import Domain.Team;

public class DBfacade {
	// Create Match
	private CreateMatchDB createMatchInfo = new CreateMatchDB();

	public void createMatchInfo(Match match) {
		createMatchInfo.createMatch(match);
	}

	// Select Matches
	private SelectMatchesDB selectMatchInfo = new SelectMatchesDB();

	public List<Match> selectMatchInfo() {
		return selectMatchInfo.selectMatches();
	}
	
	// Select Match
	private SelectMatchDB selectMatchDB = new SelectMatchDB();

	public Match selectMatch(String id) {
		return selectMatchDB.selectMatch(id);
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

	// Select Event
	private SelectEventDB selectEventInfo = new SelectEventDB();

	public List<Event> selectEventInfo(Event event) {
		return selectEventInfo.selectEvent(event);
	}

	// Select Goals
	private SelectNumberGoalsDB selectNumberGoalsInfo = new SelectNumberGoalsDB();

	public int selectNumberGoalsInfo(String id1, String id2) {
		return selectNumberGoalsInfo.selectNumberGoals(id1, id2);
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

