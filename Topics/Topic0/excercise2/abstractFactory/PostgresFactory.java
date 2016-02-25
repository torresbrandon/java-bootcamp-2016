/**
 * 
 */
package abstractFactory;

import Product.BD_connection;
import Product.PostgresConnection;

/**
 * @author Brandon
 *
 */
public class PostgresFactory implements DBMS_Factory{

	@Override
	public BD_connection createConnection() {
		// Return a PostgresConnection object
		return new PostgresConnection() ;
	}

}
