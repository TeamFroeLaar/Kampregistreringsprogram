package Data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import Domain.Match;

public class CreateMatchWIdDB {
	public void CreateMatchWId(Match match) {
		try (DataAccess access = new DataAccess()) {
			try {
				CreateMatchWId(access, match);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
	}

	private void CreateMatchWId(DataAccess access, Match match) {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("INSERT INTO KAMPE (ID, HJEMMEHOLDID, UDEHOLDID, DATOTID ) VALUES (?, ? ,? ,?)");) {
			statement.setString(1, match.getId());
			statement.setString(2, match.getHjemmeholdId());
			statement.setString(3, match.getUdeholdId());
			statement.setString(4, match.getDatoTid());
			int antal = statement.executeUpdate();
			System.out.println("Antal rækker berørt : " + antal);
		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);
		}
	}
}