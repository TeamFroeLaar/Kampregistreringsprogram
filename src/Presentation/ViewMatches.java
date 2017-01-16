package Presentation;

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

public class ViewMatches {
	private Stage stage;
	private GridPane grid;
	public ViewMatches(Stage stage) {
		this.stage = stage;

	}

	@SuppressWarnings("unchecked")
	public void init() {
		stage.setTitle("View matches");
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		// TableView
		TableView<Match> matchesTable = new TableView<>();
		matchesTable.setEditable(true);
		ObservableList<Match> matchOverview;
		matchOverview = FXCollections.observableArrayList(KRPLogic.getMatch());
	
		TableColumn<Match, Integer> matchID = new TableColumn<Match, Integer>("MatchID");
		matchID.setCellValueFactory(new PropertyValueFactory<Match, Integer>("ID"));
		
		TableColumn<Match, String> homeTeamName = new TableColumn<Match, String>("Home");
		homeTeamName.setCellValueFactory(new PropertyValueFactory<Match, String>("ID"));
		
		TableColumn<Match, String> awayTeamName = new TableColumn<Match, String>("Away");
		awayTeamName.setCellValueFactory(new PropertyValueFactory<Match, String>("ID"));
		
		TableColumn<Match, String> dateTime = new TableColumn<Match, String>("Date/Time");
		dateTime.setCellValueFactory(new PropertyValueFactory<Match, String>("TIMESTAMP"));
		
		matchesTable.setItems(matchOverview);
		matchesTable.getColumns().addAll(matchID, homeTeamName, awayTeamName, dateTime);
		grid.add(matchesTable, 1, 1);
		
		
		// Buttons
		Button tilbage = new Button("Return");
		grid.add(tilbage, 0, 5);
		tilbage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Main view = new Main();
				view.start(stage);
			}
		});
		Button sekamp = new Button("View match");
		grid.add(sekamp, 0, 4);
		sekamp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ViewMatch view = new ViewMatch(stage);
				view.init();
			}
		});
		Button redkamp = new Button("Edit match");
		grid.add(redkamp, 1, 4);
		redkamp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				EditMatch view = new EditMatch(stage);
				view.init();
			}
		});
		Scene viewMatch = new Scene(grid, 400, 375);
		stage.setScene(viewMatch);
		stage.show();
	}
}
