package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Event;

public class SelectEventDB {

	public List<Event> selectEvent(Event event) {
		List<Event> list = new ArrayList<>();
		try (DataAccess access = new DataAccess()) {
			try {
				selectEvent(access, list, event);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return list;
	}

	private void selectEvent(DataAccess access, List<Event> list, Event event) {
		try (PreparedStatement statement = access.getConnection().prepareStatement(
				"SELECT EVENT.ID, EVENT.EVENT, EVENT.HOLDID, EVENT.KAMPID, EVENT.TID, HOLD.HOLDNAVN FROM EVENT, HOLD WHERE EVENT.KAMPID LIKE ? AND EVENT.HOLDID = HOLD.ID");) {

			statement.setString(1, event.getKampid());
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Event e = new Event();
				e.setId(rs.getString("id"));
				e.setEvent(rs.getString("event"));
				e.setHoldid(rs.getString("holdid"));
				e.setKampid(rs.getString("kampid"));
				e.setTid(rs.getString("tid"));
				e.setHoldnavn(rs.getString("holdnavn"));
				
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}