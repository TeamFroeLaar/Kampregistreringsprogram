package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Domain.Match;

public class SelectNumberGoalsMatchDB {
	List<Match> list = new ArrayList<>();

	public List<Match> selectNumberGoalsMatch(String holdid, String kampid) {
		try (DataAccess access = new DataAccess()) {
			try {
				selectNumberGoalsMatch(access, holdid, kampid, list);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return list;
	}

	private void selectNumberGoalsMatch(DataAccess access, String holdid, String kampid, List<Match> list) {

		try (PreparedStatement statement = access.getConnection().prepareStatement(
				"SELECT HOLD.ID AS HID, HOLD.HOLDNAVN, KAMPE.ID AS KID, COUNT(EVENT) AS NUMBERGOALS FROM HOLD,KAMPE, (EVENT INNER JOIN HOLD ON EVENT.HOLDID=HOLD.ID) WHERE EVENT.HOLDID LIKE ? AND HOLD.ID LIKE ? AND EVENT.EVENT LIKE 'Goal' AND KAMPE.ID LIKE ? GROUP BY ID, KAMPE.ID, EVENT");) {
			statement.setString(1, holdid);
			statement.setString(2, holdid);
			statement.setString(3, kampid);

			ResultSet rs = statement.executeQuery();

			Match m = new Match();
			m.setId(rs.getString("KID"));
			m.setNumberGoals(rs.getString("NUMBERGOALS"));

			list.add(m);

		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);
		}
	}
}
