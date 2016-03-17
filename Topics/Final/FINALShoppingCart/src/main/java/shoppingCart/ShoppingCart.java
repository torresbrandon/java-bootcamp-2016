/**
 * 
 */
package shoppingCart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import business.Client;
import business.Item;
import business.PayCreditCard;
import data.ClientDAO;
import data.ItemDAO;
import data.ShoppingCartDAO;
import shoppingCart.*;

/**
 * @author Brandon
 *//**
 *         This class implements ShoppingOperation, is the API with the methods
 *         that need.
 * 
 */
public class ShoppingCart implements ShoppingOperations {
	private Item productShopping ;
	private List<Item> listItems;
	ShoppingCartDAO shoppingDAO;
	ClientDAO clientDAO;
	ItemDAO itemDAO;
	
	protected ShoppingCart() {
		listItems = new LinkedList<>();
		shoppingDAO = new ShoppingCartDAO();
		clientDAO = new ClientDAO();
		itemDAO = new ItemDAO();
		productShopping = new Item();
	}

	/**
	 * This method add a product in the shoppingCart, is to say the listItems
	 */
	@Override
	public void addItem(String username, int idProduct, int quantity) {
		productShopping = itemDAO.searchItem(idProduct);
		shoppingDAO.addProduct(username, idProduct, quantity);
		productShopping.setQuantity(quantity);
		listItems.add(productShopping);
	}

	/**
	 * This method delete a product in the shoppingCart, is to say delete the
	 * Item in the listItems
	 * 
	 * @param product Is a object of Item
	 */
	@Override
	public int deleteItem(String username, int id) {
		for (int i = 0; i < listItems.size(); i++) {
			if (listItems.get(i).getIdItem() == id) {
				productShopping = listItems.get(i);
				listItems.remove(productShopping);
				shoppingDAO.deleteProduct(username, id);
				return 1;
			}
		}
		
		return 0;

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
			if (listItems.get(i).getIdItem()==id) {
				productShopping = listItems.get(i);
				return productShopping;
			}
		}
		return productShopping;
	}

	/**
	 * This method search a product in the shoppingCart by name, is to say
	 * search in the listItems by name of Item
	 */
	@Override
	public Item searchItemByName(String productName) {
		for (int i = 0; i < listItems.size(); i++) {
			if (listItems.get(i).getNameItem().equals(productName)) {
				productShopping = listItems.get(i);
				return productShopping;
			}
		}
		return productShopping;
	}

	
	/**
	 * This method search a product in the shoppingCart by category, is to say
	 * search in the listItems by category of Item
	 */
	@Override
	public LinkedList<Item> searchItemByCategory(String categoryName) {
		LinkedList<Item> aux = new LinkedList(); 
		for (int i = 0; i < listItems.size(); i++) {
			if (listItems.get(i).getCategory().equals(categoryName)){
			aux.add(listItems.get(i));}
			
			}
		
		return aux;
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
		int total = 0, aux = 0;
		for (int i = 0; i < listItems.size(); i++) {
			aux = listItems.get(i).getQuantity();
			total = total + aux;
			}
		return total;
	}

		@Override
	public void registerUser(Client client) {
		clientDAO.addUser(client);
		
	}

	@Override
	public int loginUser(String username, String password) {
		return clientDAO.loginUser(username, password);
	}
	
	public void buyShoppCart(String username, String payment, PayCreditCard creditCard){
		shoppingDAO.addSale(username, showTotalShoppingCart(), payment);
		shoppingDAO.addCredit(creditCard);
		for(int i=0; i<listItems.size(); i++){
			shoppingDAO.addSaleItem(listItems.get(i).getIdItem(), listItems.get(i).getQuantity());
		}
		listItems.clear();
		shoppingDAO.deleteCart(username);
		
	}
	
	public Item getProduct() {
		return productShopping;
	}

	public void setProduct(Item product) {
		this.productShopping = product;
	}

	public List<Item> getListItems() {
		return listItems;
	}

	public void setListItems(List<Item> listItems) {
		this.listItems = listItems;
	}



}
