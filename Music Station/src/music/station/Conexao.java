/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.station;

/**
 *
 * @author Lazaro
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao{
  public Connection conectar() {
    // base de dados é "test"
    String url = "jdbc:mysql://localhost/mydb";
    String usuario = "root";
    String senha = "";

    try{
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection conn = DriverManager.getConnection(url, usuario,senha);
      return conn;
    } 
    catch(SQLException ex){
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
      return null;
    }
    catch(ClassNotFoundException | InstantiationException | IllegalAccessException e){
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null; 
    }
  }
}
