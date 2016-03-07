/**
 * 
 */
package data;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;

import business.Student;
import business.User;
import util.ServiceLocator;

/**
 * @author Brandon
 *
 */
public class StudentDAO {
	
	
	public Student buscarEstudiante(String id_estudiante, User user) {
        Student estudiante = new Student();
    
         String error="";
        try {
        
            //Instancia el objeto para retornar los datos del empleado
            String strSQL = "SELECT * FROM student WHERE K_register=?";
            Connection conexion = ServiceLocator.getInstance(user).takeConnection();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, Integer.parseInt(id_estudiante));
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
            	estudiante.setId(rs.getInt(1));
            	estudiante.setName(rs.getString(2));
            	estudiante.setLast_name(rs.getString(3));
            	estudiante.setBirt_day(rs.getString(4));
            
            }
              prepStmt.close();
            ServiceLocator.getInstance(user).commit();
            return estudiante;
        } catch (SQLException e) {
            error = "Estudiante DAO " + "Buscar Id Estudiante " + e.getMessage();
          
        } finally {
            ServiceLocator.getInstance(user).breakFreeConnection();
        }
          System.out.println(estudiante.getLast_name());
        return estudiante;
    }
    

}
