/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.List;
import manejojdbc.datos.PersonaDAO;
import manejojdbc.domain.Persona;

/**
 *
 * @author SUA
 */
public class testManejoPersonas {

    //Consultar a la base de datos
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();

//        //Insertando un nuevo registro a la base de datos
//        Persona personaNueva = new Persona("Cros", "Esparza", "cezparaza@gmail.com", "3008602183");
//        personaDao.insertar(personaNueva);

        //Modificar un registro existente UPDATE
        Persona personaActualizada = new Persona(3,"Valentina", "Salamanca", "vale@gmail.com", "31485325");
        personaDao.actualizar(personaActualizada);
        
        //Listado de personas
        

        List<Persona> personas = personaDao.seleccionar(); //Se crea una lista de tipo Persona y se le asigna el valor resultante de la funcion seleccionar
        for (Persona persona : personas) { //Se itera la lista 
            System.out.println("persona = " + persona); //Se muestran los resultados
        }
    }

}
