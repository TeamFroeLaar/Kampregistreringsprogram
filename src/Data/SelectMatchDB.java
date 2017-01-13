package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Match;

public class SelectMatchDB {
	public List<Match> selectMatch() {
		List<Match> matchList = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/kampReg", "SA", "");
				PreparedStatement statement = connection.prepareStatement("SELECT ID, HJEMMEHOLDID, UDEHOLDID, DATOTID FROM KAMPE");) {

			ResultSet rs = statement.executeQuery();
			try {
				connection.setAutoCommit(false);

				while (rs.next()) {
					Match m = new Match();
					m.setId("ID");
					m.setHjemmeholdId("HJEMMEHOLDID");
					m.setUdeholdId("UDEHOLDID");
					m.setDatoTid("DATOTID");
					matchList.add(m);
				}
				connection.commit();
			} catch (SQLException e) { 
				System.out.println("Fejl ved søgning");
				e.printStackTrace();
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matchList;
	}

}
