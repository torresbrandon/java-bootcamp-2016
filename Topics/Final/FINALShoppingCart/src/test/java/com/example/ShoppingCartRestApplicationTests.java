package com.example;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import business.Item;
import shoppingCart.ServiceShoppingCart;
import shoppingCart.ShoppingCart;
import shoppingCart.ShoppingOperations;





@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ShoppingCartRestApplication.class)
public class ShoppingCartRestApplicationTests {

	Item newItem, newItem2;
	ShoppingCart cart;
	@Test
	public void contextLoads() {
	}
	
	@Before
    public void setUp() {
		 cart= ServiceShoppingCart.getLocalService();

		newItem = new Item();
		newItem.setIdItem(1);
		newItem.setNameItem("Jacket");
		newItem.setColor("Blue");
		newItem.setQuantity(2);
		newItem.setPriceUnit(150000);
		
		newItem2 = new Item();
		newItem2.setIdItem(2);
		newItem2.setNameItem("Jacket");
		newItem2.setColor("Gray");
		newItem2.setQuantity(3);
		newItem2.setPriceUnit(120000);
    }
	/**
	 * This method compare if a item was add in the list
	 */
	@Test
	public void addItemTest() {
		
		cart.addItem("brandon", 1, 3);
		assertTrue(cart.getListItems().get(0).getIdItem() == newItem.getIdItem());
	}

	/**
	 * This method compare if a item was deleted in the list
	 */
	@Test
	public void deleteItemTest() {
		
		cart.addItem("brandon", 1, 3);
		cart.deleteItem("branodn", 1);
		assertFalse(cart.getListItems().contains(newItem));
	}

	/**
	 * This method compare if the item that was add, is find by id in the list
	 */
	@Test
	public void searchItemByIdTest() {
		
		cart.addItem("brandon", 1, 3);

		assertEquals(cart.searchItemById(newItem.getIdItem()), newItem);

	}
	
	/**
	 * This method compare if the item that was add, is find by name in tthe list
	 */
	@Test
	public void SearchItemByNameTest() {
		cart.addItem("brandon", 1, 3);
		cart.searchItemByName(newItem.getNameItem());
		assertEquals(cart.searchItemByName(newItem.getNameItem()), newItem);
	}





	/**
	 * This method shows the total of shopping cart
	 */
	@Test
	public void testShowTotalShoppingCart() {
		cart.addItem("brandon", 1, 3);
		cart.addItem("brandon", 2, 3);
		int total = (newItem.getPriceUnit() * newItem.getQuantity())
				+ (newItem2.getPriceUnit() * newItem2.getQuantity());

		assertTrue(cart.showTotalShoppingCart() == total);

	}

	/**
	 * This method compare the size of the list with the elements that was add
	 */
	@Test
	public void testSizeShoppingCart() {
		cart.addItem("brandon", 1, 3);
		cart.addItem("brandon", 2, 3);
		assertTrue(cart.quantityElements() == 6);

	}

}
