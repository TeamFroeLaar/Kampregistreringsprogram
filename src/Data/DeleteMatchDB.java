package Data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import Domain.Match;

public class DeleteMatchDB {
	public void deleteMatch(Match match) {
		try (DataAccess access = new DataAccess()) {
			try {
				deleteMatch(access, match);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
	}

	private void deleteMatch(DataAccess access, Match match) {
		try (PreparedStatement statement1 = access.getConnection()
				.prepareStatement("DELETE FROM EVENT WHERE KAMPID LIKE ?");
				PreparedStatement statement2 = access.getConnection()
						.prepareStatement("DELETE FROM KAMPE WHERE ID LIKE ?");) {

			statement1.setString(1, match.getId());
			statement2.setString(1, match.getId());

			int antalEve = statement1.executeUpdate();
			int antalKam = statement2.executeUpdate();
			System.out.println("Antal rækker berørt i events : " + antalEve);
			System.out.println("Antal rækker berørt i kampe : " + antalKam);
		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);
		}
	}
}
