package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.League;
import Domain.Match;

public class SelectLeagueDB {
	
	public List<League> selectLeague() {
		List<League> leagueList = new ArrayList<>();
		try (DataAccess access = new DataAccess()) {
			try {
				selectLeague();
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return leagueList;
	}

	private void selectMatch(DataAccess access, List<League> leagueList) {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement(/*insert SQL*/);) {
			
//			statement.setString(1);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				League l = new League();
				
//				l.setStilling(rs.getString(columnIndex));
				l.setHoldnavn(rs.getString(columnIndex));
				l.setEvent(rs.getString(columnIndex));
				l.setWin(rs.getString(columnIndex));
				l.setLoss(rs.getString(columnIndex));
				l.setPoint(rs.getString(columnIndex));
				leagueList.add(l);
			}
		} catch (SQLException e) {
			throw new RuntimeException("fejl ved søgning", e);
		}	
	}
}
