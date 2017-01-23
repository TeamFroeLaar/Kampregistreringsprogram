package Presentation;

import java.sql.Timestamp;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
		stage.setMinHeight(600);
		stage.setMinWidth(650);

		// TableView matches
		TableView<Match> matchesTable = new TableView<Match>();
		matchesTable.setEditable(true);
		ObservableList<Match> data;

		data = FXCollections.observableArrayList(KRPLogic.getMatch());

		TableColumn<Match, Integer> matchID = new TableColumn<Match, Integer>("MatchID");
		matchID.setCellValueFactory(new PropertyValueFactory<Match, Integer>("id"));
		matchID.setMinWidth(150);
		
		TableColumn<Match, Integer> homeTeamName = new TableColumn<Match, Integer>("Home");
		homeTeamName.setCellValueFactory(new PropertyValueFactory<Match, Integer>("hjemmeholdNavn"));
		homeTeamName.setMinWidth(150);
		
		TableColumn<Match, Integer> awayTeamName = new TableColumn<Match, Integer>("Away");
		awayTeamName.setCellValueFactory(new PropertyValueFactory<Match, Integer>("udeholdNavn"));
		awayTeamName.setMinWidth(150);
		
		TableColumn<Match, Timestamp> dateTime = new TableColumn<Match, Timestamp>("Date/Time");
		dateTime.setCellValueFactory(new PropertyValueFactory<Match, Timestamp>("datoTid"));
		dateTime.setMinWidth(130);
		 
		matchesTable.setItems(data);
		matchesTable.getColumns().addAll(matchID, homeTeamName, awayTeamName, dateTime);
		matchesTable.setMinSize(500, 400);
		grid.add(matchesTable, 1, 0);


		// Buttons
		Button tilbage = new Button("Return");
		tilbage.setPrefSize(250, 50);
		tilbage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Main view = new Main();
				view.start(stage);
			}
		});
		Button viewThisMatch = new Button("View match");
		viewThisMatch.setPrefSize(250, 50);
		viewThisMatch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Match rowData = matchesTable.getSelectionModel().getSelectedItem();

				Team hjemmehold = new Team();
				hjemmehold.setHoldnavn(rowData.getHjemmeholdNavn());
				hjemmehold.setId(rowData.getHjemmeholdId());
				
				Team udehold = new Team();
				udehold.setHoldnavn(rowData.getUdeholdNavn());
				udehold.setId(rowData.getUdeholdId());
				
				Event kampEvents = new Event();
				kampEvents.getEvent();
				kampEvents.getHoldid();
				kampEvents.getId();
				kampEvents.getKampid();
				kampEvents.getTid();
				
				ViewMatch view = new ViewMatch(stage);
				view.init(hjemmehold, udehold, rowData);	
			}
		});
		Button editMatch = new Button("Edit match");
		editMatch.setPrefSize(250, 50);

		matchesTable.setRowFactory(newSelection -> {
			TableRow<Match> row = new TableRow<>();
			editMatch.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Match rowData = matchesTable.getSelectionModel().getSelectedItem();

					Team hjemmehold = new Team();
					hjemmehold.setHoldnavn(rowData.getHjemmeholdNavn());
					hjemmehold.setId(rowData.getHjemmeholdId());
					
					Team udehold = new Team();
					udehold.setHoldnavn(rowData.getUdeholdNavn());
					udehold.setId(rowData.getUdeholdId());
					
					Event kampEvents = new Event();
					kampEvents.getEvent();
					kampEvents.getHoldid();
					kampEvents.getId();
					kampEvents.getKampid();
					kampEvents.getTid();
					
					EditMatch view = new EditMatch(stage);
					view.init(hjemmehold, udehold, rowData);		
				}
			});
			return row;
		});
		// Hbox
		HBox knapper = new HBox();
		knapper.getChildren().addAll(tilbage, editMatch, viewThisMatch);
		knapper.setSpacing(10);
		knapper.setAlignment(Pos.CENTER);
		grid.add(knapper, 1, 1);

		Scene viewMatch = new Scene(grid, 400, 375);
		stage.setScene(viewMatch);
		viewMatch.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		stage.sizeToScene();
		stage.show();
	}
}
