/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.station;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void PalterarM() throws SQLException{
        contest conn = new contest();
        try {
        Statement st = conn.conectar1().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM `Musica` WHERE NomeMusica = '"+nPmusica.getText()+"';");
        while(rs.next()){
            nMusica.setText(rs.getString("NomeMusica"));
            nAlbum.setText(rs.getString("NomeAlbum"));
            nArtista.setText(rs.getString("NomeArtista"));
            nGenero.setText(rs.getString("Genero"));
            nClas.setText(rs.getString("Class"));
            
        }
        if(rs.first() == false){
            System.err.println("Erro encontrado !!! ");
        }
        }catch (SQLException e){
            System.err.println("Erro encontrado !!! ");
            System.err.println(e.getMessage());
        }
    }
     @FXML
        private void alterarM() throws SQLException{
        contest conn = new contest();
        try {
        PreparedStatement st = conn.conectar1().prepareStatement("UPDATE Musica SET NomeMusica = '"+nMusica.getText()+"', NomeAlbum = '"+nAlbum.getText()+"', NomeArtista = '"+nArtista.getText()+"', Genero = '"+nGenero.getText()+"', Class = '"+nClas.getText()+"' WHERE NomeMusica = '"+nPmusica.getText()+"';");
        st.executeUpdate();
        }catch (SQLException e){
            System.err.println("Erro encontrado !!! ");
            System.err.println(e.getMessage());
        }
    }
}

