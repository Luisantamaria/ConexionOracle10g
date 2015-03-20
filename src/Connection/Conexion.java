/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Luis alberto
 */
public class Conexion {
        
    public static Connection Conexion(){
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "prueba", "luis4949");
        } catch (Exception e) {
            e.printStackTrace();
        }        
        
        return conn;
    }
    
}
