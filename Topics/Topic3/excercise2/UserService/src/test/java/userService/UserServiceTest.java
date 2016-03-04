package userService;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



/**
 * 
 */

/**
 * @author Brandon
 *//**
 *This class defines the test for the UserService
 */
public class UserServiceTest {
	UserService userService;
	Person person;
	UserDB user;
	
	@Before
    public void setUp() {
        userService = new UserService();
        person = new Person();
        person.setIdPerson(123);
        person.setName("Pepito");
        person.setLastName("Perez");
        person.setPhone("1234567");
        person.setEmail("pepito@gmail.com");
        user = new UserDB();
        user.setUser("brandon");
        user.setPassword("12345657");
        System.out.println("@Before - setUp");
    }

	 @After
	    public void tearDown() {
	    //    userService.getRegisters().clear();
	        System.out.println("@After - tearDown");
	    }

	 /**
	  * This test compare if the person created is in the linkedList in the first position
	  */
	@Test
	public void createRegisterPersonTest() {
		
		 userService.createRegisterPerson(person, user);
	   	 assertTrue(userService.getRegisters().get(0)==person);
	}

	 /**
	  * This test compare if the person created and after deleted is in the linkedList, if doesn't exist the test is OK
	  */
	@Test
	public void deleteRegisterTest() {
		 userService.createRegisterPerson(person,  user);
		userService.deleteRegisterPerson(person.getIdPerson(), user);
		assertFalse(userService.getRegisters().contains(person));
	}

	 /**
	  * This test compare if the person created and after searched is in the linkedList, if find the person and compare 
	  * with the person created the test is successfully
	  */
	@Test
	public void readRegisterPersonTest() {
		 userService.createRegisterPerson(person,  user);
		assertEquals(userService.readRegisterPerson(person.getIdPerson(),  user), person);

	}


	 /**
	  * This test compare if the person created and after update the name is in the linkedList
	  * with the new name, if the change is in the list the test is successfully
	  */
	@Test
	public void updateRegisterPersonTest() {
		String newName="Pepe";
		 userService.createRegisterPerson(person, user);
		userService.updateRegisterNamePerson(person.getIdPerson(), newName, user);
		assertEquals(userService.getRegisters().get(userService.getRegisters().indexOf(person)).getName(), newName);
	}


}
