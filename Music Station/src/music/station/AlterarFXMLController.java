/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.station;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.*;

/**
 * FXML Controller class
 *
 * @author Lazaro
 */
public class AlterarFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button pesq;
    @FXML
    private Button alte;
    @FXML
    private TextField nPmusica;
    @FXML
    private TextField nMusica;
    @FXML
    private TextField nAlbum;
    @FXML
    private TextField nArtista;
    @FXML
    private TextField nGenero;
    @FXML
    private TextField nClas;
    @FXML
    private ComboBox clas;
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
    private ObservableList listaClass;

    @FXML
    private void PalterarM() throws SQLException, IOException{
        contest conn = new contest();
        try {
        Statement st = conn.conectar1().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM `Musica` WHERE NomeMusica = '"+nPmusica.getText()+"';");
        while(rs.next()){
            nMusica.setText(rs.getString("NomeMusica"));
            nAlbum.setText(rs.getString("NomeAlbum"));
            nArtista.setText(rs.getString("NomeArtista"));
            nGenero.setText(rs.getString("Genero"));
            clas.setValue(rs.getString("Class"));
            
        }
        if(rs.first() == false){
            System.err.println("Erro encontrado !!! ");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NoDataFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
               
        }
        }catch (SQLException e){
            System.err.println("Erro encontrado !!! ");
            System.err.println(e.getMessage());
        }
    }
     @FXML
        private void alterarM() throws SQLException, IOException{
        contest conn = new contest();
        try {
        PreparedStatement st = conn.conectar1().prepareStatement("UPDATE Musica SET NomeMusica = '"+nMusica.getText()+"', NomeAlbum = '"+nAlbum.getText()+"', NomeArtista = '"+nArtista.getText()+"', Genero = '"+nGenero.getText()+"', Class = '"+clas.getValue().toString()+"' WHERE NomeMusica = '"+nPmusica.getText()+"';");
        st.executeUpdate();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("altOKFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
        nPmusica.setText(null);
        nMusica.setText(null);
        nAlbum.setText(null);
        nArtista.setText(null);
        nGenero.setText(null);
        clas.setValue(null);
        }catch (SQLException e){
            System.err.println("Erro encontrado !!! ");
            System.err.println(e.getMessage());
        }
    }
}

