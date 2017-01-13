package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Match;
import Domain.Team;

public class SelectMatchDB {
	public List<Match> selectMatch() {
		List<M> list = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/kampReg", "SA", "");
				PreparedStatement statement = connection.prepareStatement("SELECT ID, HOLDNAVN FROM HOLD");) {

			ResultSet rs = statement.executeQuery();
			try {
				connection.setAutoCommit(false);

				while (rs.next()) {
					Team t = new Team();
					t.setHoldnavn(rs.getString("HOLDNAVN"));
					t.setId(rs.getString("ID"));
					list.add(t);
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
		return list;
	}

}
