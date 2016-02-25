/**
 * 
 */
package abstractFactory;

import Product.BD_connection;
import Product.MysqlConnection;

/**
 * @author Brandon
 *
 */
public class MySqlFactory implements DBMS_Factory{

	@Override
	public BD_connection createConnection() {
		// Return a MysqlConnection Object
		return new MysqlConnection();
	}

}
