package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Team;

public class SelectTeamDB {
	public List<Team> selectTeam(Team team) {
		List<Team> list = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/kampReg", "SA", "");
				PreparedStatement statement = connection.prepareStatement("SELECT holdnavn,id from hold");) {

			ResultSet rs = statement.executeQuery();
			try {
				connection.setAutoCommit(false);

				//while løkke
				Team t = new Team();
				t.setHoldnavn(rs.getString("HOLDNAVN"));
				t.setId(rs.getString("ID"));
				list.add(t);

				int antal = statement.executeUpdate();
				System.out.println("Antal rækker berørt : " + antal);
				connection.commit();
			} catch (SQLException e) {
				System.out.println("Fejl ved søgning");
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
