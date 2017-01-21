package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Domain.Match;

public class SelectMatchDB {
	
	public Match selectMatch(String id) {
		Match match = new Match();
		try (DataAccess access = new DataAccess()) {
			try {
				selectMatch(access, match, id);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return match;
	}

	private void selectMatch(DataAccess access, Match match, String id) {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("SELECT KAMPE.ID, KAMPE.HJEMMEHOLDID, KAMPE.UDEHOLDID, KAMPE.DATOTID, H1.ID AS HHID, H1.HOLDNAVN AS HHN, H2.ID AS HHID, H2.HOLDNAVN AS UHN FROM KAMPE, HOLD AS H1, HOLD AS H2 WHERE KAMPE.HJEMMEHOLDID = H1.ID AND KAMPE.UDEHOLDID = H2.ID AND KAMPE.ID = ?");) {
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				match.setId(rs.getString("ID"));
				match.setHjemmeholdId(rs.getString("HJEMMEHOLDID")); 
				match.setUdeholdId(rs.getString("UDEHOLDID"));
				match.setHjemmeholdNavn(rs.getString("HHN"));
				match.setUdeholdNavn(rs.getString("UHN"));
				match.setDatoTid(rs.getString("DATOTID"));
			}
		} catch (SQLException e) {
			throw new RuntimeException("fejl ved søgning", e);
		}
		
	}

}
