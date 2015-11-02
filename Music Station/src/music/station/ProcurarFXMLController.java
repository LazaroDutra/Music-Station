/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.station;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Lazaro
 */
public class ProcurarFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ComboBox por;
    @FXML 
    private Button pesquisar;
    @FXML
    private TextField pMusica;
    @FXML 
    private TableView <Musica> tabela;
    @FXML
    private TableColumn colunMusica;
    @FXML
    private TableColumn colunAlbum;
    @FXML
    private TableColumn colunArtista;
    @FXML
    private TableColumn colunGenero;
    @FXML
    private TableColumn colunClas;
    contest conn = new contest();
     private ObservableList liGenero;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        liGenero = FXCollections.observableArrayList();
        liGenero.add("Artista");
        liGenero.add("Álbum");
        liGenero.add("Música");
        liGenero.add("Gênero");
        por.setItems(liGenero);
    }
    
    private ObservableList<Musica> liMusica;
    @FXML
    public void adt(){
        liMusica = FXCollections.observableArrayList();
       assert tabela != null :"fx:id=\"tableview\" was not injected: check your FXML file 'UserMaster.fxml'.";
       
       String opc = por.getValue().toString();
       System.out.println(opc+"");
       
       try {
            Statement st = conn.conectar1().createStatement();
            if(opc == "Música"){
            ResultSet rs = st.executeQuery("SELECT * FROM `Musica` WHERE NomeMusica = '"+pMusica.getText()+"';");
           while(rs.next()){
               
               Musica m = new Musica("1","2","3","4",5);
                m.setMusica(rs.getString("NomeMusica"));
                m.setAlbum(rs.getString("NomeAlbum"));
                m.setArtista(rs.getString("NomeArtista"));
                m.setGenero(rs.getString("Genero"));
                m.setClas(rs.getInt("Class"));
                
                
                System.out.println(rs.getString("NomeMusica"));
                System.out.println(rs.getString("NomeAlbum"));
                System.out.println(rs.getString("NomeArtista"));
                System.out.println(rs.getString("Genero"));
                System.out.println(rs.getString("Class"));   
                liMusica.add(m); 
            }}
            if(opc == "Álbum"){
            ResultSet rs = st.executeQuery("SELECT * FROM `Musica` WHERE NomeAlbum = '"+pMusica.getText()+"';");
           while(rs.next()){
               
               Musica m = new Musica("1","2","3","4",5);
                m.setMusica(rs.getString("NomeMusica"));
                m.setAlbum(rs.getString("NomeAlbum"));
                m.setArtista(rs.getString("NomeArtista"));
                m.setGenero(rs.getString("Genero"));
                m.setClas(rs.getInt("Class"));
                
                
                System.out.println(rs.getString("NomeMusica"));
                System.out.println(rs.getString("NomeAlbum"));
                System.out.println(rs.getString("NomeArtista"));
                System.out.println(rs.getString("Genero"));
                System.out.println(rs.getString("Class"));   
                liMusica.add(m); 
            }}
            if(opc == "Artista"){
            ResultSet rs = st.executeQuery("SELECT * FROM `Musica` WHERE NomeArtista = '"+pMusica.getText()+"';");
           while(rs.next()){
               
               Musica m = new Musica("1","2","3","4",5);
                m.setMusica(rs.getString("NomeMusica"));
                m.setAlbum(rs.getString("NomeAlbum"));
                m.setArtista(rs.getString("NomeArtista"));
                m.setGenero(rs.getString("Genero"));
                m.setClas(rs.getInt("Class"));
                
                
                System.out.println(rs.getString("NomeMusica"));
                System.out.println(rs.getString("NomeAlbum"));
                System.out.println(rs.getString("NomeArtista"));
                System.out.println(rs.getString("Genero"));
                System.out.println(rs.getString("Class"));   
                liMusica.add(m); 
            }}
            if(opc == "Genero"){
            ResultSet rs = st.executeQuery("SELECT * FROM `Musica` WHERE Genero = '"+pMusica.getText()+"';");
           while(rs.next()){
               
               Musica m = new Musica("1","2","3","4",5);
                m.setMusica(rs.getString("NomeMusica"));
                m.setAlbum(rs.getString("NomeAlbum"));
                m.setArtista(rs.getString("NomeArtista"));
                m.setGenero(rs.getString("Genero"));
                m.setClas(rs.getInt("Class"));
                
                
                System.out.println(rs.getString("NomeMusica"));
                System.out.println(rs.getString("NomeAlbum"));
                System.out.println(rs.getString("NomeArtista"));
                System.out.println(rs.getString("Genero"));
                System.out.println(rs.getString("Class"));   
                liMusica.add(m); 
            }}
            colunMusica.setCellValueFactory( new PropertyValueFactory("musica"));
            colunAlbum.setCellValueFactory( new PropertyValueFactory("album"));
            colunArtista.setCellValueFactory( new PropertyValueFactory("artista"));
            colunGenero.setCellValueFactory( new PropertyValueFactory("genero"));
            colunClas.setCellValueFactory( new PropertyValueFactory("clas"));
            tabela.setItems(null);
            tabela.setItems(liMusica);

            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
