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

	// Select Redcard
	private SelectNumberRedCardDB selectNumberRedcardInfo = new SelectNumberRedCardDB();

	public int selectNumberRedcardInfo(String id1, String id2) {
		return selectNumberRedcardInfo.selectNumberRedcards(id1, id2);
	}

	// Select Yellowcard
	private SelectNumberYellowCardDB selectNumberYellowcardInfo = new SelectNumberYellowCardDB();

	public int selectNumberYellowcardInfo(String id1, String id2) {
		return selectNumberYellowcardInfo.selectNumberYellowcards(id1, id2);
	}

	// Select Penalties
	private SelectNumberPenaltiesDB selectNumberPenaltiesInfo = new SelectNumberPenaltiesDB();

	public int selectNumberPenaltiesInfo(String id1, String id2) {
		return selectNumberPenaltiesInfo.selectNumberPenalties(id1, id2);
	}

	// Delete Event
	private DeleteEventDB deleteEventInfo = new DeleteEventDB();

	public void deleteEventInfo(Event event) {
		deleteEventInfo.deleteEvent(event);
	}

	// Select League
	private static SelectLeagueDB SelectLeagueInfo = new SelectLeagueDB();

	public static List<League> selectLeagueInfo() {
		return SelectLeagueInfo.selectLeague();
	}
}
