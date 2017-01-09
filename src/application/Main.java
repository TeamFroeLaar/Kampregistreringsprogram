package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage stage) 
	{

			GridPane grid = new GridPane();
			grid.setAlignment(Pos.TOP_CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

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