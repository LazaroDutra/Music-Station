/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.station;


import static java.awt.Color.*;
import java.net.URL;
import java.sql.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;




/**
 *
 * @author Lazaro
 */
public class FXMLDocumentController implements Initializable {
    

    @FXML
    private AnchorPane pane;
  
   
    @FXML
    private void mnovo (ActionEvent event) throws Exception {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CadastrarFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
                stage.resizableProperty().setValue(Boolean.FALSE);
        } catch(Exception e) {
          }
    }
    @FXML
    private void mprocurar (ActionEvent event) throws Exception{
         try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProcurarFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
                stage.resizableProperty().setValue(Boolean.FALSE);
        } catch(Exception e) {
          }
    
    }
    @FXML
    private void mexcluir(ActionEvent event) throws Exception{
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExcluirFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
                stage.resizableProperty().setValue(Boolean.FALSE);
        } catch(Exception e) {
          }
    }
    @FXML
    private void malterar(ActionEvent event){
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AlterarFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
                stage.resizableProperty().setValue(Boolean.FALSE);
        } catch(Exception e) {
          }
    }
    
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
    @FXML
    private Circle on;

    private ObservableList<Musica> liMusica;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO 
         Connection conn;
         conn =  conn = new contest().conectar1();
         
            if(conn != null){
                System.out.println("Conexão efetuada com sucesso!"); 
                on.setFill(Color.GREEN);
            }else{
                on.setFill(Color.RED);
                System.out.println("Problemas!");
            }
        }  
    @FXML
    public void adt(){
        liMusica = FXCollections.observableArrayList();
       contest conn = new contest();
       assert tabela != null :"fx:id=\"tableview\" was not injected: check your FXML file 'UserMaster.fxml'.";
      
        try {
            Statement st = conn.conectar1().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `Musica`;");
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
            }
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
    
    
    
  
