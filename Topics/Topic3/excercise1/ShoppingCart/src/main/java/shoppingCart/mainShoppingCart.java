/**
 * 
 */
package shoppingCart;

/**
 * @author Brandon
 *
 */
public class mainShoppingCart {
	
	public static void main(String[] args){

		ShoppingOperations customer = ServiceShoppingCart.getLocalService();
		Item newItem = new Item();
		newItem.setIdItem(1);
		newItem.setNameItem("Jacket");
		newItem.setColor("Blue");
		newItem.setQuantity(2);
		newItem.setPriceUnit(150000);
		customer.addItem(newItem);
		System.out.println(customer.quantityElements());
	
	}

}
