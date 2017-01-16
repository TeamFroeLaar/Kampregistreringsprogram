package Presentation;

import java.sql.Timestamp;

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
		stage.setMinHeight(500);
		stage.setMinWidth(500);

		// TableView matches
		TableView<Match> matchesTable = new TableView<Match>();
		matchesTable.setEditable(true);
		ObservableList<Match> data;
		data = FXCollections.observableArrayList(KRPLogic.getMatch());
		
		TableColumn<Match, Integer> matchID = new TableColumn<Match, Integer>("MatchID");
		matchID.setCellValueFactory(new PropertyValueFactory<Match, Integer>("id"));

		TableColumn<Match, Integer> homeTeamName = new TableColumn<Match, Integer>("Home");
		homeTeamName.setCellValueFactory(new PropertyValueFactory<Match, Integer>("hjemmeholdId"));

		TableColumn<Match, Integer> awayTeamName = new TableColumn<Match, Integer>("Away");
		awayTeamName.setCellValueFactory(new PropertyValueFactory<Match, Integer>("udeholdId"));

		TableColumn<Match, Timestamp> dateTime = new TableColumn<Match, Timestamp>("Date/Time");
		dateTime.setCellValueFactory(new PropertyValueFactory<Match, Timestamp>("datoTid"));

		matchesTable.setItems(data);
		matchesTable.getColumns().addAll(matchID, homeTeamName, awayTeamName, dateTime);
		grid.add(matchesTable, 1, 0);

		// Buttons
		Button tilbage = new Button("Return");
		grid.add(tilbage, 0, 2);
		tilbage.setPrefSize(100, 50);
		tilbage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Main view = new Main();
				view.start(stage);
			}
		});
		Button viewThisMatch = new Button("View match");
		grid.add(viewThisMatch, 1, 2);
		viewThisMatch.setPrefSize(100, 50);
		viewThisMatch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ViewMatch view = new ViewMatch(stage);
				view.init();
			}
		});
		Button editMatch = new Button("Edit match");
		grid.add(editMatch, 2, 2);
		editMatch.setPrefSize(100, 50);
		editMatch.setOnAction(new EventHandler<ActionEvent>() {
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
