/**
 * 
 */
package excercise3;

/**
 * @author Brandon
 *
 */
// Principal class where is created the object proxy
public class mainClient {

	public static void main(String[] args) {

		AccessBD acceso = new ProxyAccessBD();
		acceso.update("123456", "information");
		// Is not necesary connect again
		System.out.println(" ");
		acceso.select("123456");

	}

}
