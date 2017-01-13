package Data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Domain.Match;

public class CreateMatchDB {
	public void createMatch(Match match) {
		try (DataAccess access = new DataAccess()) {
			try {
				createMatch(access, match);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
	}

	private void createMatch(DataAccess access, Match match) {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("INSERT INTO KAMPE (HJEMMEHOLDID, UDEHOLDID, DATOTID ) VALUES (? ,? ,?)");) {
			statement.setString(1, match.getHjemmeholdId());
			statement.setString(2, match.getUdeholdId());
			statement.setString(3, match.getDatoTid());
			int antal = statement.executeUpdate();
			System.out.println("Antal rækker berørt : " + antal);
		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);
		}
	}
}
