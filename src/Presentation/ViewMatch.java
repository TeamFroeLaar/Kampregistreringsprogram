package Presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
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
				grid.add(awayTeamGrid, 0, 2);
		
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
	
