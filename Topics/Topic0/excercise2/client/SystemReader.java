/**
 * 
 */
package client;

import abstractFactory.DBMS_Factory;
import abstractFactory.MySqlFactory;
import abstractFactory.OracleFactory;
import abstractFactory.PostgresFactory;

/**
 * @author Brandon
 *
 */
public class SystemReader {

	public static DBMS_Factory getDBMS() {
		String DBMS = "MySQL";
		if (DBMS.equals("Oracle")) {
			return new OracleFactory();
		}
		if (DBMS.equals("MySQL")) {
			return new MySqlFactory();
		} else {
			return new PostgresFactory();
		}
	}
}
