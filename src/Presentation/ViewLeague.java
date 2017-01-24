package Presentation;

import java.util.ArrayList;
import java.util.List;

import Domain.Match;
import Domain.Team;
import Logic.KRPLogic;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewLeague {
	private Stage stage;
	private GridPane grid;

	public ViewLeague(Stage stage) {
		this.stage = stage;

	}

	@SuppressWarnings("unchecked")
	public void init() {
		stage.setTitle("View league");
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		// TableView
		TableView<Team> leagueTable = new TableView<>();
		
		addDataToLeagueTable(leagueTable);

		TableColumn<Team, String> stillingCol = new TableColumn<Team, String>("Stilling");
//		stillingCol.getTableView().getItems().size();
		
		TableColumn<Team, String> holdnavnCol = new TableColumn<Team, String>("Holdnavn");
		holdnavnCol.setCellValueFactory(new PropertyValueFactory<Team, String>("holdnavn"));
		
		TableColumn<Team, String> vundnetCol = new TableColumn<Team, String>("Vundet");
		
		TableColumn<Team, String> uafgjortCol = new TableColumn<Team, String>("Uafgjorte");
		
		TableColumn<Team, String> tabteCol = new TableColumn<Team, String>("Tabte");
		
		TableColumn<Team, String> maalCol = new TableColumn<Team, String>("Mål");

		TableColumn<Team, String> pointCol = new TableColumn<Team, String>("Points");
		pointCol.setCellValueFactory(new PropertyValueFactory<Team, String>("points"));
		pointCol.setSortType(TableColumn.SortType.DESCENDING);

		leagueTable.setMinSize(800, 600);
		leagueTable.setEditable(true);

		leagueTable.getColumns().addAll(stillingCol, holdnavnCol, vundnetCol, uafgjortCol, tabteCol, maalCol, pointCol);
		leagueTable.getSortOrder().add(pointCol);
		grid.add(leagueTable, 0, 0);
		

		// Buttons
		Button tilbage = new Button("return");
		grid.add(tilbage, 0, 5);
		tilbage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Main view = new Main();
				view.start(stage);
			}
		});

		Button export = new Button("Export");
		grid.add(export, 0, 4);
		export.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

			}
		});

		Scene viewleague = new Scene(grid, 1200, 800);
		stage.setScene(viewleague);
		stage.setFullScreen(false);
		stage.show();

	}

	//Tilføjer data til league table
	private void addDataToLeagueTable(TableView<Team> leagueTable) {
		
		List<Team> teamList = new ArrayList<Team>();

		// Henter kampe
		List<Match> matchList = KRPLogic.getMatch();

		//For hver kamp der returneres fra DB
		for (int i = 0; i < matchList.size(); i++) {

			//Ny instans af hold 1
			Team team1 = new Team();
			
			//Tjek om holdet, med dette ID, findes i vores teamList
			int team1IDInList = getTeamIndexInList(teamList, matchList.get(i).getHjemmeholdId());
			
			//Hvis holdet findes, sætter vi vores team1-instans, lig med det hold, som vi har hentet fra vores liste, 
			if (team1IDInList != -1) {
				//hent hold i teamList ud fra det id som getTeamIndexInList returnerede
				team1 = teamList.get(team1IDInList);
			}
			
			//sætter holdnavn på team1 instans
			team1.setHoldnavn(matchList.get(i).getHjemmeholdNavn());
			//sætter holdid på team1 instans
			team1.setId(matchList.get(i).getHjemmeholdId());
			
			
			//samme som ovenfor med team 1
			Team team2 = new Team();
			int team2IDInList = getTeamIndexInList(teamList, matchList.get(i).getUdeholdId());
			if (team2IDInList != -1) {
				team2 = teamList.get(team2IDInList);
			}
			team2.setHoldnavn(matchList.get(i).getUdeholdNavn());
			team2.setId(matchList.get(i).getUdeholdId());
			
			
			//ny instans af krpLogic
			KRPLogic krpLogic = new KRPLogic();
			
			//hent antal mål fra db, som hold 1 og 2 har scoret, i kampen med det id, på den kamp som vi er ved lige nu.
			int team1Goals = krpLogic.selectNumberGoalsInfo(matchList.get(i).getHjemmeholdId(), matchList.get(i).getId());
			int team2Goals = krpLogic.selectNumberGoalsInfo(matchList.get(i).getUdeholdId(), matchList.get(i).getId());

			
			if (team1Goals > team2Goals) {
				int currentPoints = team1.getPoints();
				team1.setPoints(currentPoints + 2);
			}
			if (team2Goals > team1Goals) {
				int currentPoints = team2.getPoints();
				team2.setPoints(currentPoints + 2);
			}
			if (team2Goals == team1Goals) {
				int currentPointsTeam2 = team2.getPoints();
				int currentPointsTeam1 = team1.getPoints();
				team2.setPoints(currentPointsTeam2 + 1);
				team1.setPoints(currentPointsTeam1 + 1);

			}

			//hvis holdet ikke findes i teamList tilføjes det
			if (team1IDInList == -1) {
				teamList.add(team1);
			}
			//hvis holdet ikke findes i teamList tilføjes det
			if (team2IDInList == -1) {
				teamList.add(team2);
			}

		}

		System.out.println("Antal hold i teamlist: " + teamList.size());
		for (int i = 0; i < teamList.size(); i++) {
			System.out.println("Holdnavn: " + teamList.get(i).getHoldnavn());
			System.out.println("Points: " + teamList.get(i).getPoints());
		}

		leagueTable.setItems(FXCollections.observableArrayList(teamList));
	}

	//Tager imod en teamList og det ID som vi vil finde i teamList
	private int getTeamIndexInList(List<Team> teamList, String teamIDToGet) {
		
		//For hvert Team i teamList
		for (int i = 0; i < teamList.size(); i++) {

			//Hent ID på det team vi er nået tid
			String currentTeamID = teamList.get(i).getId();
			
			//Tjek om dette ID er det samme som det ID vi vil finde
			boolean sameID = new String(currentTeamID).equals(teamIDToGet);
			
			//Hvis de er ens, returnerer vi "i". altså det index vi er nået til i iterationen
			//Grunden til, at vi returnerer index ("i") er, at vi skal bruge det til at hente holdets info ud med fra teamList.
			if (sameID) {
				return i;
			}
		}
		
		//Hvis der ikke kunne findes et hold i teamList hvor ID==teamIDToGet, returnerer vi -1
		return -1;
	}
}
