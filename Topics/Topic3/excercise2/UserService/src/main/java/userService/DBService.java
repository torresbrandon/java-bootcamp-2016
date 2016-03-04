/**
 * 
 */
package userService;

/**
 * @author Brandon
 *//**
 *         This class is the interface where define the methods that can be
 *         implemented
 */
public interface DBService {

	/**
	 * This method create a register of a person
	 * 
	 * @param person
	 *            Is a object form Person
	 * @param user
	 *            Is a object of UserDB
	 */
	public void createRegisterPerson(Person person, UserDB user);

	/**
	 * This method read a register of a person
	 * 
	 * @param id
	 *            is the id for to search the person
	 * @param user
	 *            Is a object of UserDB
	 * @return person that is searched
	 */
	public Person readRegisterPerson(int id, UserDB user);

	/**
	 * This method update a register of a person
	 * 
	 * @param id
	 *            is the id for to search the person
	 * @param user
	 *            Is a object of UserDB
	 * @param name
	 *            is the new name of the person
	 * 
	 * 
	 */
	public void updateRegisterNamePerson(int id, String name, UserDB user);

	/**
	 * This method delete a register of a person
	 * 
	 * @param user
	 *            Is a object of UserDB
	 * @param id
	 *            is the id for to search the person for to do the update of
	 *            name
	 *
	 */
	public void deleteRegisterPerson(int id, UserDB user);

}
