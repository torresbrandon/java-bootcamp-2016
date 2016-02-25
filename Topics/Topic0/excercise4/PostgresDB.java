/**
 * 
 */
package exercise4;

/**
 * @author Brandon
 *
 */
public class PostgresDB extends MotorDB {

	// This method obtain the super user for Postgres
	@Override
	public void obtainUser() {
		connDB.setUser("postgres");

	}

	// This method obtain the password for the user in Postgres
	@Override
	public void obtainPassword() {
		connDB.setPassword("0000");

	}

	// This method obtain the host that is needed for the connection with
	// Postgres
	@Override
	public void obtainHost() {
		connDB.setHost("localhost");

	}

	// This method obtain the port for the connection with Postgres
	@Override
	public void obtainPort() {
		connDB.setPort(5432);

	}
	
	// This method obtain the name of DBMS
	@Override
	public void obtainNameDBMS() {
		connDB.setNameDBMS("Postgres");
		
	}

}
