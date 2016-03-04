/**
 * 
 */
package userService;

/**
 * @author Brandon
 *
 */
/**
 * This class simulate the connection a DB, only can be created one instance in
 * the BD
 */
public class ConnectionDB {
	UserDB user;

	private static ConnectionDB connectionDB = null;

	private ConnectionDB(UserDB user) {
		this.user = user;

	}

	/**
	 * This method return the instance of ConnectionDB
	 * 
	 * @param user
	 *            Is a object of UserDB
	 * @return connection to the DB
	 */
	public static ConnectionDB getInstance(UserDB user) {
		if (connectionDB == null) {
			connectionDB = new ConnectionDB(user);
		}
		System.out.println("Connecting to DB with user " + user.getUser());
		return connectionDB;

	};

	/**
	 * This method do the operation in the bd
	 * 
	 * @param operation
	 *            is the operation that will realize the DB
	 */
	public void doOperation(String operation) {
		System.out.println(operation);
	};

	/**
	 * This method close the connection
	 */
	public void closeConnect() {
		System.out.println("Close connection to DB with user " + user.getUser());
	};

}
