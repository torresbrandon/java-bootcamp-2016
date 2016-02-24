/**
 * 
 */
package exercise4;

/**
 * @author Brandon
 *
 */
public class MysqlDB extends MotorDB {

	// This method obtain the super user for MySQL
	@Override
	public void obtainUser() {
		connDB.setUser("root");

	}

	// This method obtain the password for the user in MySQL
	@Override
	public void obtainPassword() {
		connDB.setPassword("0000");

	}

	// This method obtain the host that is needed for the connection with MySQL
	@Override
	public void obtainHost() {
		connDB.setHost("localhost");

	}

	// This method obtain the port for the connection with MySQL
	@Override
	public void obtainPort() {
		connDB.setPort(13306);

	}

	// This method obtain the name of DBMS
	@Override
	public void obtainNameDBMS() {
		connDB.setNameDBMS("MySQL");
		
	}

}
