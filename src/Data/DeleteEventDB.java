package Data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import Domain.Event;

public class DeleteEventDB {
	public void deleteEvent(Event event) {
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
				.prepareStatement("DELETE FROM EVENT WHERE ID LIKE ?");) {
			statement.setString(1, event.getId());
			int antal = statement.executeUpdate();
			System.out.println("Antal rækker berørt : " + antal);
		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);
		}
	}
}
