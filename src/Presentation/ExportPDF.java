package Presentation;

import java.io.FileNotFoundException;
import java.util.List;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import Domain.Event;
import Domain.Match;

public class ExportPDF {

	public void createPDF(Match match, List<Event> events) {

		try {
			PdfWriter writer = new PdfWriter("C:\\MatchReport\\Match ID - " + match.getId() +" "+  match.getHjemmeholdNavn() +" - " + match.getUdeholdNavn() +".pdf");
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);
			
			document.add(new Paragraph("Match ID: " + match.getId() + "\n"));
			document.add(new Paragraph("Home team: " + match.getHjemmeholdNavn() + "\n"));
			document.add(new Paragraph("Away team: " + match.getUdeholdNavn() + "\n"));
			 for(int i=0; i < events.size(); i++) {
				 document.add(new Paragraph("Event: " + events.get(i).getEvent() + "\n"));
				 document.add(new Paragraph("Team ID: " + events.get(i).getHoldid() + "\n")); // HOLDNAVN I STEDET HVIS DET VIRKER
				 document.add(new Paragraph("Date/time: " + events.get(i).getTid() + "\n"));
	             }
			 document.add(new Paragraph("Match date/time: " + match.getDatoTid() + "\n"));
			 document.close();
			 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("PDF export done.");

	}

}