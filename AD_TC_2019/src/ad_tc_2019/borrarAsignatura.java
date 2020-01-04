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
public class borrarAsignatura {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /**
         * 	El miembro B de la pareja deberá crear una clase "borrarAsignatura.java"
         * que deberá borrar un curso, asignando las asignaturas que le pertenezcan a otro curso.
         */
         //Paso 2: Cargar el driver
        Class.forName("com.mysql.jdbc.Driver");
        
        //Paso 3: Establer conexion con la BD: URL, Usuario, Pass
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/instituto","root","");
        
        //Paso 4: Preparar la sentencia.
        Statement sentencia = conexion.createStatement();
        
        //Paso 5a: UPDATEAR que las asignaturas cambien a otro curso.
        String update = "UPDATE Asignaturas SET codigo_curso=1 WHERE codigo_curso=5";
        
        //Paso 5b: Lanzar sentencia borrado
        String delete = "DELETE FROM Cursos WHERE codigo_curso=5";
        //String borrado = "DELETE Cursos ";
        
        int filas = sentencia.executeUpdate(update); //filas insertada 
        
        int filasB = sentencia.executeUpdate(delete);
        
        System.out.println("Tras la actualización " + update + " se han modificado " + filas + " asignaturas. \n"
                + "Dejando así el curso vacio de asignaturas");
        
        System.out.println("Tras el borrado " + delete + " \n se han borrado " + filasB + " cursos ");
        
        //Paso 7: Liberar los recursos
        sentencia.close();
        conexion.close();  
    }
}
