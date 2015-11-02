/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.station;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lazaro
 */
public class NoDataFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button closeB;
    @FXML
    private void close (ActionEvent event){
    Stage stage = (Stage) closeB.getScene().getWindow();
    stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
