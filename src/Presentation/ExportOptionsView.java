package Presentation;

import java.io.IOException;

import Domain.Event;
import Domain.Match;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ExportOptionsView {

	private Stage stage;
	private GridPane grid;
	private String matchID;

	public ExportOptionsView(Stage stage, String matchID) {
		this.stage = stage;
		this.matchID = matchID;
	}

	public void init() {
		stage.setTitle("Export options");
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(25);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		// Mikkel Hansen
		Image mikkelHansen = new Image("Presentation/mikkel.png");
		ImageView imageView = new ImageView();
		imageView.setImage(mikkelHansen);
		imageView.setFitWidth(200);
		imageView.setFitHeight(200);
		imageView.setPreserveRatio(true);
		imageView.setSmooth(true);
		imageView.setCache(true);
		grid.add(imageView, 1, 5);

		// GridLine
		grid.setGridLinesVisible(false);

		// DropDown export
		ObservableList<String> exportOptions = FXCollections.observableArrayList("CSV", "PDF");

		final ComboBox<String> cmbExportStrings = new ComboBox<String>(exportOptions);
		HBox exportOptionsField = new HBox();
		exportOptionsField.getChildren().add(cmbExportStrings);
		cmbExportStrings.setValue("CSV");
		grid.add(exportOptionsField, 1, 0);
		exportOptionsField.setAlignment(Pos.CENTER);

		// Export
		Button export = new Button("Export");
		grid.add(export, 2, 0);
		export.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				if (cmbExportStrings.getValue() == "CSV") {
					ExportCSV exportCSV = new ExportCSV();
					Match match = KRPLogic.selectMatch(matchID);
					Event event = new Event();
					event.setKampid(match.getId());
					try {
						exportCSV.exportCSV(match, KRPLogic.getEvent(event));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (cmbExportStrings.getValue() == "PDF") {
					
				}
			}
		});

		// return
		Button goBack = new Button("Return");
		grid.add(goBack, 0, 0);
		goBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ViewMatch view = new ViewMatch(stage, matchID);
				view.init();
			}
		});

		Scene viewExportOptions = new Scene(grid, 400, 300);
		stage.setScene(viewExportOptions);
		viewExportOptions.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		stage.show();

	}

}
