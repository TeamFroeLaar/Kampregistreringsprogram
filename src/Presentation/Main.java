package Presentation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) {

		//Grids
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25)); 

		//Buttons
		Button createMatch = new Button("New Match");
		grid.add(createMatch, 1, 1);
		createMatch.setStyle("-fx-background-color:\n"
                + "        rgba(0,0,0,0.08),\n"
                + "        linear-gradient(#9a9a9a, #909090),\n"
                + "        linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%);\n"
                + "    -fx-background-insets: 0 0 -1 0,0,1;\n"
                + "    -fx-background-radius: 5,5,4;\n"
                + "    -fx-padding: 10 26 10 26;\n"
                + "    -fx-text-fill: #242d35;\n"
                + "    -fx-font-size: 14px;");
		createMatch.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub 
			}
		});
		
		Button createTeam = new Button("New team");
		grid.add(createTeam, 1, 2);
		createTeam.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				CreateTeam view = new CreateTeam(stage);
				view.init();
			}
		});

		Button editMatch = new Button("Edit match");
		grid.add(editMatch, 1, 3);
		editMatch.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
			}
		});
		
		Button showLiga = new Button("Show liga");
		grid.add(showLiga, 1, 4);
		showLiga.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
			}
		});
		
		//Launcher screne
		Scene scene = new Scene(grid, 400, 375);
		StackPane root = new StackPane();
		root.setId("pane");
		scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}