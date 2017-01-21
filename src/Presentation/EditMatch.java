
package Presentation;

import java.util.List;

import Domain.Event;
import Domain.Match;
import Domain.Team;
import Logic.KRPLogic;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EditMatch {
	Team rowDataHjemme;
	Team rowDataUde;
	private Stage stage;
	private GridPane grid;
	private GridPane hjemmeholdGrid;
	private GridPane udeholdGrid;
	private GridPane gridWatch;
	private TableView<Event> table;
	private ObservableList<Event> data;
	List<Event> eventList;

	// Intialiseringer for ur
	private Timeline timeline;
	private Label timerLabelsec = new Label();
	private Label timerLabelmin = new Label();
	private DoubleProperty timeSeconds = new SimpleDoubleProperty();
	private DoubleProperty timeMinutes = new SimpleDoubleProperty();
	private Duration time = Duration.ZERO, Start = Duration.ZERO;
	int durIntMin;
	int durIntSec;

	KRPLogic logic = new KRPLogic();
	Event e = new Event();
	Team t = new Team();
	Match m = new Match();

	public EditMatch(Stage stage) {

		this.stage = stage;
	}

	
	public void init(Team hjemmehold, Team udehold, Match rowDataMatch) {
		// Match rowdata
		Match matchData = rowDataMatch;
		matchData.setDatoTid(matchData.getDatoTid());
		matchData.setHjemmeholdId(matchData.getHjemmeholdId());
		matchData.setHjemmeholdNavn(matchData.getHjemmeholdNavn());
		matchData.setId(matchData.getId());
		matchData.setUdeholdId(matchData.getUdeholdId());
		matchData.setUdeholdNavn(matchData.getUdeholdNavn());

		// Event rowdata
		Event event = new Event();
		event.setKampid(rowDataMatch.getId());
		eventList = KRPLogic.getEvent(event);
		data = FXCollections.observableArrayList(eventList);

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

		// gridPane for timer
		gridWatch = new GridPane();
		gridWatch.setAlignment(Pos.TOP_CENTER);
		gridWatch.setVgap(5);

		grid.add(hjemmeholdGrid, 0, 1);
		grid.add(udeholdGrid, 2, 1);
		grid.add(gridWatch, 1, 0);

		// gridlines
		grid.setGridLinesVisible(false);
		udeholdGrid.setGridLinesVisible(false);
		hjemmeholdGrid.setGridLinesVisible(false);

		// TextField for saving time
		TextField timeTxt = new TextField();
		gridWatch.add(timeTxt, 0, 2);

		// UpdateButton
		Button updateTxt = new Button();
		updateTxt.setText("UpDaTe");
		updateTxt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String durStr = String.valueOf(getTime());
				durStr = durStr.substring(0, durStr.length() - 8);
				int durInt = Integer.parseInt(durStr);
				durIntMin = durInt / 60;
				durIntSec = durInt - (durIntMin * 60);

				timeTxt.setText(durIntMin + " min " + durIntSec + " sec");
			}
		});

		// StartTimer button
		Button startButton = new Button();
		startButton.setText("Start");
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent t) {
						Duration duration = ((KeyFrame) t.getSource()).getTime();
						time = time.add(duration);
						Start = Start.add(duration);

						String durStr = String.valueOf(getTime());
						durStr = durStr.substring(0, durStr.length() - 8);
						int durInt = Integer.parseInt(durStr);
						durIntMin = durInt / 60;
						durIntSec = durInt - (durIntMin * 60);

						// Vis durIntMin og durIntSec
 
						timeSeconds.set(durIntSec);
						timeMinutes.set(durIntMin);
					}
				}));
				timeline.setCycleCount(Timeline.INDEFINITE);
				timeline.play();
			}
		});

		// pauseTimer button
		Button pauseButton = new Button();
		pauseButton.setText("Pause");
		pauseButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				timeline.stop();
			}
		});

		// Labels to show time
		// sec
		timerLabelsec.textProperty().bind(timeSeconds.asString());
		timerLabelsec.setTextFill(Color.RED);
		timerLabelsec.setStyle("-fx-font-size: 4em;");

		// min
		timerLabelmin.textProperty().bind(timeMinutes.asString());
		timerLabelmin.setTextFill(Color.RED);
		timerLabelmin.setStyle("-fx-font-size: 4em;");

		// Hbox for timerButtons
		HBox timerButtonsBox = new HBox();
		timerButtonsBox.setAlignment(Pos.TOP_CENTER);
		timerButtonsBox.getChildren().addAll(startButton, pauseButton, updateTxt);
		timerButtonsBox.setSpacing(10);
		gridWatch.add(timerButtonsBox, 0, 1);

		// Hbox for timeLabels
		HBox timeLabelsBox = new HBox();
		timeLabelsBox.setAlignment(Pos.TOP_CENTER);
		timeLabelsBox.getChildren().addAll(timerLabelmin, timerLabelsec);
		timeLabelsBox.setSpacing(10);
		gridWatch.add(timeLabelsBox, 0, 0);

		// Box with goal-numbers
		Rectangle r1 = new Rectangle(90, 90, 90, 90);
		r1.setStroke(Color.BLACK);
		r1.setFill(null);
		r1.setStrokeWidth(3);

		Rectangle r2 = new Rectangle(90, 90, 90, 90);
		r2.setStroke(Color.BLACK);
		r2.setFill(null);
		r2.setStrokeWidth(3);

		KRPLogic k = new KRPLogic();
		
		int hjemmeholdgoal = k.selectNumberGoalsInfo(hjemmehold.getId(), matchData.getId());
		String hhgStr = "" + hjemmeholdgoal;
		
		int udeholdgoal = k.selectNumberGoalsInfo(udehold.getId(), matchData.getId());
		String uhgStr = "" + udeholdgoal;
		
		Text textH = new Text(hhgStr);
		Text textU = new Text(uhgStr);

		StackPane stackH = new StackPane();
		stackH.getChildren().addAll(r1, textH);

		StackPane stackU = new StackPane();
		stackU.getChildren().addAll(r2, textU);

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
		holdCol.setMinWidth(80);
		table.setMinSize(450, 500);
		table.getColumns().addAll(tidCol, eventCol, holdCol);
//		grid.add(table, 1, 2);

		// Buttons til hjemmeholdGrid
		Label hjemmeHoldLabel = new Label("Hjemmehold: " + hjemmehold.getHoldnavn());
		hjemmeHoldLabel.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		hjemmeholdGrid.add(hjemmeHoldLabel, 0, 0);

		Button PenaltyHome = new Button("Penalty");
		hjemmeholdGrid.add(PenaltyHome, 0, 1);
		PenaltyHome.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				e.setEvent("Penalty");
				e.setTid(timeTxt.getText());
				e.setHoldid(hjemmehold.getId());
				e.setKampid(matchData.getId());

				insertTime(timeTxt);

				refreshTable(rowDataMatch);
			}
		});

		Button redCardHome = new Button("Red card");
		hjemmeholdGrid.add(redCardHome, 0, 2);
		redCardHome.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				e.setEvent("Red card");
				e.setTid(timeTxt.getText());
				e.setHoldid(hjemmehold.getId());
				e.setKampid(matchData.getId());

				insertTime(timeTxt);

				refreshTable(rowDataMatch);
			}
		});

		Button yellowCardHome = new Button("Yellow card");
		hjemmeholdGrid.add(yellowCardHome, 0, 3);
		yellowCardHome.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				e.setEvent("Yellow card");
				e.setTid(timeTxt.getText());
				e.setHoldid(hjemmehold.getId());
				e.setKampid(matchData.getId());

				insertTime(timeTxt);

				refreshTable(rowDataMatch);
			}
		});

		Button goalHome = new Button("Goal");
		hjemmeholdGrid.add(goalHome, 0, 4);
		goalHome.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				e.setEvent("Goal");
				e.setTid(timeTxt.getText());
				e.setHoldid(hjemmehold.getId());
				e.setKampid(matchData.getId());

				insertTime(timeTxt);

				refreshTable(rowDataMatch);
			}
		});

		// Buttons til udeholdGrid
		Label udeHold = new Label("udehold: " + udehold.getHoldnavn());
		udeholdGrid.add(udeHold, 0, 0);

		Button PenaltyOut = new Button("Penalty");
		udeholdGrid.add(PenaltyOut, 0, 1);
		PenaltyOut.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				e.setEvent("Penalty");
				e.setTid(timeTxt.getText());
				e.setHoldid(udehold.getId());
				e.setKampid(matchData.getId());

				insertTime(timeTxt);

				refreshTable(rowDataMatch);
			}
		});

		Button redCardOut = new Button("Red card");
		udeholdGrid.add(redCardOut, 0, 2);
		redCardOut.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				e.setEvent("Red card");
				e.setTid(timeTxt.getText());
				e.setHoldid(udehold.getId());
				e.setKampid(matchData.getId());

				insertTime(timeTxt);

				refreshTable(rowDataMatch);
			}
		});

		Button yellowCardOut = new Button("Yellow card");
		udeholdGrid.add(yellowCardOut, 0, 3);
		yellowCardOut.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				e.setEvent("Yellow card");
				e.setTid(timeTxt.getText());
				e.setHoldid(udehold.getId());
				e.setKampid(matchData.getId());

				insertTime(timeTxt);

				refreshTable(rowDataMatch);
			}
		});

		Button goalOut = new Button("Goal");
		udeholdGrid.add(goalOut, 0, 4);
		goalOut.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				e.setEvent("Goal");
				e.setTid(timeTxt.getText());
				e.setHoldid(udehold.getId());
				e.setKampid(matchData.getId());

				insertTime(timeTxt);

				refreshTable(rowDataMatch);
			}
		});

		// Return to ViewMatches
		Button tilbage = new Button("Return");
		grid.add(tilbage, 1, 2);
		tilbage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ViewMatches view = new ViewMatches(stage);
				view.init();
			}
		});

		//HBox for tableview
		HBox tableviewNreturn = new HBox();
		tableviewNreturn.getChildren().addAll(table);
		tableviewNreturn.setSpacing(10);
		tableviewNreturn.setAlignment(Pos.CENTER);
		grid.add(tableviewNreturn, 1, 1);
		
//		HBox hViewMatch = new HBox();
//		hViewMatch.getChildren().addAll(stackHomeTeam, stackAwayTeam);
//		hViewMatch.setSpacing(10);
//		grid.add(hViewMatch, 1, 0);
		
		grid.add(stackH, 0, 0);
		grid.add(stackU, 2, 0);

		Scene editmatchinfo = new Scene(grid, 1280, 740);
		stage.setScene(editmatchinfo);
		stage.sizeToScene();
		editmatchinfo.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		
		stage.show();
	}

	public Duration getTime() {
		return time;
	}

	public void setTime(Duration time) {
		this.time = time;
	}

	public void refreshTable(Match rowDataMatch) {
		eventList.clear();

		Event event = new Event();
		event.setKampid(rowDataMatch.getId());

		eventList = KRPLogic.getEvent(event);
		data = FXCollections.observableArrayList(eventList);
		table.setItems(data);
	}

	public void insertTime(TextField timeTxt) {
		if (timeTxt.getText().equals("")) {
			timeTxt.setPromptText("*Insert time or press update");
		} else {
			logic.createEvent(e);
		}
	}
}
