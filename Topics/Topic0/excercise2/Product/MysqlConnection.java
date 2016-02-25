package Product;

/**
 * @author Brandon
 *
 */
public class MysqlConnection implements BD_connection {

	@Override
	public void showStateConnection() {
		// Show a message about of connection state for MySQL
		System.out.println("Connection established with MySQL");
		
	}

}
