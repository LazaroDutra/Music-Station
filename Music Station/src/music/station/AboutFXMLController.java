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
public class AboutFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button closeButton;
     @FXML
    private void clos (ActionEvent event) throws Exception{
                Stage stage = (Stage) closeButton.getScene().getWindow();
                stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
