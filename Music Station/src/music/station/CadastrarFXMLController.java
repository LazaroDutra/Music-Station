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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.StageStyle;

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
   private ComboBox clas;
   

    
    private ObservableList listaClass;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listaClass = FXCollections.observableArrayList();
        listaClass.add(10);
        listaClass.add(9);
        listaClass.add(8);
        listaClass.add(7);
        listaClass.add(6);
        listaClass.add(5);
        listaClass.add(4);
        listaClass.add(3);
        listaClass.add(2);
        listaClass.add(1);
        listaClass.add(0);
        clas.setItems(listaClass);
        
        
    } 
    
   

    
    
    @FXML
    private void cadMusica (ActionEvent event) throws Exception{
         try {
            Musica m = new Musica("1","2","3","4",0);
            String nm = nMusica.getText();
            String nal = nAlbum.getText();
            String nar = nArtista.getText();
            String ng = nGenero.getText();
            int classi = Integer.parseInt(clas.getValue().toString());
       
            m.setMusica(nm);
            m.setAlbum(nal);
            m.setArtista(nar);
            m.setGenero(ng);
            m.setClas(classi); 
            m.imprime(m);
            m.adM(m);
            enm(m);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CadOKFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
            nMusica.setText(null);
            nAlbum.setText(null);
            nArtista.setText(null);
            nGenero.setText(null);
            clas.setValue(null);
        } catch(Exception e) {System.out.println("Problemas!"+e); }
    }
    
    private static int enm(Musica m) throws SQLException{
        
        contest co = new contest();
            Statement insert = co.conectar1().createStatement();
            String in = "INSERT INTO musica VALUES (NULL,'"+m.getMusica()+"','"+m.getAlbum()+"','"+m.getArtista()+"','"+m.getGenero()+"','"+m.getClas()+"');";
            
            return(insert.executeUpdate(in));
    }
    
}
