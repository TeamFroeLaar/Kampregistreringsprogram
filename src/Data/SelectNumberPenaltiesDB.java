package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectNumberPenaltiesDB {
	int antal;

	public int selectNumberPenalties(String id1, String id2) {
		try (DataAccess access = new DataAccess()) {
			try {
				selectNumberPenalties(access, id1, id2);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return antal;
	}

	private void selectNumberPenalties(DataAccess access, String id1, String id2) {

		try (PreparedStatement statement = access.getConnection().prepareStatement(
				"SELECT count(*) FROM EVENT WHERE HOLDID LIKE ? AND KAMPID LIKE ? AND EVENT LIKE 'Penalty'");) {
			statement.setString(1, id1);
			statement.setString(2, id2);

			ResultSet rs = statement.executeQuery();
			rs.next();
			System.out.println(antal);
			antal = rs.getInt(1);
			System.out.println(antal);

		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);
		}
	}
}
