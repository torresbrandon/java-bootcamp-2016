/**
 * 
 */
package shoppingCart;

/**
 * @author Brandon
 *
 */
/**
 * This is the principal class
 */
public class MainShoppingCart {

	public static void main(String[] args) {

		ShoppingOperations customer = ServiceShoppingCart.getLocalService();
		// Create the Item object
		Item newItem = new Item();
		newItem.setIdItem(1);
		newItem.setNameItem("Jacket");
		newItem.setColor("Blue");
		newItem.setQuantity(2);
		newItem.setPriceUnit(150000);
		// Add item in the shopping cart
		customer.addItem(newItem);
		System.out.println(customer.quantityElements());

	}

}
