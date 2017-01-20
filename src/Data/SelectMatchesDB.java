package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Match;

public class SelectMatchesDB {

	public List<Match> selectMatches() {
		List<Match> matchList = new ArrayList<>();
		try (DataAccess access = new DataAccess()) {
			try {
				selectMatches(access, matchList);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return matchList;
	}

	public void selectMatches(DataAccess access, List<Match> matchList) {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("SELECT KAMPE.ID, KAMPE.HJEMMEHOLDID, KAMPE.UDEHOLDID, KAMPE.DATOTID, H1.ID AS HHID, H1.HOLDNAVN AS HHN, H2.ID AS HHID, H2.HOLDNAVN AS UHN FROM KAMPE, HOLD AS H1, HOLD AS H2 WHERE KAMPE.HJEMMEHOLDID = H1.ID AND KAMPE.UDEHOLDID = H2.ID");) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Match m = new Match();
				m.setId(rs.getString("ID"));
				m.setHjemmeholdId(rs.getString("HJEMMEHOLDID")); 
				m.setUdeholdId(rs.getString("UDEHOLDID"));
				m.setHjemmeholdNavn(rs.getString("HHN"));
				m.setUdeholdNavn(rs.getString("UHN"));
				m.setDatoTid(rs.getString("DATOTID"));
				matchList.add(m);
			}
		} catch (SQLException e) {
			throw new RuntimeException("fejl ved søgning", e);
		}
	}
}
