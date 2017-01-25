package Presentation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import Domain.Event;
import Domain.Match;
import Domain.Team;
import Logic.KRPLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CSVReader {
	private List<Team> data;
	List<Team> listeTeams;
	private Stage stage;
	private GridPane grid;
	public Match newMatch = new Match();
	public KRPLogic logic = new KRPLogic();

	public CSVReader(Stage stage) {
		this.stage = stage;
	}

	public void init() {
		stage.setTitle("Import");
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		grid.setGridLinesVisible(true);

		// Labels
		Label hjemmebane = new Label("Hjemme Bane");
		Label udebane = new Label("Ude Bane");

		// DropDown (hjemmebane)
		data = KRPLogic.getTeams();
		ObservableList<Team> hjemmeoptions = FXCollections.observableArrayList(data);

		final ComboBox<Team> hHoldoptions = new ComboBox<Team>(hjemmeoptions);
		VBox hholdfelt = new VBox();
		hholdfelt.setSpacing(10);

		hholdfelt.getChildren().addAll(hjemmebane, hHoldoptions);

		// DropDown (udebane)
		ObservableList<Team> udeoptions = FXCollections.observableArrayList(data);

		final ComboBox<Team> uHoldoptions = new ComboBox<Team>(udeoptions);
		VBox uholdfelt = new VBox();
		uholdfelt.setSpacing(10);

		uholdfelt.getChildren().addAll(udebane, uHoldoptions);
		HBox hboxOptons = new HBox();
		hboxOptons.setSpacing(10);
		hboxOptons.getChildren().addAll(hholdfelt, uholdfelt);
		grid.add(hboxOptons, 0, 0);

		TextField KampId = new TextField();
		KampId.setPromptText("Insert kampid");
		grid.add(KampId, 0, 2);

		Button importbtn = new Button("import");
		importbtn.setPrefSize(300, 25);
		grid.add(importbtn, 0, 3);
		importbtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Match pickMatch = new Match();
				pickMatch.setId(KampId.getText());
				pickMatch.setHjemmeholdId(hHoldoptions.getValue().getId());
				pickMatch.setUdeholdId(uHoldoptions.getValue().getId());
				pickMatch.setHjemmeholdNavn(hHoldoptions.getValue().getHoldnavn());
				pickMatch.setUdeholdNavn(uHoldoptions.getValue().getHoldnavn());
				
				// Get scanner instance
				String csvFile = "C:\\MatchReport\\Match ID - " + pickMatch.getId() + " " + pickMatch.getHjemmeholdId() + " - " + pickMatch.getUdeholdId() + ".csv";
				BufferedReader br = null;
				String line = "";
				String cvsSplitBy = ",";

				try {
					br = new BufferedReader(new FileReader(csvFile));
					{
						line = br.readLine();
						String[] matchreport = line.split(cvsSplitBy);
						pickMatch.setDatoTid(matchreport[3]);
						System.out.println(pickMatch);
						logic.createMatchWId(pickMatch);
					}
					while ((line = br.readLine()) != null) {
						String[] matchreport = line.split(cvsSplitBy);
						Event newEvent = new Event();
						newEvent.setEvent(matchreport[0]);
						newEvent.setHoldid(matchreport[1]);
						newEvent.setKampid(pickMatch.getId());
						newEvent.setTid(matchreport[2]);
						System.out.println(newEvent);
						logic.createEvent(newEvent);
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (br != null) {
						try {
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		Button tilbage = new Button("return");
		tilbage.setPrefSize(300, 25);
		grid.add(tilbage, 0, 4);
		tilbage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Main view = new Main();
				view.start(stage);
			}
		});

		Scene CSVReader = new Scene(grid, 400, 375);
		stage.setScene(CSVReader);
		CSVReader.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		stage.sizeToScene();
		stage.show();

	}
}
