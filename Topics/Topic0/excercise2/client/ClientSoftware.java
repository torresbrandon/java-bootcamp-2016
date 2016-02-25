/**
 * 
 */
package client;

import Product.BD_connection;
import abstractFactory.DBMS_Factory;

/**
 * @author Brandon
 *
 */
public class ClientSoftware {
	
	  public ClientSoftware(DBMS_Factory factory) {
	        BD_connection connection = factory.createConnection();
	        connection.showStateConnection();
	    }
	    
	    public static void main(String[] args) {
	        new ClientSoftware(SystemReader.getDBMS());
	    }

}
