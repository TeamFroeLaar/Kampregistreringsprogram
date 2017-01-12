package Presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewMatch {
	private Stage stage;
	private GridPane grid;
	
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
		
		Scene viewMatchInfo = new Scene(grid, 500, 800);
		stage.setScene(viewMatchInfo);
		stage.show();
	
	
	}	
	
}
	
