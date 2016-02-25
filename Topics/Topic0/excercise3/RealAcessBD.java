package excercise3;

//This class do the real operations and can connect with database
public class RealAcessBD implements AccessBD {

	public RealAcessBD() {
		conectarBD();
	}

	// These methods show the operations that we can do in a database like
	// insert, update, delete and select

	@Override
	public void insert(String id, String text) {
		System.out.println("Inserting " + text + " with id " + id + " ........");
		System.out.println("Successful Process!!");
	}

	@Override
	public void update(String id, String text) {
		System.out.println("Updating " + text + " where id " + id + " ........");
		System.out.println("Successful Process!!");

	}

	@Override
	public void delete(String id) {
		System.out.println("Deleting where id " + id + " ........");
		System.out.println("Successful Process!!");

	}

	@Override
	public void select(String id) {
		System.out.println("Selecting where id " + id + " ........");
		System.out.println("Successful Process!!");
	}

	// This method is used for connect with the DB
	public void conectarBD() {
		System.out.println("Connecting to BD ........");
		System.out.println("Connected");
	}

}
