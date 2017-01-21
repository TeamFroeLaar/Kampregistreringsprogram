package Presentation;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewMatch {
	private Stage stage;
	private GridPane grid;
	private GridPane homeTeamGrid;
	private GridPane awayTeamGrid;
	private String matchID;
	private ObservableList<Event> data;
	List<Event> eventList;
	private TableView<Event> table;
	
	
	public ViewMatch (Stage stage) {
		this.stage = stage;
	}
	
	@SuppressWarnings("unchecked")
	public void init(Team hjemmehold, Team udehold, Match rowDataMatch) 
	{
		stage.setTitle("View match");
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		// home and away team grids
				homeTeamGrid = new GridPane();
				homeTeamGrid.setAlignment(Pos.TOP_CENTER);
				homeTeamGrid.setHgap(10);
				homeTeamGrid.setVgap(10);
				homeTeamGrid.setPadding(new Insets(25, 25, 25, 25));
				grid.add(homeTeamGrid, 0,0);

				awayTeamGrid = new GridPane();
				awayTeamGrid.setAlignment(Pos.TOP_CENTER);
				awayTeamGrid.setHgap(10);
				awayTeamGrid.setVgap(10);
				awayTeamGrid.setPadding(new Insets(25, 25, 25, 25));
				grid.add(awayTeamGrid, 2, 0);
				
				// gridlines
				grid.setGridLinesVisible(true);
				homeTeamGrid.setGridLinesVisible(true);
				awayTeamGrid.setGridLinesVisible(true);
				
				// boxes with scores
				Rectangle rectangleLeft = new Rectangle(75,75,75,75);
				rectangleLeft.setStroke(Color.BLACK);
				rectangleLeft.setFill(null);
				rectangleLeft.setStrokeWidth(3);
				
				Rectangle rectangleRight = new Rectangle(75, 75, 75, 75);
				rectangleRight.setStroke(Color.BLACK);
				rectangleRight.setFill(null);
				rectangleRight.setStrokeWidth(3);
		
// scores --------------------------------------------------- TO BE CHANGED				
				Text scoreRight = new Text("0");
				Text scoreLeft = new Text("0");
				
				// adds rectangles and scores to stackpane
				StackPane stackHomeTeam = new StackPane();
				stackHomeTeam.getChildren().addAll(rectangleLeft, scoreLeft);
				
				StackPane stackAwayTeam = new StackPane();
				stackAwayTeam.getChildren().addAll(rectangleRight, scoreRight);
				
				// home team match info
				Text homeTeam = new Text("Home");
				homeTeamGrid.add(homeTeam, 0, 0);
				Text homeTwoMinutePenalty = new Text("2-min penalties:");
				homeTeamGrid.add(homeTwoMinutePenalty, 0, 1);
				Text homeYellowCard = new Text("Yellow cards:");
				homeTeamGrid.add(homeYellowCard, 0, 2);
				Text homeRedCard = new Text("Red cards:");
				homeTeamGrid.add(homeRedCard, 0, 3);
				
				// away team match info
				Text awayTeam = new Text("Away");
				awayTeamGrid.add(awayTeam, 2, 0);
				Text awayTwoMinutePenalty = new Text("2-min penalties:");
				awayTeamGrid.add(awayTwoMinutePenalty, 2, 1);
				Text awayYellowCard = new Text("Yellow cards:");
				awayTeamGrid.add(awayYellowCard, 2, 2);
				Text awayRedCard = new Text("Red cards:");
				awayTeamGrid.add(awayRedCard, 2, 3);
				
				// Match rowdata
				Match matchData = rowDataMatch;
				matchData.setDatoTid(matchData.getDatoTid());
				matchData.setHjemmeholdId(matchData.getHjemmeholdId());
				matchData.setHjemmeholdNavn(matchData.getHjemmeholdNavn());
				matchData.setId(matchData.getId());
				matchData.setUdeholdId(matchData.getUdeholdId());
				matchData.setUdeholdNavn(matchData.getUdeholdNavn());
				
				// Event rowdata
				Event event = new Event();
				event.setKampid(rowDataMatch.getId());
				eventList = KRPLogic.getEvent(event);
				data = FXCollections.observableArrayList(eventList);
				
				// TableView
				table = new TableView<>();
				table.setEditable(true);
				table.setItems(data);
			
				// TableView Rækker
				TableColumn<Event, String> tidCol = new TableColumn<Event, String>("tid");
				tidCol.setCellValueFactory(new PropertyValueFactory<Event, String>("tid"));

				TableColumn<Event, String> eventCol = new TableColumn<Event, String>("Events");
				eventCol.setCellValueFactory(new PropertyValueFactory<Event, String>("event"));
				eventCol.setMinWidth(120);

				TableColumn<Event, String> holdCol = new TableColumn<Event, String>("Holdnavn");
				holdCol.setCellValueFactory(new PropertyValueFactory<Event, String>("holdnavn"));
				holdCol.setMinWidth(150);
				table.setMinSize(450, 500);
				
				table.getColumns().addAll(tidCol, eventCol, holdCol);
				grid.add(table, 1, 1);
				

				
		Button tilbage = new Button("Return");
		grid.add(tilbage, 0, 1);
		tilbage.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				ViewMatches view = new ViewMatches(stage);
				view.init();
			}
		});
		
		Button export = new Button ("Export");
		grid.add(export, 0, 2);
		export.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				ExportOptionsView exportOptionsView = new ExportOptionsView(stage, matchID);
				exportOptionsView.init();
			}
		});
		
		HBox hViewMatch = new HBox();
		hViewMatch.getChildren().addAll(stackHomeTeam, stackAwayTeam);
		hViewMatch.setSpacing(10);
		grid.add(hViewMatch, 1, 0);
		
		Scene viewMatchInfo = new Scene(grid, 500, 800);
		stage.setScene(viewMatchInfo);
		viewMatchInfo.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		stage.sizeToScene();
		stage.show();
	
	
	}	
	
}
	
