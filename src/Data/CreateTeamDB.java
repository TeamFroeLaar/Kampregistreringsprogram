package Data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Domain.Team;

public class CreateTeamDB {
	public void createTeam(Team team) {
		try (DataAccess access = new DataAccess()) {
			try {
				createTeam(access, team);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
	}

	private void createTeam(DataAccess access, Team team) {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("INSERT INTO HOLD (HOLDNAVN) VALUES (?)");) {
			statement.setString(1, team.getHoldnavn());

			int antal = statement.executeUpdate();
			System.out.println("Antal rækker berørt : " + antal);
		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);
		}
	}
}
