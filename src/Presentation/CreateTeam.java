package Presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CreateTeam {
	private Stage stage;
	private GridPane grid;
	
	public CreateTeam(Stage stage) {
		this.stage = stage;
	
	}

	public void init() 
	{
		stage.setTitle("Create a team");
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Scene createteam = new Scene(grid, 400, 375);
		stage.setScene(createteam);
		stage.show();
	}
}

