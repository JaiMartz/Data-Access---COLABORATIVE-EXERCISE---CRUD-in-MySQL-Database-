/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_tc_2019;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dmm_s
 */
public class consultarAsignaturasCurso {
    public static void main(String[] args) throws ClassNotFoundException, SQLException { 
        
    /**
     * 	El miembro B de la pareja deberá crear una clase "consultarAsignaturaCurso.java" 
     * cuyo cometido será mostrar el nombre de cada asignatura y el nombre del cuso al que están asignadas.
     */
     //Paso 2: Cargar el driver
        Class.forName("com.mysql.jdbc.Driver");
        
        //Paso 3: Establer conexion con la BD: URL, Usuario, Pass
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/instituto","root","");
        
        //Paso 4: Preparar la sentencia.
        Statement sentencia = conexion.createStatement();
        
        //Paso 5: Lanzar sentencia.
        ResultSet resultado = sentencia.executeQuery("SELECT nombre_asignatura, descripción, nombre_ciclo FROM Asignaturas "
                + "INNER JOIN Cursos ON Asignaturas.codigo_curso = Cursos.codigo_curso");
        
        //Paso 6: recorremos la coleccion para visualizar cada fila
        //Hacemos un bucle mientras que haya registros
        while(resultado.next()){
            System.out.print("Siglas " + resultado.getString(1) + " -> ");
            System.out.print("Asignatura: " + resultado.getString(2) +" -> ");
            System.out.println("Curso:" + resultado.getString(3) +"\t\t");
            System.out.println("");
        }
        //Paso 7: Liberar los recursos
        resultado.close();
        sentencia.close();
        conexion.close(); 
        
    }
    }
