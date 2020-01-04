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
 * @author dmm_s
 */
public class modificarCurso {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
          //Paso 2: Cargar el driver
        Class.forName("com.mysql.jdbc.Driver");
        
        //Paso 3: Establer conexion con la BD: URL, Usuario, Pass
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/instituto","root","");
        
        //Paso 4: Preparar la sentencia.
        Statement sentencia = conexion.createStatement();
        
        //Paso 5: Lanzar sentencia.
        String modificacion = "UPDATE Asignaturas SET codigo_curso=2 WHERE codigo_asignatura=11";
        
        int filas = sentencia.executeUpdate(modificacion); //filas insertada 
        
        System.out.println("Tras la modificacion " + modificacion + " se han actualizado " + filas + " filas");
        
        //Paso 7: Liberar los recursos
        sentencia.close();
        conexion.close();  
        
    }
}
