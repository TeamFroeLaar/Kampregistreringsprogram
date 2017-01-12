package Logic;

import Data.CreateMatchDB;
import Domain.Match;

public class MatchLogic {
	
	// Create Match
	private CreateMatchDB matchInfo = new CreateMatchDB();

	public void createMatch(Match match) {
		matchInfo.createMatch(match);
	}
}
