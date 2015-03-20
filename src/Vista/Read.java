/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Dao.PersonaDao;
import Dao.PersonaDaoImpl;
import Modelo.Persona;
import java.util.List;

/**
 *
 * @author Luis alberto
 */
public class Read {
    
    public static void main(String[] args) {
        PersonaDao personaDao = new PersonaDaoImpl();
        List<Persona> listar = personaDao.listar();
                
        for (Persona persona : listar) {
            System.err.println("ID: "+persona.getPersonaid()+" | Nombre: "+persona.getNombre()+ 
                    " | Apelldio Paterno: "+persona.getApellido_pat()+" | Apellido materno: "+persona.getApellido_mat()+" | DNI: "+ persona.getDni());
        }
    }
    
}
