/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.Conexion;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis alberto
 */
public class PersonaDaoImpl implements PersonaDao{
    
    private Connection conn = Conexion.Conexion();
    
    @Override
    public boolean Insertar(Persona persona) {
        boolean insert = false;
        String sql = "INSERT INTO persona (personaid, nombre, apellido_mat, apellido_pat, dni) "+"values("+persona.getPersonaid()+",'"+persona.getNombre()+"','"+persona.getApellido_pat()+
                     "','"+persona.getApellido_mat()+"',"+persona.getDni()+")";
        
        
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            conn.commit();
            conn.close();
            insert = true;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
                conn.close();
                insert = false;
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
        
        return insert;
    }
    
}
