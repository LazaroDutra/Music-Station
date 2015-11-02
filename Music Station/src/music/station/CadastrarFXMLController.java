/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.station;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.*;

/**
 * FXML Controller class
 *
 * @author Lazaro
 */
public class CadastrarFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     */
    
    @FXML
    private TextField nMusica;
    @FXML
    private TextField nAlbum;
    @FXML
    private TextField nArtista;
    @FXML
    private TextField nGenero;
   @FXML
    private TextField classif;
   @FXML
    private Button closeButton;
   @FXML
   private Platform ok;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private void clos (ActionEvent event) throws Exception{
                Stage stage = (Stage) closeButton.getScene().getWindow();
                stage.close();
    }

    
    
    @FXML
    private void cadMusica (ActionEvent event) throws Exception{
         try {
            Musica m = new Musica("1","2","3","4",0);
            String nm = nMusica.getText();
            String nal = nAlbum.getText();
            String nar = nArtista.getText();
            String ng = nGenero.getText();
            int classi = Integer.parseInt(classif.getText());
       
            m.setMusica(nm);
            m.setAlbum(nal);
            m.setArtista(nar);
            m.setGenero(ng);
            m.setClas(classi); 
            m.imprime(m);
            m.adM(m);
            enm(m);
            nMusica.setText(null);
            nAlbum.setText(null);
            nArtista.setText(null);
            nGenero.setText(null);
            classif.setText(null);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OkCadastrarFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
                stage.resizableProperty().setValue(Boolean.FALSE);
            
                
            
        } catch(Exception e) {System.out.println("Problemas!"+e); }
    }
    
    private static int enm(Musica m) throws SQLException{
        
        contest co = new contest();
            Statement insert = co.conectar1().createStatement();
            String in = "INSERT INTO musica VALUES (NULL,'"+m.getMusica()+"','"+m.getAlbum()+"','"+m.getArtista()+"','"+m.getGenero()+"','"+m.getClas()+"');";
            
            return(insert.executeUpdate(in));
    }
    
}
