package Presentation;

import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Domain.Team;

public class ExportLeagueTableCSV {

		public void exportCSV (List<Team> teams) throws IOException {
			try {
				FileWriter writer = new FileWriter(new File("C:\\MatchReport\\LeagueReport.csv"));
				for(int i=0; i < teams.size(); i++) {
					 writer.append(teams.get(i).getStilling() + ",\n");
					 writer.append(teams.get(i).getHoldnavn() + ",\n"); 
					 writer.append(teams.get(i).getVundne() + ",\n");
					 writer.append(teams.get(i).getUafgjorte() + ",\n");
					 writer.append(teams.get(i).getTabte() + ",\n");
					 writer.append(teams.get(i).getVundne() + ",\n");
					 writer.append(teams.get(i).getMål() + ",\n");
					 writer.append(teams.get(i).getMålImod() + ",\n");
					 writer.append(teams.get(i).getPoints() + ",\n");
		             }
				writer.write(writer.toString());
				writer.flush();
				writer.close();
			} catch (EOFException e) {
				throw e;
			}
			
			System.out.println("CSV export done.");
			
		}
}
