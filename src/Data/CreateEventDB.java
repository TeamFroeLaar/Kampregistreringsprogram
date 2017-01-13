package Data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Domain.Event;

public class CreateEventDB {
	public void createEvent(Event event) {
		try (DataAccess access = new DataAccess()) {
			try {
				createEvent(access, event);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
	}

	private void createEvent(DataAccess access, Event event) {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("INSERT INTO EVENT(EVENT, HOLDID, KAMPEID, DATOTID VALUES (?, ?, ?, ?");) {
			statement.setString(1, event.getEvent());
			statement.setString(2, event.getHoldid());
			statement.setString(3, event.getKampid());
			statement.setString(4, event.getDatotid());
		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);

		}
	}
}
