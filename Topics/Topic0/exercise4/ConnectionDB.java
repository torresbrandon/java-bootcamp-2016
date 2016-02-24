/**
 * 
 */
package exercise4;

/**
 * @author Brandon
 *
 */

/*
 * This class is the product of builder pattern. The Function is to have the
 * info for to establish a connection with DBMS
 */
public class ConnectionDB {
	//Attributes of a connection of databases
	private String nameDBMS="";
	private String user = "";
	private String password = "";
	private String host = "";
	private int port = 0;

	//getter and setter about of attributes
	
	public String getNameDBMS() {
		return nameDBMS;
	}

	public void setNameDBMS(String nameDBMS) {
		this.nameDBMS = nameDBMS;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
