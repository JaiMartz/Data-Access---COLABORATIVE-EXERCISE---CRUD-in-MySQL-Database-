/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_tc_2019;
import java.sql.*;
/**
 *
 * @author Jairo
 */
public class InsertarAlumno {

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
        String op = "INSERT INTO alumnos VALUES('12235265A','Jorge','Torres Almadra','1982-5-07')";
        int filas = sentencia.executeUpdate(op); //Filas insertadas
        //Chekc how many rows has been inserted
        //Comprobamos cuantas filas se han insertado
        System.out.println("Mediante la sentencia de insercion "+op+" se han insertado "+filas+" filas");
        //Free resources and close data flow
        //Liberamos los recursos
        sentencia.close();;
        conexion.close();
    }
    
}
