package Presentation;

import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Domain.Event;
import Domain.Match;



public class ExportCSV {
	public void exportCSV (Match match) throws IOException {
		Match m = new Match();
		Event eventMatch = new Event();
		try {
			FileWriter writer = new FileWriter(new File("C:\\MatchReport","test.csv"));
			writer.append(m.getId());
			writer.append(m.getHjemmeholdNavn());
			writer.append(m.getUdeholdNavn());
			writer.append(eventMatch.getEvent());
			writer.append(m.getDatoTid());
			writer.write(writer.toString());
			writer.close();
		} catch (EOFException e) {
			throw e;
		}
		
		System.out.println("CSV export done.");
	
	}
}
