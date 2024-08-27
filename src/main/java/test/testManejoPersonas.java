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
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        List<Persona> personas =  personaDao.seleccionar();
        for (Persona persona: personas) {
            System.out.println("persona = " + persona);
        }
    }
}
