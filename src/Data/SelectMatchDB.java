package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Match;

public class SelectMatchDB {

	public List<Match> selectMatch() {
		List<Match> matchList = new ArrayList<>();
		try (DataAccess access = new DataAccess()) {
			try {
				selectMatch(access, matchList);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return matchList;
	}

	public void selectMatch(DataAccess access, List<Match> matchList) {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("SELECT ID, HJEMMEHOLDID, UDEHOLDID, DATOTID FROM KAMPE");) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Match m = new Match();
				m.setId(rs.getString("ID"));
				m.setHjemmeholdId(rs.getString("HJEMMEHOLDID")); 
				m.setUdeholdId(rs.getString("UDEHOLDID"));
				m.setDatoTid(rs.getString("DATOTID"));
				matchList.add(m);
			}
		} catch (SQLException e) {
			throw new RuntimeException("fejl ved søgning", e);
		}
	}
}
