package Presentation;

import java.util.List;

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
	private List<Match> data;
	List<Match> matchList;
	
	
	public ViewMatch (Stage stage, String matchID) {
		this.stage = stage;
		this.matchID = matchID;
	}
	
	@SuppressWarnings("unchecked")
	public void init() 
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
				grid.setGridLinesVisible(false);
				homeTeamGrid.setGridLinesVisible(false);
				awayTeamGrid.setGridLinesVisible(false);
				
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
				
				// TableView
				TableView<Match> matchTable = new TableView<>();
				matchTable.setEditable(true);
								
				TableColumn<Match, String> teamName = new TableColumn<Match, String>("Team");
				teamName.setCellValueFactory(new PropertyValueFactory<Match, String>("team"));
				
				TableColumn<Match, String> eventCol = new TableColumn<Match, String>("Event");
				eventCol.setCellValueFactory(new PropertyValueFactory<Match, String>("event"));
				
				TableColumn<Match, String> timestampCol = new TableColumn<Match, String>("Timestamp");
				timestampCol.setCellValueFactory(new PropertyValueFactory<Match, String>("timestamp"));
				
				matchTable.getColumns().addAll(teamName, eventCol, timestampCol);
				grid.add(matchTable, 1, 1);
				
				data = KRPLogic.getMatch();
				ObservableList<Match> MatchList = FXCollections.observableArrayList(data);
				
				matchTable.setItems(MatchList); 
						
				
				
				
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
	
