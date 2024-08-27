/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejojdbc.datos;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import manejojdbc.domain.Persona;

/**
 *
 * @author SUA
 */
public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT*FROM persona";

    public List<Persona> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Persona> personas = new ArrayList<>();
        Persona persona = null;

        try {
            conn = Conexion.getConection(); //se realiza  la conexion llamando al metodo de la clase conexion
            stmt = conn.prepareStatement(SQL_SELECT); // Se prepara el query
            rs = stmt.executeQuery(); //Se ejecuta el query

            while (rs.next()) {
                int idPersona = rs.getInt("id_persona"); //Se recuperan los datos 
                String nombre = rs.getString("nombre");//Se recuperan los datos
                String apellido = rs.getString("apellido"); //Se recuperan los datos
                String email = rs.getString("email"); //Se recuperan los datos
                String telefono = rs.getString("telefono"); //Se recuperan los datos

                persona = new Persona(idPersona, nombre, apellido, email, telefono); // se crea el bjeto con los atribtos requeridos
                personas.add(persona); // Se agrega el objeto a la lista de personas
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(conn); //Se cierra la conexion
                Conexion.close(rs); //Se cierra el resultado
                Conexion.close(stmt); //Se cierra statement

            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return personas;
    }
}
