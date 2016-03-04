/**
 * 
 */
package shoppingCart;

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
	public void addItem(Item product);

	/**
	 * This method delete a Item in shopping cart
	 * 
	 * @param product
	 *            Is a object of Item
	 */
	public void deleteItem(Item product);

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
	 * This method modify a ColorItem by Id in shopping cart
	 * 
	 * @param id
	 *            is the id of a product that change the color
	 * @param newColor
	 *            is the name of the new color
	 */
	public void modifyColorItem(int id, String newColor);

	/**
	 * This method search a Quantity of a Item by Id in shopping cart
	 * 
	 * @param id
	 *            is the id of a product that change the color
	 * @param newQuantity
	 *            is the new quantity r
	 */
	public void modifyQuantityItem(int id, int newQuantity);

	/**
	 * This method show the total of shopping carT
	 * 
	 * @return is the total of shoppingCart
	 */
	public int showTotalShoppingCart();

	/**
	 * This method show the quantity of elements on shopping cart
	 * 
	 * @return a integer that is the quantity of elements in the shoppingCart
	 */
	public int quantityElements();

}
