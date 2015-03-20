/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Connection.Conexion;
import Dao.PersonaDao;
import Dao.PersonaDaoImpl;
import Modelo.Persona;

/**
 *
 * @author Luis alberto
 */
public class Create {
    
    public static void main(String[] args) {
           
        if (Conexion.Conexion() != null) {
            System.out.println("Conexion Exitosa!!");
        } else {
            System.out.println("Error en la conexion!!");
        }
        
        //Representaria a un Formulario de Ingreso de Datos
        Persona persona = new Persona();
        persona.setPersonaid(2);
        persona.setNombre("Maria yolita".toUpperCase());
        persona.setApellido_pat("guerrero".toUpperCase());
        persona.setApellido_mat("gonzales".toUpperCase());
        persona.setDni(45448683);
        //***********************************
               
        //Ejecutando la funcion Intert
        PersonaDao personaDao = new PersonaDaoImpl();
        if (personaDao.Insertar(persona)) {
            System.out.println("Se inserto satisfactoriamente los Datos.");
        } else {
            System.out.println("Ocurrio un error al Insertar los Datos");
        }
        
    }
    
}
