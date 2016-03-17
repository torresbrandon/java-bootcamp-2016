package shoppingCart;

/**
 * This class is a class that defines the way for to connect. The methods are
 * responsible of to create the instance according to the feature of the
 * connection.
 */
public class ServiceShoppingCart {
	private ServiceShoppingCart() {

	}

	/**
	 * This method return a instance of ShoppingCart, for this case only create
	 * one, because only will use a Shopping Cart.
	 * @return instance of ShoppingCart
	 */
	public static ShoppingCart getLocalService() {
		return new ShoppingCart();
	}

}
