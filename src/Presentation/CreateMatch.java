package Presentation;

import java.util.List;
import Domain.Match;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
		
		grid.setGridLinesVisible(false);

		// Labels
		Label hjemmebane = new Label("Hjemme Bane");
//		grid.add(hjemmebane, 0, 1);
		Label udebane = new Label("Ude Bane");
//		grid.add(udebane, 1, 1);

		// DropDown (hjemmebane)
		data = KRPLogic.getTeams();
		ObservableList<Team> hjemmeoptions = FXCollections.observableArrayList(data);

		final ComboBox<Team> hHoldoptions = new ComboBox<Team>(hjemmeoptions);
		VBox hholdfelt = new VBox();
		hholdfelt.setSpacing(10);

		hholdfelt.getChildren().addAll(hjemmebane, hHoldoptions);
//		grid.add(holdfelt, 0, 2);

		// DropDown (udebane)
		ObservableList<Team> udeoptions = FXCollections.observableArrayList(data);

		final ComboBox<Team> uHoldoptions = new ComboBox<Team>(udeoptions);
		VBox uholdfelt = new VBox();
		uholdfelt.setSpacing(10);

		uholdfelt.getChildren().addAll(udebane, uHoldoptions);
//		grid.add(uholdfelt, 1, 2);
		HBox hboxOptons = new HBox();
		hboxOptons.setSpacing(10);
		hboxOptons.getChildren().addAll(hholdfelt, uholdfelt);
		grid.add(hboxOptons, 0, 0);
		
		
		// TextField (erstattes med Calender)
		TextField dateTime = new TextField();
		dateTime.setPromptText("YYYY-MM-DD hh:mm:ss");
		grid.add(dateTime, 0, 2);
		
		// Buttons
		Button opret = new Button("opret");
//		grid.add(opret, 0, 4);
		opret.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				KRPLogic logic = new KRPLogic();
				Match newMatch = new Match();
				newMatch.setHjemmeholdId(hHoldoptions.getValue().getId());
				newMatch.setUdeholdId(uHoldoptions.getValue().getId());
				newMatch.setDatoTid(dateTime.getText());
				
				logic.createMatch(newMatch);
			}
		});
		
		Button tilbage = new Button("return");
//		grid.add(tilbage, 1, 4);
		tilbage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Main view = new Main();
				view.start(stage);
			}
		});

		HBox test = new HBox();
		test.setSpacing(10);
		test.getChildren().addAll(opret, tilbage);
		
		grid.add(test, 0, 3);
		
		Scene creatematch = new Scene(grid, 400, 375);
		stage.setScene(creatematch);
		creatematch.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		stage.sizeToScene();
		stage.show();
	}
}