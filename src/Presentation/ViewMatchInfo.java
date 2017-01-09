package Presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewMatchInfo {
	private Stage stage;
	private GridPane grid;
	
	public ViewMatchInfo(Stage stage) {
		this.stage = stage;
	
	}

	public void init() 
	{
		stage.setTitle("View match info");
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Scene viewmatchinfo = new Scene(grid, 400, 375);
		stage.setScene(viewmatchinfo);
		stage.show();
	}
}

