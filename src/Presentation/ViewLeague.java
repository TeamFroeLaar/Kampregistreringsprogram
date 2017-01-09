package Presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
		
		//TableView Rækker
		TableColumn<Hold, String> stillingCol = new TableColumn<Hold, String>("Stilling");
		stillingCol.setCellValueFactory(new PropertyValueFactory<Hold, String>("stilling");
		
		TableColumn<Hold, String> holdnavnCol = new TableColumn<Hold, String>("Hold navn");
		holdnavnCol.setCellValueFactory(new PropertyValueFactory<Hold, String>("holdnavn");
		
		TableColumn<Hold, String> maalCol = new TableColumn<Hold, String>("Mål");
		maalCol.setCellValueFactory(new PropertyValueFactory<Hold, String>("mål");
		
		TableColumn<Hold, String> udvisningsCol = new TableColumn<Hold, String>("Udvisninger");
		udvisningsCol.setCellValueFactory(new PropertyValueFactory<Hold, String>("udvisninger");
		
		TableColumn<Hold, String> pointCol = new TableColumn<Hold, String>("Points");
		pointCol.setCellValueFactory(new PropertyValueFactory<Hold, String>("points");
		
		Scene viewleague = new Scene(grid, 400, 375);
		stage.setScene(viewleague);
		stage.show();
	}
}

