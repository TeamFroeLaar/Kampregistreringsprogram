package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Match;

public class SelectMatchDB {
	List<Match> matchList = new ArrayList<>();

	public List<Match> selectMatch() {

		try (DataAccess access = new DataAccess()) {
			try {
				selectMatch(access);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return matchList;
	}

	public void selectMatch(DataAccess access) {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("SELECT ID, HJEMMEHOLDID, UDEHOLDID, DATOTID FROM KAMPE");) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Match m = new Match();
				m.setId("ID");
				m.setHjemmeholdId("HJEMMEHOLDID"); 
				m.setUdeholdId("UDEHOLDID");
				m.setDatoTid("DATOTID");
				matchList.add(m);
			}
		} catch (SQLException e) {
			throw new RuntimeException("fejl ved søgning", e);
		}
	}
}
