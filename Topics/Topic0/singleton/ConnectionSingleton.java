/*
 * @Author: Brandon Torres
 */
package singleton;

public class ConnectionSingleton {

	/**
	 * Instance of Conexion
	 */
	private static ConnectionSingleton instance = null;

	private int numInstances = 0;

	/**
	 * @return instance of connectionSingleton
	 */
	public synchronized static ConnectionSingleton getInstance(String usuario, String password) {
		if (instance == null) {
			try {
				instance = new ConnectionSingleton(usuario, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return instance;
	}

	/*
	 * builder of connectionSingleton with two parameters
	 */
	private ConnectionSingleton(String usuario, String password) throws Exception {
		try {
			numInstances = +1;
			System.out.println("Conexion establecida por " + usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ConnectionSingleton() {
		// TODO Auto-generated constructor stub
	}

	
	public int getNumInstances() {
		return numInstances;
	}

	public void setNumInstances(int numInstances) {
		this.numInstances = numInstances;
	}



}
