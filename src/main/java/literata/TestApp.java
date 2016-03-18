package literata;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TestApp extends Application {
  IndexReader myIndexReader;
  ObjectReader myObjectReader;
  
	@Override
	public void start(Stage stage) throws Exception {
	      myIndexReader = new IndexReader();
	
	      myObjectReader = new ObjectReader();
	            
        System.out.println("TestApp.start()");
        Parent root = FXMLLoader.load(getClass().getResource("TestApp.fxml"));
        
        stage.getIcons().add(new Image(getClass().getResourceAsStream("pgmicon.png")));
        
        stage.setTitle("Git Analysis Tool v1.00");
        
        Scene scene = new Scene(root);
        
        scene.getStylesheets().add(getClass().getResource("modena.css").toExternalForm());
        stage.setScene(scene);
        stage.show();	
    }
	
	/**
	 * The entry point for the TestApp class
	 */
    public static void main(String[] args) {
        System.out.println("TestApp.main()");
        launch(args);
    }
}

