package tempControl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainTemp extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlTemp.fxml"));
		AnchorPane grid = loader.load();
		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
		public static void main(String[] args) {
			Application.launch();
		}

}