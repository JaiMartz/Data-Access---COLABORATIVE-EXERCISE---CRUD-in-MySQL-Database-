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
 * @author Jairo
 */
public class ConsultarAsignaturaAlumno {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Load driver
        //Cargamos el driver
        Class.forName("com.mysql.jdbc.Driver");
        //Get connection with database
        //Conexion con la base de datos
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/instituto","foc","f0m3nt0");
        //Prepare statement
        //Preparar la sentencia
        Statement sentencia = conexion.createStatement();
        //Launch query
        //Lanzar la consulta
        ResultSet resultado = sentencia.executeQuery
        ("SELECT A.nombre_alumno, A.dni, A.fecha_nac, T.codigo_asignatura, S.nombre_asignatura "
                +"FROM alumnos A JOIN tienen T ON  A.dni = T.dni JOIN asignaturas S ON T.codigo_asignatura=S.codigo_asignatura");
        //Show all the information inside the colletion printing every row
        //Recorremos la coleccion para visualizar cada fila
        //Usamos un bucle mientras haya registros
        
        while(resultado.next()){
            System.out.println("Nombre: "+resultado.getString(1)+ "\t\tDNI: "
            +resultado.getString(2)+"\t\tFecha nacimiento: "
            +resultado.getDate(3)+"\t\tCodigo asignatura: "
            +resultado.getInt(4)+"\t\tNombre asignatura: "
            +resultado.getString(5));
        }
        //Free resources and close data flow
        //Liberar recursos
        resultado.close();
        sentencia.close();
        conexion.close();
    }
}
