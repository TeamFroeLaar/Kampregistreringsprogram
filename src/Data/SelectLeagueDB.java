package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Domain.League;

public class SelectLeagueDB {
	
	public League selectLeague() {
		League league = new League();
		try (DataAccess access = new DataAccess()) {
			try {
				selectLeague();
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return league;
	}

	private void selectMatch(DataAccess access, League league, String id) {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement(/*insert SQL*/);) {
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
//				league.setStilling(rs.getString(columnIndex));
				league.setHoldnavn(rs.getString());
				league.setEvent(rs.getString(columnIndex));
				league.setWin(rs.getString(columnIndex));
				league.setLoss(rs.getString(columnIndex));
				league.setPoint(rs.getString(columnIndex));
			}
		} catch (SQLException e) {
			throw new RuntimeException("fejl ved søgning", e);
		}
		
	}

}
