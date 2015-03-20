/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Dao.PersonaDao;
import Dao.PersonaDaoImpl;

/**
 *
 * @author Luis alberto
 */
public class Delete {
 
    public static void main(String[] args) {
        
        PersonaDao personaDao = new PersonaDaoImpl();
        
        if (personaDao.Eliminar(2)) {
            System.out.println("La persona fue eliminada.");
        } else {
            System.out.println("Ocurrio un error al Eliminar la persona.");
        }
        
    }
    
}
