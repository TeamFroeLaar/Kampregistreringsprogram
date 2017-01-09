package Presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewLeague {
	private Stage stage;
	private GridPane grid;
	
	public ViewLeague(Stage stage) {
		this.stage = stage;
	
	}

	public void init() 
	{
		stage.setTitle("View league");
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		//TableView
		TableView<Hold> table = new TableView<>();
		table.setEditable(true);
		table.setItems(data);
		
		Scene viewleague = new Scene(grid, 400, 375);
		stage.setScene(viewleague);
		stage.show();
	}
}

