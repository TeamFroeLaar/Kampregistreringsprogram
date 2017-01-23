package Presentation;

import Domain.Event;
import Domain.League;
import Domain.Match;
import Logic.KRPLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

	public void init() {
		stage.setTitle("View league");
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		// TableView
		TableView<League> leagueTable = new TableView<>();
		ObservableList<League> data;
//		data = FXCollections.observableArrayList(KRPLogic.getLeague());
 
		// TableView Rækker
		TableColumn<League, String> stillingCol = new TableColumn<League, String>("Stilling");
		stillingCol.setCellValueFactory(new PropertyValueFactory<League, String>("stilling"));

		TableColumn<League, String> holdnavnCol = new TableColumn<League, String>("Hold navn");
		holdnavnCol.setCellValueFactory(new PropertyValueFactory<League, String>("holdnavn"));

		TableColumn<League, String> maalCol = new TableColumn<League, String>("Mål");
		maalCol.setCellValueFactory(new PropertyValueFactory<League, String>("mål"));
		
		TableColumn<League, String> winCol = new TableColumn<League, String>("Vundne kampe");
		winCol.setCellValueFactory(new PropertyValueFactory<League, String>("event"));
		
		TableColumn<League, String> lossCol = new TableColumn<League, String>("Tabte kampe");
		lossCol.setCellValueFactory(new PropertyValueFactory<League, String>("event"));

		TableColumn<League, String> eventCol = new TableColumn<League, String>("Event");
		eventCol.setCellValueFactory(new PropertyValueFactory<League, String>("event"));

		TableColumn<League, String> pointCol = new TableColumn<League, String>("Points");
		pointCol.setCellValueFactory(new PropertyValueFactory<League, String>("points"));

		leagueTable.setMinSize(800, 600);
		leagueTable.setEditable(true);
//		leagueTable.setItems(data);
		leagueTable.getColumns().addAll(stillingCol,  holdnavnCol, lossCol, pointCol, winCol, lossCol);
		grid.add(leagueTable, 0, 0);
		
		//Buttons
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
		stage.setFullScreen(true);
		stage.show();
	}
}
