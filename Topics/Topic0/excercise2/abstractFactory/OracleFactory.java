/**
 * 
 */
package abstractFactory;

import Product.BD_connection;
import Product.OracleConnection;

/**
 * @author Brandon
 *
 */
public class OracleFactory implements DBMS_Factory {

	@Override
	public BD_connection createConnection() {
		// Return a OracleConnection Object
		return new OracleConnection();
	}

}
