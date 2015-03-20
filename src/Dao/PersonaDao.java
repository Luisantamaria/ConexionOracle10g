/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Persona;
import java.util.List;

/**
 *
 * @author Luis alberto
 */
public interface PersonaDao {
    
    public boolean Insertar(Persona persona);
    public List<Persona> listar();
    public boolean Eliminar(int id);
    public boolean Actualizar(Persona persona);
    public Persona ObtenerId(int id);
}
