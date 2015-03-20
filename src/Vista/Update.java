/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Dao.PersonaDao;
import Dao.PersonaDaoImpl;
import Modelo.Persona;

/**
 *
 * @author Luis alberto
 */
public class Update {
    
    public static void main(String[] args) {
        
        Persona persona = new Persona();
        persona.setPersonaid(1);
        persona.setNombre("Jose".toUpperCase());
        persona.setApellido_pat("santa maria".toUpperCase());
        persona.setApellido_mat("ticlavilca".toUpperCase());
        persona.setDni(12345678);
        
        PersonaDao personaDao = new PersonaDaoImpl();
        
        if (personaDao.Actualizar(persona)) {
            System.out.println("Se actualizo correctamente.");
        } else {
            System.out.println("Ocurrio un problema al intentar actualizar.");
        }
        
    }
    
}
