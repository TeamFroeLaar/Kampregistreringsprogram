package Presentation;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) {

		//Grids
		GridPane grid = new GridPane();
		grid.setGridLinesVisible(false);
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25)); 
		
		stage.setTitle("Håndbold - Kampregistreringsprogram");
		stage.getIcons().add(new Image("Presentation/handball.png"));

		//Buttons
		Button createMatch = new Button("New match");
		grid.add(createMatch, 0, 0);
		
		createMatch.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				CreateMatch view = new CreateMatch(stage);
				view.init();
			}
		});
		Button createTeam = new Button("New team");
		grid.add(createTeam, 0, 1);
		createTeam.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				CreateTeam view = new CreateTeam(stage);
				view.init();
			}
		});

		Button ViewMatch = new Button("View match");
		grid.add(ViewMatch, 0, 2);
		ViewMatch.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				ViewMatches view = new ViewMatches(stage);
				view.init();
			}
		});
		
		Button showLiga = new Button("View league");
		grid.add(showLiga, 0, 3);
		showLiga.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				ViewLeague view = new ViewLeague(stage);
				view.init();
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