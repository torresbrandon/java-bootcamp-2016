/**
 * 
 */
package exercise4;

/**
 * @author Brandon
 *
 */
public abstract class MotorDB {
	protected ConnectionDB connDB;

	public ConnectionDB getConnectionDB() {
		return connDB;
	}

	public void createNewConnection() {
		connDB = new ConnectionDB();
	}

	public abstract void obtainNameDBMS();
	
	public abstract void obtainUser();

	public abstract void obtainPassword();

	public abstract void obtainHost();

	public abstract void obtainPort();

}
