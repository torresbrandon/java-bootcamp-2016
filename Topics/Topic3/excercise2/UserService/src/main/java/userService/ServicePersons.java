package userService;

/**
 * This class is a class that defines the way for to connect. The methods are
 * responsible of to create the instance according to the feature of the
 * connection.
 */
public class ServicePersons {
	private ServicePersons() {

	}

	/**
	 * This method return a instance of UserService, for this case only create
	 * one, because only will use a list.
	 * 
	 * @return instance of userService
	 */
	public static DBService getLocalService() {
		return new UserService();
	}

}
