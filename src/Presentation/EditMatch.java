
package Presentation;

import Domain.Match;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditMatch {
	private Stage stage;
	private GridPane grid;
	private GridPane hjemmeholdGrid;
	private GridPane udeholdGrid;
	private TableView<Match> table;
	private ObservableList<Match> plist;

	
	 public EditMatch(Stage stage) {
	 this.stage = stage;
	 }
	 
	@SuppressWarnings("unchecked")
	public void init() {
		// main grid
		stage.setTitle("edit match");
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		// hjemme- og udeholdgrid
		hjemmeholdGrid = new GridPane();
		hjemmeholdGrid.setAlignment(Pos.TOP_CENTER);
		hjemmeholdGrid.setHgap(10);
		hjemmeholdGrid.setVgap(10);
		hjemmeholdGrid.setPadding(new Insets(25, 25, 25, 25));

		udeholdGrid = new GridPane();
		udeholdGrid.setAlignment(Pos.TOP_CENTER);
		udeholdGrid.setHgap(10);
		udeholdGrid.setVgap(10);
		udeholdGrid.setPadding(new Insets(25, 25, 25, 25));

		grid.add(hjemmeholdGrid, 0, 0);
		grid.add(udeholdGrid, 2, 0);

		// gridlines
		grid.setGridLinesVisible(true);
		udeholdGrid.setGridLinesVisible(true);
		hjemmeholdGrid.setGridLinesVisible(true);

		// Box with numbers
		Rectangle r1 = new Rectangle(75	,75,75,75);
		r1.setStroke(Color.BLACK);
		r1.setFill(null);
		r1.setStrokeWidth(3);
		
		Rectangle r2 = new Rectangle(75, 75, 75, 75);
		r2.setStroke(Color.BLACK);
		r2.setFill(null);
		r2.setStrokeWidth(3);
		
		Text textH = new Text("0");
		Text textU = new Text("0");
		
		StackPane stackH = new StackPane();
		stackH.getChildren().addAll(r1, textH);
		
		StackPane stackU = new StackPane();
		stackU.getChildren().addAll(r2, textU);
		
		//TableView
		TableView<Match> table = new TableView<>();
		table.setEditable(true);
		//table.setItems(data);

		// TableView Rækker
		TableColumn<Match, String> timestampCol = new TableColumn<Match, String>("Timestamp");
		timestampCol.setCellValueFactory(new PropertyValueFactory<Match, String>("timestamp"));

		TableColumn<Match, String> eventCol = new TableColumn<Match, String>("Hold navn");
		eventCol.setCellValueFactory(new PropertyValueFactory<Match, String>("holdnavn"));
		
		table.getColumns().addAll(timestampCol, eventCol);
		grid.add(table, 1, 1);
	
		
		//Buttons til  hjemmeholdGrid		
		Label hjemmeHold = new Label("Hjemmehold");
		hjemmeholdGrid.add(hjemmeHold, 0, 0);
		Button PenaltyHome = new Button("Penalty");
		hjemmeholdGrid.add(PenaltyHome, 0, 1);
		PenaltyHome.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		Button redCardHome = new Button("Red card");
		hjemmeholdGrid.add(redCardHome, 0, 2);
		redCardHome.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		Button yellowCardHome = new Button("Yellow card");
		hjemmeholdGrid.add(yellowCardHome, 0, 3);
		yellowCardHome.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		Button goalHome = new Button("Goal");
		hjemmeholdGrid.add(goalHome, 0, 4);
		goalHome.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		
		//Buttons til udeholdGrid
		Label udeHold = new Label("Udehold");
		udeholdGrid.add(udeHold, 0, 0);
		Button PenaltyOut = new Button("Penalty");
		udeholdGrid.add(PenaltyOut, 0, 1);
		PenaltyOut.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		Button redCardOut = new Button("Red card");
		udeholdGrid.add(redCardOut, 0, 2);
		redCardOut.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		Button yellowCardOut = new Button("Yellow card");
		udeholdGrid.add(yellowCardOut, 0, 3);
		yellowCardOut.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		Button goalOut = new Button("Goal");
		udeholdGrid.add(goalOut, 0, 4);
		goalOut.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		//Return to ViewMatches
		Button tilbage = new Button("return");
		grid.add(tilbage, 0, 1);
		tilbage.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				ViewMatches view = new ViewMatches(stage);
				view.init();
			}
		});

		//Hbox
				HBox hRedMatch = new HBox();
				hRedMatch.getChildren().addAll(stackH, stackU);
				hRedMatch.setSpacing(10);
				grid.add(hRedMatch, 1, 0);
				
		Scene editmatchinfo = new Scene(grid, 500, 800);
		stage.setScene(editmatchinfo);
		stage.show();
	}
}
