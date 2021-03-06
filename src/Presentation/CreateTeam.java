package Presentation;

import Domain.Team;
import Logic.KRPLogic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CreateTeam {
	private Stage stage;
	private GridPane grid;

	public CreateTeam(Stage stage) {
		this.stage = stage;
	}

	public void init() {
		stage.setTitle("Create a team");
		grid = new GridPane();
		grid.setGridLinesVisible(false);
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		// Textfields
		TextField navn = new TextField();
		grid.add(navn, 1, 0);
		Label Navn = new Label("Navn");
		grid.add(Navn, 0, 0);

		// Buttons
		Button create = new Button("create");
		grid.add(create, 0, 1);
		create.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				KRPLogic logic = new KRPLogic();
				Team newTeam = new Team();
				newTeam.setHoldnavn(navn.getText());

				if (navn.getText().trim().isEmpty()) {
					Label fejl = new Label("Insert a name");
					fejl.setTextFill(Color.web("#fc1919"));
					grid.add(fejl, 1, 2);
				} else {
					logic.createTeamInfo(newTeam);
				}

			}
		});

		Button tilbage = new Button("return");
		grid.add(tilbage, 1, 1);
		tilbage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Main view = new Main();
				view.start(stage);
			}
		});

		Scene createteam = new Scene(grid, 440, 150);
		stage.setScene(createteam);
		createteam.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		stage.sizeToScene();
		stage.show();
	}
}
