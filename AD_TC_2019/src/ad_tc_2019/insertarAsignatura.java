/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_tc_2019;

//Paso 1 importar clases
import java.sql.*;

/**
 *
 * @author dmm_s
 */
public class insertarAsignatura {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        //Paso 2: Cargar el driver
        Class.forName("com.mysql.jdbc.Driver");
        
        //Paso 3: Establer conexion con la BD: URL, Usuario, Pass
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/instituto","root","");
        
        //Paso 4: Preparar la sentencia.
        Statement sentencia = conexion.createStatement();
        
        //Paso 5: Lanzar sentencia.
        String insercion = "INSERT INTO Asignaturas VALUES (11, 'EIE', 'Empresa e iniciativa emprendedora', 1)";
        
        int filas = sentencia.executeUpdate(insercion); //filas insertada 
        
        System.out.println("Tras la inserción se han insertado " + filas + " filas");
        
        //Paso 7: Liberar los recursos
        sentencia.close();
        conexion.close();  
        
    }
    
    
    
}
