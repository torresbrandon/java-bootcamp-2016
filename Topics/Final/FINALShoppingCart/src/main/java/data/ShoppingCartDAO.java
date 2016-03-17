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
import business.PayCreditCard;
import util.ServiceLocator;

/**
 * @author Brandon
 *
 */
public class ShoppingCartDAO {

	public String addProduct(String email_client, int id_item, int units) {

		String error = "";
		try {

			// Instancia el objeto para retornar los datos del empleado
			String strSQL = "INSERT INTO cart VALUES(?,?,?)";
			Connection conexion = ServiceLocator.getInstance().takeConnection();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setString(1, email_client);
			prepStmt.setInt(2, id_item);
			prepStmt.setInt(3, units);

			prepStmt.executeUpdate();
			prepStmt.close();

			ServiceLocator.getInstance().commit();

		} catch (SQLException e) {
			error = "Shopping CART DAO " + "Inserting in cart " + e.getMessage();

		} finally {
			ServiceLocator.getInstance().breakFreeConnection();
		}
		return error;
	}

	public String deleteProduct(String email_client, int id_item) {

		String error = "";
		try {

			// Instancia el objeto para retornar los datos del empleado
			String strSQL = "delete from cart where fk_emailclient=? and fk_item=?";
			Connection conexion = ServiceLocator.getInstance().takeConnection();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setString(1, email_client);
			prepStmt.setInt(2, id_item);

			prepStmt.executeUpdate();
			prepStmt.close();

			ServiceLocator.getInstance().commit();

		} catch (SQLException e) {
			error = "Shopping CART DAO " + "Deleting in cart " + e.getMessage();

		} finally {
			ServiceLocator.getInstance().breakFreeConnection();
		}
		return error;
	}

	public String addSale(String username, int total, String payment) {

		String error = "";
		try {

			// Instancia el objeto para retornar los datos del empleado
			String strSQL = "INSERT INTO sale (purchasedate, payment, total, fk_client) VALUES(sysdate(),?,?,?)";
			Connection conexion = ServiceLocator.getInstance().takeConnection();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setString(1, payment);
			prepStmt.setInt(2, total);
			prepStmt.setString(3, username);

			prepStmt.executeUpdate();
			prepStmt.close();

			ServiceLocator.getInstance().commit();

		} catch (SQLException e) {
			error = "Shopping CART DAO " + "Inserting sale " + e.getMessage();

		} finally {
			ServiceLocator.getInstance().breakFreeConnection();
		}
		return error;
	}

	public String addSaleItem(int id_item, int units) {

		String error = "";
		try {

			// Instancia el objeto para retornar los datos del empleado
			String strSQL = "INSERT INTO sale_item VALUES(LAST_INSERT_ID(),?,?)";
			Connection conexion = ServiceLocator.getInstance().takeConnection();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setInt(1, id_item);
			prepStmt.setInt(2, units);

			prepStmt.executeUpdate();
			prepStmt.close();

			ServiceLocator.getInstance().commit();

		} catch (SQLException e) {
			error = "Shopping CART DAO " + "Inserting sale item" + e.getMessage();

		} finally {
			ServiceLocator.getInstance().breakFreeConnection();
		}
		return error;
	}

	public String deleteCart(String username) {

		String error = "";
		try {

			// Instancia el objeto para retornar los datos del empleado
			String strSQL = "delete c FROM cart c, client cl where fk_emailClient=?";
			Connection conexion = ServiceLocator.getInstance().takeConnection();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setString(1, username);

			prepStmt.executeUpdate();
			prepStmt.close();

			ServiceLocator.getInstance().commit();

		} catch (SQLException e) {
			error = "Shopping CART DAO " + "Deleting  cart " + e.getMessage();

		} finally {
			ServiceLocator.getInstance().breakFreeConnection();
		}
		return error;
	}

	public String addCredit(PayCreditCard creditCard) {

		String error = "";
		try {

			// Instancia el objeto para retornar los datos del empleado
			String strSQL = "INSERT INTO credit VALUES(?,?,?,?,LAST_INSERT_ID())";
			Connection conexion = ServiceLocator.getInstance().takeConnection();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setString(1, creditCard.getCardType());
			prepStmt.setInt(2, creditCard.getNumberCard());
			prepStmt.setInt(3, creditCard.getRateNumber());
			prepStmt.setInt(4, creditCard.getIdClient());
			

			prepStmt.executeUpdate();
			prepStmt.close();

			ServiceLocator.getInstance().commit();

		} catch (SQLException e) {
			error = "Shopping CART DAO " + "Inserting credit" + e.getMessage();

		} finally {
			ServiceLocator.getInstance().breakFreeConnection();
		}
		return error;
	}
}
