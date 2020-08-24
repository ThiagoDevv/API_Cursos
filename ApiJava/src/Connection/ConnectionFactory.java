/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiag
 */
public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/cursos";
    private static final String USER = "root;";
    private static final String PASS = "q1w2e3r4";
    
    public static Connection GetConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
           throw new RuntimeException("Erro ao tentar conectar: ", ex);
        }
    }
    
    public static void closeConnection (Connection conecxao){
        try {
            if(conecxao != null){
            
                conecxao.close();
            }
            
        } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    public static void closeConnection (Connection conecxao, PreparedStatement stmt){
        closeConnection(conecxao);
        try {
            
            if(stmt != null){
                stmt.close();
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public static void closeConnection (Connection conecxao, PreparedStatement stmt, ResultSet rs){
            closeConnection(conecxao, stmt);
        
        try {
            if(rs != null){
                rs.close();
            }
            
            
        }catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


