/**
 * 
 */
package shoppingCart;

import java.util.LinkedList;

import business.Client;
import business.Item;
import business.PayCreditCard;

/**
 * @author Brandon
 *
 */
/**
 * 
 * This interface defines the operations for the shopping cart
 *
 */
public interface ShoppingOperations {

	/**
	 * This method add a Item in shopping cart
	 * 
	 * @param product
	 *            Is a object of Item
	 */
	public void addItem(String username, int idProduct, int quantity);

	/**
	 * This method delete a Item in shopping cart
	 * 
	 * @param product
	 *            Is a object of Item
	 *  @return If was deleting the Item, 1 true, 0 false
	 */
	public int deleteItem(String username, int id);

	/**
	 * This method search a Item by Id in shopping cart
	 * 
	 * @param id
	 *            Is the id of product searched
	 * @return a Item searched if this exists
	 */
	public Item searchItemById(int id);

	/**
	 * This method search a Item by Name in shopping cart
	 * 
	 * @param productName
	 *            Is the name of product searched
	 * @return a Item searched if this exists
	 * 
	 */
	public Item searchItemByName(String productName);



	/**
	 * This method search a Quantity of a Item by Id in shopping cart
	 * 
	 * @param id
	 *            is the id of a product that change the color
	 * @param newQuantity
	 *            is the new quantity r
	 */

	public int showTotalShoppingCart();

	/**
	 * This method show the quantity of elements on shopping cart
	 * 
	 * @return a integer that is the quantity of elements in the shoppingCart
	 */
	public int quantityElements();
	
	public void registerUser(Client client);
	
	public int loginUser(String username, String password);
	
	public LinkedList<Item> searchItemByCategory(String categoryName);
	public void buyShoppCart(String username, String payment, PayCreditCard creditCard);

}
