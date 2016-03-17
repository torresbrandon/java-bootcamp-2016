/**
 * 
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.Item;
import util.ServiceLocator;

/**
 * @author Brandon
 *
 */
public class ItemDAO {
	
	public Item searchItem(int id_item) {
        Item item = new Item();
    
         String error="";
        try {
        
            //Instancia el objeto para retornar los datos del empleado
            String strSQL = "SELECT idItem, nameItem, price, description, color, nameCategory FROM item, category where idItem=? and fk_category=idCategory;";
            Connection conexion = ServiceLocator.getInstance().takeConnection();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, id_item);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
            	
            	item.setIdItem(rs.getInt(1));
            	item.setNameItem(rs.getString(2));
            	item.setPriceUnit(rs.getInt(3));
            	item.setDescription(rs.getString(4));
            	item.setColor(rs.getString(5));
            	item.setCategory(rs.getString(6));
            	
            }
              prepStmt.close();
            ServiceLocator.getInstance().commit();
            return item;
        } catch (SQLException e) {
            error = "ShoppingCart DAO " + "Item " + e.getMessage();
          
        } finally {
            ServiceLocator.getInstance().breakFreeConnection();
        }
          
        return item;
    }

}
