package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Domain.Team;

public class SelectTeamDB {

	public List<Team> selectTeam() {
		List<Team> list = new ArrayList<>();
		try (DataAccess access = new DataAccess()) {
			try {
				selectTeam(access, list);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return list;
	}

	private void selectTeam(DataAccess access, List<Team> list) {
		try (PreparedStatement statement = access.getConnection().prepareStatement("SELECT ID, HOLDNAVN FROM HOLD");) {

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Team t = new Team();
				t.setHoldnavn(rs.getString("HOLDNAVN"));
				t.setId(rs.getString("ID"));
				list.add(t);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);
		}
	}
}