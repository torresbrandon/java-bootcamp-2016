package userService;

/**
 * This is the principal class
 */
public class MainUserService {

	public static void main(String[] args) {
		DBService dbservice = ServicePersons.getLocalService();
		// User object
		UserDB user = new UserDB();
		user.setUser("brandon");
		user.setPassword("12345657");
		// Person object
		Person person = new Person();
		// Creating the person
		person.setIdPerson(123);
		person.setName("Pepito");
		person.setLastName("Perez");
		person.setPhone("1234567");
		person.setEmail("pepito@gmail.com");
		// Creating the register
		dbservice.createRegisterPerson(person, user);
		dbservice.readRegisterPerson(123, user);

	}

}
