/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author aprendiztic1
 */
public class TestMySqlJDBC {
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=UTC&allowPublicKeyRetrieval=true"; //Cadena de conexion para conectarse a mysql 8
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conexion = DriverManager.getConnection(url, "root", "Tamaguchi13"); // Conexion a la base de datos
            Statement instruccion = conexion.createStatement(); // se crea para poder ejecutar en la base de datos
            var sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona"; //query a ejecutar
            
            ResultSet resultado = instruccion.executeQuery(sql); // Se usa Resultset, se crea una variable de esa interface, y con la variable instruccion se ejecuta el query
            
            while (resultado.next()) {                
                System.out.println("id_persona = "+ resultado.getInt("id_persona")); // mostrar los datos en consola, usando la variable de resultado y el metodogetInt, al cual se le pasa la columna de la cual se quiere extrer la informacion
            }
            resultado.close(); // se cierra el objeto
            instruccion.close(); // se cierra el objeto
            conexion.close(); // se cierra el objeto
        } catch (SQLException ex) {
            Logger.getLogger(TestMySqlJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
