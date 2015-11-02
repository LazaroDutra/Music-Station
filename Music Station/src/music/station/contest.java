/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.station;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Lazaro
 */
public class contest {
    String driver = "com.mysql.jdbc.Driver";
    String banco = "mydb";
    String host = "localhost";
    String str_conn= "jdbc:mysql://localhost/mydb";
    String usuario = "root";
    String senha = "";
    Collection colecao = new ArrayList();
    
    public Connection conectar1() {
    
    try{ 
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(str_conn,usuario,senha);
        Statement stmt = conn.createStatement();
        
        
        return conn;
    
    }
    
    catch(ClassNotFoundException ex){
        System.out.println("Não foi possível carregar o driver.");
    }
    catch(SQLException ex){
        System.out.println("Problema com o SQL");
    }
        return null;
    }
}
