package Logic;

import Data.CreateMatchDB;
import Domain.Match;

public class MatchLogic {
	
	// Create Team
	private CreateMatchDB matchInfo = new CreateMatchDB();

	public void createMatch(Match match) {
		matchInfo.createMatch(match);

	}
}
