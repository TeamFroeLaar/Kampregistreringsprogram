package Presentation;

import java.util.List;

import Domain.Team;
import Logic.KRPLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CreateMatch {
	private List<Team> data;
	List<Team> listeTeams;
	private Stage stage;
	private GridPane grid;

	public CreateMatch(Stage stage) {
		this.stage = stage;

	}

	public void init() {
		stage.setTitle("Create a match");
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		// Labels n shit
		Label hjemmebane = new Label("Hjemme Bane");
		grid.add(hjemmebane, 0, 1);
		Label udebane = new Label("Ude Bane");
		grid.add(udebane, 1, 1);

		// DropDown (hjemmebane)
		data = KRPLogic.getTeams();
		ObservableList<Team> hjemmeoptions = FXCollections.observableArrayList(data);

		final ComboBox<Team> holdoptions = new ComboBox<Team>(hjemmeoptions);
		HBox holdfelt = new HBox();

		holdfelt.getChildren().add(holdoptions);
		grid.add(holdfelt, 0, 3);

		// DropDown (udebane)
		ObservableList<Team> udeoptions = FXCollections.observableArrayList(data);

		final ComboBox<Team> uholdoptions = new ComboBox<Team>(udeoptions);
		HBox uholdfelt = new HBox();

		uholdfelt.getChildren().add(uholdoptions);
		grid.add(uholdfelt, 1, 3);

		// Buttons
		Button tilbage = new Button("return");
		grid.add(tilbage, 0, 5);
		tilbage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Main view = new Main();
				view.start(stage);
			}
		});

		Button opret = new Button("opret");
		grid.add(opret, 1, 5);
		opret.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// opret metode
			}
		});

		Scene creatematch = new Scene(grid, 400, 375);
		stage.setScene(creatematch);
		stage.show();
	}
}