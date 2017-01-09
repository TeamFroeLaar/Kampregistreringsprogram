package Presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CreateMatch {
	private Stage stage;
	private GridPane grid;
	
	public CreateMatch(Stage stage) {
		this.stage = stage;
	
	}

	public void init() 
	{
		stage.setTitle("Create a match");
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Scene creatematch = new Scene(grid, 400, 375);
		stage.setScene(creatematch);
		stage.show();
	}
}

