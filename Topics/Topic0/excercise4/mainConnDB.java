package exercise4;

public class mainConnDB {
	/*
	 * The main mehitd, this is the client that define that he wants.
	 */
	public static void main(String[] args) {
		// Create a director
		DBA dba = new DBA();
		// Create a concrete builder
		MotorDB oracle_db = new OracleDB();
		MotorDB postgres_db = new PostgresDB();
		// Indicate to the director what is the concrete builder
		dba.setMotorDB(postgres_db);
		// The director create the connection
		dba.createConnection();

		//Obtain the product (connection) that was created and show their attributes
		ConnectionDB connDb = dba.getConnectionDBA();
		System.out.println("-------CONNECTION DB--------------");
		System.out.println("Se ha realizado la conexion con: " + connDb.getNameDBMS());
		System.out.println("Se ha conectado: " + connDb.getUser() + " con " + connDb.getHost() + " en el puerto: "
				+ connDb.getPort());
	}
}