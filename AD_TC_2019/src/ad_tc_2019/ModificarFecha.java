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
public class ModificarFecha {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Load driver
        //Cargamos el driver
        Class.forName("com.mysql.jdbc.Driver");
        //Get connection with database
        //Conexion con la base de datos
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/instituto","foc","f0m3nt0");
        //Prepare statement
        //Preparar sentencia
        Statement sentencia = conexion.createStatement();
        //Launch statement
        //Lanzar sentencia
        String op = "UPDATE alumnos SET fecha_nac='1990-01-01' WHERE dni='76652856C'";
        int filas = sentencia.executeUpdate(op); //filas actualizadas
        //Check how many rows has been updated
        //Comprobar cuantas filas se han modificado
        System.out.println("Mediante la sentencia de actualizacion "+op+" se han modificado "+filas+" filas");
        
        //Liberar recursos
        sentencia.close();
        conexion.close();
    }
}
