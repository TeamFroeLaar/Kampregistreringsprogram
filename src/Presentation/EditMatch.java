package Presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EditMatch {
	private Stage stage;
	private GridPane grid;
	private GridPane hjemmeholdGrid;
	private GridPane udeholdGrid;
	
	public EditMatch(Stage stage) {
		this.stage = stage;
	}

	public void init() 
	{
		//main grid
		stage.setTitle("View match info");
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		//hjemme- og udeholdgrid
		hjemmeholdGrid = new GridPane();
		hjemmeholdGrid.setAlignment(Pos.TOP_CENTER);
		hjemmeholdGrid.setHgap(10);
		hjemmeholdGrid.setVgap(10);
		hjemmeholdGrid.setPadding(new Insets(25, 25, 25, 25));
		
		udeholdGrid = new GridPane();
		udeholdGrid.setAlignment(Pos.TOP_CENTER);
		udeholdGrid.setHgap(10);
		udeholdGrid.setVgap(10);
		udeholdGrid.setPadding(new Insets(25, 25, 25, 25));
		
		grid.add(hjemmeholdGrid, 0, 0);
		grid.add(udeholdGrid, 2, 0);
		
		
		//gridlines
		grid.setGridLinesVisible(false);
		udeholdGrid.setGridLinesVisible(false);
		hjemmeholdGrid.setGridLinesVisible(false);
		
		//Buttons til hjemmeholdGrid
		Label hjemmeHold = new Label("Hjemmehold");
		hjemmeholdGrid.add(hjemmeHold, 0, 0);
		Button PenaltyHome = new Button("Penalty");
		hjemmeholdGrid.add(PenaltyHome, 0, 1);
		PenaltyHome.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		Button redCardHome = new Button("Red card");
		hjemmeholdGrid.add(redCardHome, 0, 2);
		redCardHome.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		Button yellowCardHome = new Button("Yellow card");
		hjemmeholdGrid.add(yellowCardHome, 0, 3);
		yellowCardHome.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		Button goalHome = new Button("Goal");
		hjemmeholdGrid.add(goalHome, 0, 4);
		goalHome.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		
		//Buttons til udeholdGrid
		Label udeHold = new Label("Udehold");
		udeholdGrid.add(udeHold, 0, 0);
		Button PenaltyOut = new Button("Penalty");
		udeholdGrid.add(PenaltyOut, 0, 1);
		PenaltyOut.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		Button redCardOut = new Button("Red card");
		udeholdGrid.add(redCardOut, 0, 2);
		redCardOut.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		Button yellowCardOut = new Button("Yellow card");
		udeholdGrid.add(yellowCardOut, 0, 3);
		yellowCardOut.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		Button goalOut = new Button("Goal");
		udeholdGrid.add(goalOut, 0, 4);
		goalOut.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		//Buttons til main
		Button tilbage = new Button("return");
		grid.add(tilbage, 0, 1);
		tilbage.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				ViewMatch view = new ViewMatch(stage);
				view.init();
			}
		});
		
		Scene viewmatchinfo = new Scene(grid, 400, 375);
		stage.setScene(viewmatchinfo);
		stage.show();
	}
}

