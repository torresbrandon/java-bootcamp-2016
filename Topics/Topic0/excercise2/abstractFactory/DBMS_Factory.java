package abstractFactory;

/**
 * @author Brandon
 *
 */
import Product.BD_connection;
//interface about of factory
public interface DBMS_Factory {
	

	
	public BD_connection createConnection();

}
