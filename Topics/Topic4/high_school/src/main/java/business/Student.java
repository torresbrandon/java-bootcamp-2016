/**
 * 
 */
package business;

/**
 * @author Brandon
 *
 */
public class Student {
	
	private int id=0;
	private String name ="";
	private String last_name="";
	private String birth_day="";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getBirt_day() {
		return birth_day;
	}
	public void setBirt_day(String birt_day) {
		this.birth_day = birt_day;
	}
	
	
	

}
