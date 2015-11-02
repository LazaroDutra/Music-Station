/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.station;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author Lazaro
 */
public class ExcluirFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button excluir;
    @FXML
    private Button ok;
    @FXML
    private TextField nMusica;
    @FXML
    private Label conf;
    @FXML
    private void exMusica (ActionEvent event) throws Exception{  
        try{
        contest co = new contest();
        String nM = nMusica.getText();
        PreparedStatement st = co.conectar1().prepareStatement("DELETE FROM musica WHERE NomeMusica = '" + nM + "';");
        st.executeUpdate();
        conf.setVisible(true);
        ok.setVisible(true);
        }
        catch(Exception e){
            System.err.println("Erro encontrado !!! ");
            System.err.println(e.getMessage());
        }
    }
    @FXML
    private void ok (ActionEvent event) throws IOException{
        nMusica.setText(null);
        conf.setVisible(false);
        ok.setVisible(false);
        Stage stage = (Stage) ok.getScene().getWindow();
        stage.close();

        
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
