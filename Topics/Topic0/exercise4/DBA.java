/**
 * 
 */
package exercise4;

/**
 * @author Brandon
 *
 */
/*
 * This class is the director of builder pattern. The Function is to create the connection
 * according the MotorDB(Builder)
 */
public class DBA {

	//Declarate a object of type MotorDB
	private MotorDB motorDb;

	/*
	 * This method defines the object of the builder 
	 */
	public void setMotorDB(MotorDB mtDB) {
		motorDb = mtDB;
	}

	/*
	 * This method obtain the object of the builder 
	 */
	public ConnectionDB getConnectionDBA() {
		return motorDb.getConnectionDB();
	}

	/*
	 * This method create the connection according the concrete builder
	 */
	public void createConnection(){
		motorDb.createNewConnection();
		motorDb.obtainNameDBMS();
		motorDb.obtainUser();
		motorDb.obtainPassword();
		motorDb.obtainHost();
		motorDb.obtainPort();
	
	}
}
