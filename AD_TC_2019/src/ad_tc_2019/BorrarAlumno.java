/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_tc_2019;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jairo
 */
public class BorrarAlumno {
    public static void main(String[] args) throws ClassNotFoundException, SQLException { 
        //Load drivers
        //Cargamos el driver
        Class.forName("com.mysql.jdbc.Driver");
        //Get connection with database
        //Conexion con la base de datos
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/instituto","foc","f0m3nt0");
        //Prepare statement
        //Preparar la sentencia
        Statement sentencia = conexion.createStatement();
        //Launch statement
        //Lanzar la sentencia
        String op = "DELETE FROM a, t USING Alumnos AS a INNER JOIN Tienen AS t WHERE a.dni=t.dni AND a.dni='47298315D'";
        int filas = sentencia.executeUpdate(op);//filas borradas
        //Check how many rows has been deleted
        //Comprobar cuantas filas se han borrado
        System.out.println("Mediante la sentencia de eliminacion "+op+" se han borrado "+filas+" filas");
        //Free resources
        //Liberar los recursos
        sentencia.close();
        conexion.close();
    }
}
