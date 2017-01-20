package Presentation;

import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Domain.Event;
import Domain.Match;



public class ExportCSV {
	public void exportCSV () throws IOException {
		Match match = new Match();
		Event eventMatch = new Event();
		try {
			FileWriter writer = new FileWriter(new File("C:\\MatchReport","test.csv"));
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(match.getId());
			stringBuilder.append(match.getHjemmeholdNavn());
			stringBuilder.append(match.getUdeholdNavn());
			stringBuilder.append(eventMatch.getEvent());
			stringBuilder.append(match.getDatoTid());
			writer.write(stringBuilder.toString());
			writer.close();
		} catch (EOFException e) {
			throw e;
		}
		
		System.out.println("CSV export done.");
	
	}
}
