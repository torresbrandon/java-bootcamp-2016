/**
 * 
 */
package userService;

/**
 * @author Brandon
  *//**
 *         This class has the attributes of a Person Is a business logic class
 */
public class Person {

	private int idPerson;
	private String name;
	private String lastName;
	private String phone;
	private String email;

	public Person() {

	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
