/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaccionjdbc.datos;

import manejojdbc.datos.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author SUA
 */
public class ConexionTransaccion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Tamaguchi13";
    
    //Funcion para conectarse a la base de datos
    public static Connection getConection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    //Para cerrar la consulta
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    //Cerrar la puerta de creacion
    public static void close(Statement stm) throws SQLException{
        stm.close();
    }
    
    public static void close(PreparedStatement stmn) throws SQLException{
        stmn.close();
    }
    
    //Cerrar la conexion
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
    
    
    

}
