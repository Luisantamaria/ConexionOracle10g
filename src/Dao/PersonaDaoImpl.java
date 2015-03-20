/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.Conexion;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<Persona> listar() {        
        Statement st;
        ResultSet rs;
        String sql = "SELECT * FROM persona";
        List<Persona> list = new ArrayList<Persona>();
        Persona persona;
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {                
                persona = new Persona();
                persona.setPersonaid(rs.getInt("personaid"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido_pat(rs.getString("apellido_pat"));
                persona.setApellido_mat(rs.getString("apellido_mat"));
                persona.setDni(rs.getInt("dni"));
                list.add(persona);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean Eliminar(int id) {
        Statement st;
        String sql="DELETE FROM persona WHERE personaid = "+id;
        boolean eliminar = false;
        
        try {
            st = conn.createStatement();
            st.executeQuery(sql);
            conn.commit();
            conn.close();
            eliminar = true;
        } catch (Exception e) {
            try {
                conn.rollback();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            eliminar = false;
        }
        return eliminar;
    }

    @Override
    public boolean Actualizar(Persona persona) {
        boolean actualizar = false;
        String sql = "UPDATE persona SET nombre = '"+persona.getNombre()+"', apellido_pat='"+persona.getApellido_pat()+
                     "', apellido_mat='"+persona.getApellido_mat()+"', dni="+persona.getDni()+" WHERE personaid = "+persona.getPersonaid();
        Statement st;
        
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
            actualizar = true;
        } catch (Exception e) {
            try {
                conn.rollback();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            actualizar = false;
        }
        return actualizar;
    }

    @Override
    public Persona ObtenerId(int id) {
        Persona persona = new Persona();
        Statement st;
        ResultSet rs;
        String sql = "SELECT * FROM persona WHERE personaid = "+id;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            conn.close();
            while (rs.next()) { 
                persona.setPersonaid(rs.getInt("personaid"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido_pat(rs.getString("apellido_pat"));
                persona.setApellido_mat(rs.getString("apellido_mat"));
                persona.setDni(rs.getInt("dni"));
            }
        } catch (Exception e) {
            try {
                e.printStackTrace();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return persona;
    }

   
}
