/**
 * 
 */
package shoppingCart;

import java.util.ArrayList;
import java.util.LinkedList;

import shoppingCart.*;

/**
 * @author Brandon
 *//**
 *         This class implements ShoppingOperation, is the API with the methods
 *         that need.
 * 
 */
public class ShoppingCart implements ShoppingOperations {
	private Item product = new Item();
	private LinkedList<Item> listItems = new LinkedList();

	protected ShoppingCart() {
	}

	/**
	 * This method add a product in the shoppingCart, is to say the listItems
	 */
	@Override
	public void addItem(Item product) {
		listItems.add(product);

	}

	/**
	 * This method delete a product in the shoppingCart, is to say delete the
	 * Item in the listItems
	 * 
	 * @param product Is a object of Item
	 */
	@Override
	public void deleteItem(Item product) {
		listItems.remove(product);

	}

	/**
	 * 
	 * This method search a product in the shoppingCart by id, is to say search
	 * in the listItems by id of Item
	 * 
	 * @param id Is the id of a product that has been searched
	 */
	@Override
	public Item searchItemById(int id) {
		for (int i = 0; i < listItems.size(); i++) {
			if (listItems.get(i).getIdItem() == id) {
				product = listItems.get(i);
			}
		}
		return product;
	}

	/**
	 * This method search a product in the shoppingCart by name, is to say
	 * search in the listItems by name of Item
	 */
	@Override
	public Item searchItemByName(String productName) {
		for (int i = 0; i < listItems.size(); i++) {
			if (listItems.get(i).getNameItem() == productName) {
				product = listItems.get(i);
			}
		}
		return product;
	}

	/**
	 * This method modify a color of product in the shoppingCart, is to say
	 * search in the listItems and change the color
	 */
	@Override
	public void modifyColorItem(int id, String newColor) {
		for (int i = 0; i < listItems.size(); i++) {
			if (listItems.get(i).getIdItem() == id) {
				listItems.get(i).setColor(newColor);
			}
		}

	}

	/**
	 * This method modify a quantity of product in the shoppingCart, is to say
	 * search in the listItems and change the quantity
	 */
	@Override
	public void modifyQuantityItem(int id, int newQuantity) {
		for (int i = 0; i < listItems.size(); i++) {
			if (listItems.get(i).getIdItem() == id) {
				listItems.get(i).setQuantity(newQuantity);
			}
		}
	}

	/**
	 * This method show total of the shoppingCart
	 */
	@Override
	public int showTotalShoppingCart() {
		int total = 0, aux = 0;
		for (int i = 0; i < listItems.size(); i++) {
			aux = listItems.get(i).getPriceUnit() * listItems.get(i).getQuantity();
			total = total + aux;
		}
		return total;
	}

	@Override
	public int quantityElements() {
		return listItems.size();

	}

	public Item getProduct() {
		return product;
	}

	public void setProduct(Item product) {
		this.product = product;
	}

	public LinkedList<Item> getListItems() {
		return listItems;
	}

	public void setListItems(LinkedList<Item> listItems) {
		this.listItems = listItems;
	}

}
