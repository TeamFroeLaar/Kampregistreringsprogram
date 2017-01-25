package Presentation;

import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Domain.Event;
import Domain.Match;



public class ExportCSV {
	public void exportCSV (Match match, List<Event> events) throws IOException {
		try {
			FileWriter writer = new FileWriter(new File("C:\\MatchReport\\Match ID - " + match.getId() +" "+  match.getHjemmeholdId() +" - " + match.getUdeholdId() +".csv"));
			writer.append(match.getId() + ",");
			writer.append(match.getHjemmeholdId() + ",");
			writer.append(match.getUdeholdId() + ",");
			writer.append(match.getDatoTid() + ",\n");
			 for(int i=0; i < events.size(); i++) {
				 writer.append(events.get(i).getEvent() + ",");
				 writer.append(events.get(i).getHoldid() + ","); // HOLDNAVN I STEDET HVIS DET VIRKER
				 writer.append(events.get(i).getTid() + ",\n");
	             }
			writer.flush();
			writer.close();
		} catch (EOFException e) {
			throw e;
		}
		
		System.out.println("CSV export done.");
	
	}
}
