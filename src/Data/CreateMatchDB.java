package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Domain.Match;

public class CreateMatchDB {
	public void createMatch(Match match) {
		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/kampReg", "SA", "");
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO KAMPE (HJEMMEHOLDID, UDEHOLDID, DATOTID ) VALUES (? ,? ,?)");) {
			try {
				connection.setAutoCommit(false);
				statement.setString(1, match.getHjemmeholdId());
				statement.setString(2, match.getUdeholdId());
				statement.setString(3, match.getDatoTid());
				int antal = statement.executeUpdate();
				System.out.println("Antal rækker berørt : " + antal);
				connection.commit();
			} catch (SQLException e) {
				System.out.println("Fejl ved oprettelse");
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
