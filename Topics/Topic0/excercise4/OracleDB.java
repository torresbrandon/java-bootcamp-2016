/**
 * 
 */
package exercise4;

/**
 * @author Brandon
 *
 */
public class OracleDB extends MotorDB {

	// This method obtain the super user for Oracle
	@Override
	public void obtainUser() {
		connDB.setUser("system");

	}

	// This method obtain the password for the user in Oracle
	@Override
	public void obtainPassword() {
		connDB.setPassword("0000");

	}

	// This method obtain the host that is needed for the connection with Oracle
	@Override
	public void obtainHost() {
		connDB.setHost("localhost");

	}

	// This method obtain the port for the connection with Oracle
	@Override
	public void obtainPort() {
		connDB.setPort(1521);

	}

	// This method obtain the name of DBMS
	@Override
	public void obtainNameDBMS() {
		connDB.setNameDBMS("Oracle");
		
	}

}
