package Presentation;

import java.util.List;

import Domain.Event;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ViewMatch {
	private Stage stage;
	private GridPane grid;
	private String matchID;
	private ObservableList<Event> data;
	List<Event> eventList;
	private TableView<Event> table;
	int hjemmeholdgoal;
	int udeholdgoal;
	int hjemmeholdpenalty;
	int udeholdpenalty;
	int hjemmeholdRedcard;
	int udeholdRedcard;
	int hjemmeholdYellowcard;
	int udeholdYellowcard;
	
	String hhgStr;
	String uhgStr;
	String hhpStr;
	String uhpStr;
	String hhrcStr;
	String uhrcStr;
	String hhycStr;
	String uhycStr;
	

	public ViewMatch(Stage stage) {
		this.stage = stage;
	}

	@SuppressWarnings("unchecked")
	public void init(Team hjemmehold, Team udehold, Match rowDataMatch) {
		stage.setTitle("View match");
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		// Match rowdata
		Match matchData = rowDataMatch;
		matchData.setDatoTid(matchData.getDatoTid());
		matchData.setHjemmeholdId(matchData.getHjemmeholdId());
		matchData.setHjemmeholdNavn(matchData.getHjemmeholdNavn());
		matchData.setId(matchData.getId());
		matchData.setUdeholdId(matchData.getUdeholdId());
		matchData.setUdeholdNavn(matchData.getUdeholdNavn());

		// boxes with scores
		Rectangle rectangleLeft = new Rectangle(90, 90, 90, 90);
		rectangleLeft.setStroke(Color.BLACK);
		rectangleLeft.setFill(null);
		rectangleLeft.setStrokeWidth(3);

		Rectangle rectangleRight = new Rectangle(90, 90, 90, 90);
		rectangleRight.setStroke(Color.BLACK);
		rectangleRight.setFill(null);
		rectangleRight.setStrokeWidth(3);
		
		setData(hjemmehold, udehold, matchData);

		// mål scores
		Label scoreHjem = new Label(hhgStr);
		Label scoreUd = new Label(uhgStr);

		// Vbox til hjemmehold
		VBox hjemmeholdVbox = new VBox();
		Label penaltyHjem = new Label("Penalty: " + hhpStr);
		Label redcardHjem = new Label("Red card: " + hhrcStr);
		Label yellowcardHjem = new Label("Yellow card: " + hhycStr);
		hjemmeholdVbox.getChildren().addAll(penaltyHjem, redcardHjem, yellowcardHjem);

		// Vbox til udehold
		VBox udeholdVbox = new VBox();
		Label penaltyUde = new Label("Penalty: " + uhpStr);
		Label redcardUde = new Label("Red card: " + uhrcStr);
		Label yellowcardUde = new Label("Yellow card: " + uhycStr);
		udeholdVbox.getChildren().addAll(penaltyUde, redcardUde, yellowcardUde);

		// adds rectangles and scores to stackpane
		StackPane stackHomeTeam = new StackPane();
		stackHomeTeam.getChildren().addAll(rectangleLeft, scoreHjem);
		StackPane stackAwayTeam = new StackPane();
		stackAwayTeam.getChildren().addAll(rectangleRight, scoreUd);

		// Event rowdata
		Event event = new Event();
		event.setKampid(rowDataMatch.getId());
		eventList = KRPLogic.getEvent(event);
		data = FXCollections.observableArrayList(eventList);

		// TableView
		table = new TableView<>();
		table.setEditable(true);
		table.setItems(data);

		// TableView Rækker
		TableColumn<Event, String> tidCol = new TableColumn<Event, String>("tid");
		tidCol.setCellValueFactory(new PropertyValueFactory<Event, String>("tid"));

		TableColumn<Event, String> eventCol = new TableColumn<Event, String>("Events");
		eventCol.setCellValueFactory(new PropertyValueFactory<Event, String>("event"));
		eventCol.setMinWidth(120);

		TableColumn<Event, String> holdCol = new TableColumn<Event, String>("Holdnavn");
		holdCol.setCellValueFactory(new PropertyValueFactory<Event, String>("holdnavn"));
		holdCol.setMinWidth(150);
		table.setMinSize(450, 500);

		table.getColumns().addAll(tidCol, eventCol, holdCol);
		grid.add(table, 1, 0);

		// buttons HBox
		HBox btnHBox = new HBox();
		btnHBox.setSpacing(10);
		grid.add(btnHBox, 1, 1);

		Button tilbage = new Button("Return");
		tilbage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ViewMatches view = new ViewMatches(stage);
				view.init();
			}
		});

		Button export = new Button("Export");
		export.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ExportOptionsView exportOptionsView = new ExportOptionsView(stage, matchID);
				exportOptionsView.init();
			}
		});
		
		Button refresh = new Button("Refresh");
		refresh.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				eventList.clear();

				Event e = new Event();
				e.setKampid(rowDataMatch.getId());

				eventList = KRPLogic.getEvent(e);
				data = FXCollections.observableArrayList(eventList);
				table.setItems(data);
				
				setData(hjemmehold, udehold, matchData);
				
				//sætter alle texters nye værdier
				scoreHjem.setText(hhgStr);;
				scoreUd.setText(uhgStr);
				penaltyHjem.setText("Penalty: " + hhpStr);
				redcardHjem.setText("Red card: " + hhrcStr);
				yellowcardHjem.setText("Yellow card: " + hhycStr);
				penaltyUde.setText("Penalty: " + uhpStr);
				redcardUde.setText("Red card: " + uhrcStr);
				yellowcardUde.setText("Yellow card: " + uhycStr);
			}
		});
		

		btnHBox.getChildren().addAll(tilbage, export, refresh);

		GridPane gridHomeTeam = new GridPane();
		gridHomeTeam.add(stackHomeTeam, 0, 0);
		gridHomeTeam.add(hjemmeholdVbox, 0, 1);
		gridHomeTeam.setAlignment(Pos.TOP_LEFT);
		grid.add(gridHomeTeam, 0, 0);

		GridPane gridAwayTeam = new GridPane();
		gridAwayTeam.add(stackAwayTeam, 0, 0);
		gridAwayTeam.add(udeholdVbox, 0, 1);
		gridAwayTeam.setAlignment(Pos.TOP_LEFT);
		grid.add(gridAwayTeam, 2, 0);

		// gridlines
		grid.setGridLinesVisible(true);
		gridHomeTeam.setGridLinesVisible(true);
		gridAwayTeam.setGridLinesVisible(true);

		Scene viewMatchInfo = new Scene(grid, 750, 600);
		stage.setScene(viewMatchInfo);
		viewMatchInfo.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		stage.sizeToScene();
		stage.show();

	}
	
	public void setData(Team hjemmehold, Team udehold, Match rowDataMatch) {
		Match matchData = rowDataMatch;
		KRPLogic k = new KRPLogic();
		
		hjemmeholdgoal = k.selectNumberGoalsInfo(hjemmehold.getId(), matchData.getId());
		udeholdgoal = k.selectNumberGoalsInfo(udehold.getId(), matchData.getId());
		hjemmeholdpenalty = k.selectNumberPenaltiesInfo(udehold.getId(), matchData.getId());
		udeholdpenalty = k.selectNumberPenaltiesInfo(udehold.getId(), matchData.getId());
		hjemmeholdRedcard = k.selectNumberRedCardInfo(hjemmehold.getId(), matchData.getId());
		udeholdRedcard = k.selectNumberRedCardInfo(udehold.getId(), matchData.getId());
		hjemmeholdYellowcard = k.selectNumberYellowCardInfo(hjemmehold.getId(), matchData.getId());
		udeholdYellowcard = k.selectNumberYellowCardInfo(udehold.getId(), matchData.getId());
		
		hhgStr = "" + hjemmeholdgoal;
		uhgStr = "" + udeholdgoal;
		hhpStr = "" + hjemmeholdpenalty;
		uhpStr = "" + udeholdpenalty;
		hhrcStr = "" + hjemmeholdRedcard;
		uhrcStr = "" + udeholdRedcard;
		hhycStr = "" + hjemmeholdYellowcard;
		uhycStr = "" + udeholdYellowcard;
		
	}

}
