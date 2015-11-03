/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.station;



import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Lazaro
 */
public class MusicStation extends Application {
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.fullScreenProperty();
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException{
  

  
        launch(args);

    }
          
}
