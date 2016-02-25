/**
 * 
 */
package excercise3;

/**
 * @author Brandon
 *
 */
// This class is instantiated and it is comunicated wiht the realAcces for that
// execute the operations that is necessary
public class ProxyAccessBD implements AccessBD {

	private RealAcessBD realAccess;
	// These methods show the operations that we can do in a database like
	// insert, update, delete and select
	// The methos evaluated if the object is created or no, and after it creates
	// the object if is necessary

	@Override
	public void insert(String id, String text) {
		if (realAccess == null) {
			realAccess = new RealAcessBD();
		}
		realAccess.insert(id, text);
	}

	@Override
	public void update(String id, String text) {
		if (realAccess == null) {
			realAccess = new RealAcessBD();
		}
		realAccess.update(id, text);
	}

	@Override
	public void delete(String id) {
		if (realAccess == null) {
			realAccess = new RealAcessBD();
		}
		realAccess.delete(id);
	}

	@Override
	public void select(String id) {
		if (realAccess == null) {
			realAccess = new RealAcessBD();
		}
		realAccess.select(id);
	}

}
