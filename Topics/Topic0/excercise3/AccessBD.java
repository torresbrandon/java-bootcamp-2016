package excercise3;

//This is the interface for Proxy and Real AccessBD
public interface AccessBD {
	// method for insert in the DB
	public void insert(String id, String text);

	// method for update in the DB
	public void update(String id, String text);

	// method for delete in the DB
	public void delete(String id);

	// method for select in the DB
	public void select(String id);

}
