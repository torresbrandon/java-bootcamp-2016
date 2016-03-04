/**
 * 
 */
package userService;

import java.util.LinkedList;

/**
 * @author Brandon
  *//**
 *  This class implements DBService, is the API with the CRUD methods.
 * 
 */
public class UserService implements DBService {

	protected UserService() {
	};

	// The list that has the persons, this is necesary for simulate the CRUD
	// operations
	private LinkedList<Person> registers = new LinkedList();
	private Person person = new Person();

	/**
	 * Simulate the creation of a conn with a DB Do the operation add person in
	 * the LinkedList. Simulating as if you were creating a record in DB Close
	 * the connection.
	 */
	@Override
	public void createRegisterPerson(Person person, UserDB user) {

		ConnectionDB conn = ConnectionDB.getInstance(user);
		registers.add(person);
		String operation = "Creating Person.....";
		conn.doOperation(operation);
		conn.closeConnect();

	}

	/**
	 * Simulate the creation of a conn with a DB Do the operation search o read
	 * a person in the LinkedList. Simulating as if you were searching a record
	 * in DB Close the connection.
	 * 
	 * @return Person
	 */
	@Override
	public Person readRegisterPerson(int id, UserDB user) {
		ConnectionDB conn = ConnectionDB.getInstance(user);
		String operation = "Reading Person.....";
		conn.doOperation(operation);
		for (int i = 0; i < registers.size(); i++) {
			if (registers.get(i).getIdPerson() == id) {
				person = registers.get(i);

			}
		}

		conn.closeConnect();
		return person;

	}

	/**
	 * Simulate the creation of a conn with a DB Do the operation update name of
	 * a person in the LinkedList. Simulating as if you were updating a record
	 * in DB Close the connection.
	 */
	@Override
	public void updateRegisterNamePerson(int id, String name, UserDB user) {
		ConnectionDB conn = ConnectionDB.getInstance(user);
		String operation = "Updating Person.....";
		conn.doOperation(operation);
		for (int i = 0; i < registers.size(); i++) {
			if (registers.get(i).getIdPerson() == id) {
				registers.get(i).setName(name);
			}

		}

		conn.closeConnect();
	}

	/**
	 * Simulate the creation of a conn with a DB Do the operation delete a
	 * person with the id in the LinkedList. Simulating as if you were deleting
	 * a record in DB Close the connection.
	 */
	@Override
	public void deleteRegisterPerson(int id, UserDB user) {
		ConnectionDB conn = ConnectionDB.getInstance(user);
		String operation = "Deleting Person.....";
		conn.doOperation(operation);
		for (int i = 0; i < registers.size(); i++) {
			if (registers.get(i).getIdPerson() == id) {

				registers.remove(i);

			}
		}
		conn.closeConnect();

	}

	// get Registers LinkedList
	public LinkedList<Person> getRegisters() {
		return registers;
	}

	// set Registers LinkedList
	public void setRegisters(LinkedList<Person> registers) {
		this.registers = registers;
	}

}
