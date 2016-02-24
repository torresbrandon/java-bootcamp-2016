/*
 * @Author: Brandon Torres
 */
package singleton;

/*
 * principal class
 */
public class mainSingleton {
	public static void main(String[] args) {
		System.out.println("-------DB CONNECTION-------------");
	
		ConnectionSingleton connDB = new ConnectionSingleton().getInstance("System", "123");
		ConnectionSingleton connDB2 = new ConnectionSingleton().getInstance("Brandon", "0000");
		System.out.println("Instances number: "+ connDB.getNumInstances());
		
	}

}
