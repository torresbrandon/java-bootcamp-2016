/**
 * 
 */
package Product;

/**
 * @author Brandon
 *
 */
public class OracleConnection implements BD_connection {

	@Override
	public void showStateConnection() {
		// Show a message about of connection state for Oracle
				System.out.println("Connection established with Oracle");
	}

}
