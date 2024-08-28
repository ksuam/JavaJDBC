/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaccionjdbc.datos;

import manejojdbc.datos.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import manejojdbc.domain.Persona;

/**
 *
 * @author SUA
 */
public class PersonaDaoTransaccion {
    private Connection conexionTransaccional; //Creamos una variable de tipo conexion para recibir una transaccion de afuera
    private static final String SQL_SELECT = "SELECT*FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
    
    //Constructor vacio
    public PersonaDaoTransaccion(){
        
    }
    
    //Constructo para recibir la variable de conexion
    public PersonaDaoTransaccion(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }
    public List<Persona> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Persona> personas = new ArrayList<>();
        Persona persona = null;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConection(); // Si la variable de conexionTransaccional es diferente de ulo, usela, de lo contrario, obenga la conexion de manera mas organica
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
                
                Conexion.close(rs); //Se cierra el resultado
                Conexion.close(stmt); //Se cierra statement
                
                if(this.conexionTransaccional == null)
                {
                    Conexion.close(conn); //Se cierra la conexion
                }

            } catch (SQLException ex) {
                Logger.getLogger(PersonaDaoTransaccion.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return personas;
    }

    public int insertar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConection(); // Si la variable de conexionTransaccional es diferente de ulo, usela, de lo contrario, obenga la conexion de manera mas organica
            stmt = conn.prepareStatement(SQL_INSERT); // prepara el query con el insert de arriba
            stmt.setString(1, persona.getNombre()); //obtiene el nombre del objeto que se le paso y lo setea en la variable 1 arriba en el insert
            stmt.setString(2, persona.getApellido());//obtiene el apellido del objeto que se le paso y lo setea en la variable 1 arriba en el insert
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            registros = stmt.executeUpdate(); //Este metodo puede ejecutar sentencias como update, delete e insert
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                if(this.conexionTransaccional == null)
                {
                    Conexion.close(conn); //Se cierra la conexion
                }
            } catch (SQLException ex) {

            }
            try {
                Conexion.close(stmt); //Se cierra el query
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public int actualizar(Persona persona) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConection(); // Si la variable de conexionTransaccional es diferente de ulo, usela, de lo contrario, obenga la conexion de manera mas organica
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, persona.getNombre()); //obtiene el nombre del objeto que se le paso y lo setea en la variable 1 arriba en el insert
            stmt.setString(2, persona.getApellido());//obtiene el apellido del objeto que se le paso y lo setea en la variable 1 arriba en el insert
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                if(this.conexionTransaccional == null)
                {
                    Conexion.close(conn); //Se cierra la conexion
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
