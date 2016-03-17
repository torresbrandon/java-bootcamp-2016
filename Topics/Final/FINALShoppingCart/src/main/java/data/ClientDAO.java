/**
 * 
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.Client;
import business.Item;
import util.ServiceLocator;

/**
 * @author Brandon
 *
 */
public class ClientDAO {
	
public String addUser(Client client) {
        
		
        String error="";
       try {
       
           //Instancia el objeto para retornar los datos del empleado
           String strSQL = "INSERT INTO client VALUES(?,?,?,?,?,?,?,?,?,?)";
           Connection conexion = ServiceLocator.getInstance().takeConnection();
           PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
           prepStmt.setInt(1, client.getIdClient());
           prepStmt.setString(2, client.getNameClient());
           prepStmt.setString(3,client.getLastName());
           prepStmt.setString(4,client.getCity());
           prepStmt.setString(5,client.getNeighborhood());
           prepStmt.setString(6,client.getAddress());
           prepStmt.setInt(7, client.getPhone());
           prepStmt.setString(8,client.getEmail());
           prepStmt.setString(9,client.getUsername());
           prepStmt.setString(10,client.getPassword());
     
           
          prepStmt.executeUpdate();
          prepStmt.close();
           
          
           ServiceLocator.getInstance().commit();
        
       } catch (SQLException e) {
           error = "Shopping CART DAO " + "Register client " + e.getMessage();
         
       } finally {
           ServiceLocator.getInstance().breakFreeConnection();
       }
    return error;
   }

public int loginUser(String username, String password) {
	int exist=-1;

     String error="";
    try {
    
        //Instancia el objeto para retornar los datos del empleado
        String strSQL = "SELECT count(email) FROM client where username =? and password=?";
        Connection conexion = ServiceLocator.getInstance().takeConnection();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.setString(1, username);
        prepStmt.setString(2, password);
        ResultSet rs = prepStmt.executeQuery();
        while (rs.next()) {
        	exist = rs.getInt(1); 	
        }
          prepStmt.close();
        ServiceLocator.getInstance().commit();
        return exist;
    } catch (SQLException e) {
        error = "Client DAO " + "Loggin " + e.getMessage();
      
    } finally {
        ServiceLocator.getInstance().breakFreeConnection();
    }
      
    return exist;
}
}
