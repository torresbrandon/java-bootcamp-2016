/**
 * 
 */
package Product;

/**
 * @author Brandon
 *
 */
public class PostgresConnection implements BD_connection {

	@Override
	public void showStateConnection() {
		// Show a message about of connection state for Postgres
				System.out.println("Connection established with Postgres");
		
	}

}
