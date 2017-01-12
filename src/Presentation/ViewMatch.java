package Presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
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
	
	public ViewMatch (Stage stage) {
		this.stage = stage;
	}
	
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
				Text twoMinutePenalty = new Text("2-min penalty");
				homeTeamGrid.add(twoMinutePenalty, 0, 1);
				
				
				
		Button tilbage = new Button("Return");
		grid.add(tilbage, 0, 1);
		tilbage.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				ViewMatches view = new ViewMatches(stage);
				view.init();
			}
		});
		
		Scene viewMatchInfo = new Scene(grid, 500, 800);
		stage.setScene(viewMatchInfo);
		stage.show();
	
	
	}	
	
}
	
