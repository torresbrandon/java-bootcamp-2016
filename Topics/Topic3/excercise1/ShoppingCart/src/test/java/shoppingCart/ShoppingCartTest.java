/**
 * 
 */
package shoppingCart;

import static org.junit.Assert.*; // Notice the use of "static" here
import org.junit.Before;
import org.junit.Test;

import shoppingCart.*;

/**
 * @author Brandon
 *
 */
public class ShoppingCartTest {
	
	
	@Test
	public void addItemTest() {
		ShoppingCart cart = new ShoppingCart();

		Item newItem = new Item();
		newItem.setIdItem(1);
		newItem.setNameItem("Jacket");
		newItem.setColor("Blue");
		newItem.setQuantity(2);
		newItem.setPriceUnit(150000);
		cart.addItem(newItem);
		assertTrue(cart.getListItems().get(0).getIdItem() == newItem.getIdItem());
	}

	@Test
	public void deleteItemTest() {
		ShoppingCart cart = new ShoppingCart();
		Item newItem = new Item();
		newItem.setIdItem(1);
		newItem.setNameItem("Jacket");
		newItem.setColor("Blue");
		newItem.setQuantity(2);
		newItem.setPriceUnit(150000);
		cart.addItem(newItem);
		cart.deleteItem(newItem);
		assertFalse(cart.getListItems().contains(newItem));
	}

	@Test
	public void searchItemByIdTest() {
		ShoppingCart cart = new ShoppingCart();
		Item newItem = new Item();
		newItem.setIdItem(1);
		newItem.setNameItem("Jacket");
		newItem.setColor("Blue");
		newItem.setQuantity(2);
		newItem.setPriceUnit(150000);
		cart.addItem(newItem);

		assertEquals(cart.searchItemById(newItem.getIdItem()), newItem);

	}

	@Test
	public void SearchItemByNameTest() {
		ShoppingCart cart = new ShoppingCart();
		Item newItem = new Item();
		newItem.setIdItem(1);
		newItem.setNameItem("Jacket");
		newItem.setColor("Blue");
		newItem.setQuantity(2);
		newItem.setPriceUnit(150000);
		cart.addItem(newItem);
		cart.searchItemByName(newItem.getNameItem());
		assertEquals(cart.searchItemByName(newItem.getNameItem()), newItem);
	}

	@Test
	public void modifyColorItemTest() {
		ShoppingCart cart = new ShoppingCart();
		Item newItem = new Item();
		newItem.setIdItem(1);
		newItem.setNameItem("Jacket");
		newItem.setColor("Blue");
		newItem.setQuantity(2);
		newItem.setPriceUnit(150000);
		cart.addItem(newItem);
		String newColor = "Red";
		cart.modifyColorItem(newItem.getIdItem(), newColor);
		assertEquals(cart.getListItems().get(cart.getListItems().indexOf(newItem)).getColor(), newColor);
	}

	@Test
	public void testModifyQuantity() {
		ShoppingCart cart = new ShoppingCart();
		Item newItem = new Item();
		newItem.setIdItem(1);
		newItem.setNameItem("Jacket");
		newItem.setColor("Blue");
		newItem.setQuantity(2);
		newItem.setPriceUnit(150000);
		cart.addItem(newItem);
		int newQuantity = 8;
		cart.modifyQuantityItem(newItem.getIdItem(), newQuantity);
		assertEquals(cart.getListItems().get(cart.getListItems().indexOf(newItem)).getQuantity(), newQuantity);

	}

	@Test
	public void testShowTotalShoppingCart() {
		ShoppingCart cart = new ShoppingCart();
		Item newItem = new Item();
		Item newItem2 = new Item();
		newItem.setIdItem(1);
		newItem.setNameItem("Jacket");
		newItem.setColor("Blue");
		newItem.setQuantity(2);
		newItem.setPriceUnit(150000);
		cart.addItem(newItem);
		newItem2.setIdItem(2);
		newItem2.setNameItem("Pant");
		newItem2.setColor("Black");
		newItem2.setQuantity(3);
		newItem2.setPriceUnit(100000);
		cart.addItem(newItem2);
		int total = (newItem.getPriceUnit() * newItem.getQuantity())
				+ (newItem2.getPriceUnit() * newItem2.getQuantity());

		assertTrue(cart.showTotalShoppingCart() == total);

	}

	@Test
	public void testSizeShoppingCart() {
		ShoppingCart cart = new ShoppingCart();
		Item newItem = new Item();
		Item newItem2 = new Item();
		newItem.setIdItem(1);
		newItem.setNameItem("Jacket");
		newItem.setColor("Blue");
		newItem.setQuantity(2);
		newItem.setPriceUnit(150000);
		cart.addItem(newItem);
		newItem2.setIdItem(2);
		newItem2.setNameItem("Pant");
		newItem2.setColor("Black");
		newItem2.setQuantity(3);
		newItem2.setPriceUnit(100000);
		cart.addItem(newItem2);

		assertTrue(cart.quantityElements() == 2);

	}

}
