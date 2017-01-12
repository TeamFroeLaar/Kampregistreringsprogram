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
	
	public ViewMatch(Stage stage) {
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
		
		// TableView
//		TableView<MatchID> table = new TableView<>();
//		table.setEditable(true);
//		table.setItems(data);

		// TableView Rækker
//		TableColumn<MatchID, String> stillingCol = new TableColumn<MatchID, String>("tablenavn");
//		stillingCol.setCellValueFactory(new PropertyValueFactory<MatchID, String>("dbnavn"));
//
//		TableColumn<MatchID, String> holdnavnCol = new TableColumn<MatchID, String>("tablenavn");
//		holdnavnCol.setCellValueFactory(new PropertyValueFactory<MatchID, String>("dbnavn"));
//
//		TableColumn<MatchID, String> maalCol = new TableColumn<MatchID, String>("tablenavn");
//		maalCol.setCellValueFactory(new PropertyValueFactory<MatchID, String>("dbnavn"));
//
//		TableColumn<MatchID, String> udvisningsCol = new TableColumn<MatchID, String>("tablenavn");
//		udvisningsCol.setCellValueFactory(new PropertyValueFactory<MatchID, String>("dbnavn"));
//
//		TableColumn<MatchID, String> pointCol = new TableColumn<MatchID, String>("tablenavn");
//		pointCol.setCellValueFactory(new PropertyValueFactory<MatchID, String>("dbnavn"));
//		
//		table.getColums().addAll()
	
		//Buttons
		Button tilbage = new Button("return");
		grid.add(tilbage, 0, 5);
		tilbage.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				Main view = new Main();
				view.start(stage);
			}
		});
		Button sekamp = new Button("Se Kamp");
		grid.add(sekamp, 1 , 5);
		sekamp.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				//Åben nyt vindue med kamp
			}
		});
		Button redkamp = new Button("Rediger Kamp");
		grid.add(redkamp, 1, 6);
		redkamp.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				EditMatch view = new EditMatch(stage);
				view.init();
			}
		});
		Scene viewMatch = new Scene(grid, 400, 375);
		stage.setScene(viewMatch);
		stage.show();
	}
}

