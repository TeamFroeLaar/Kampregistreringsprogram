package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Domain.Team;

public class CreateTeam {
	public void createTeam(Team team) {
		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/kampReg", "SA", "");
				PreparedStatement statement = connection.prepareStatement("INSERT INTO HOLD (HOLDNAVN) VALUES (?)");) {
			try {
				connection.setAutoCommit(false);
				statement.setString(1, team.getHoldnavn());

				int antal = statement.executeUpdate();
				System.out.println("Antal rækker berørt : " + antal);
				connection.commit();
			} catch (SQLException e) {
				System.out.println("Fejl ved oprettelse");
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
