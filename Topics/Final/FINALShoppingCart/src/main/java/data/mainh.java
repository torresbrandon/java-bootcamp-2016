package data;

import java.util.Scanner;

import business.Client;
import business.Item;
import business.PayCreditCard;
import shoppingCart.ServiceShoppingCart;
import shoppingCart.ShoppingCart;
import shoppingCart.ShoppingOperations;



public class mainh {

	public static void main (String[]args){
		
		ShoppingCartDAO n = new ShoppingCartDAO();
		ShoppingOperations cart = ServiceShoppingCart.getLocalService();
		ItemDAO i = new ItemDAO();
		ClientDAO client = new ClientDAO();
		PayCreditCard credit = new PayCreditCard();
	//	n.addProduct("brandon@gmail.com", 1, 2);
	//	n.deleteProduct("brandon@gmail.com", 1);
		
	/*	Client nuevo = new Client();
		nuevo.setIdClient(2345);
		nuevo.setNameClient("name");
		nuevo.setLastName("last");
		nuevo.setCity("bog");
		nuevo.setAddress("calle 130 c");
		nuevo.setEmail("nuevo@gmail.com");
		nuevo.setNeighborhood("costa rica");
		nuevo.setPhone(123456);
		nuevo.setPassword("123456");
	
		System.out.println(client.loginUser("brandon@gmail.com", "12312"));
	//	System.out.println(n.addUser(nuevo));
		Item a = new Item();
		a= i.searchItem(2);
		System.out.println("h "+a.getCategory());
		
		System.out.println(n.addSale(12345678, 20000, "efecty"));
		System.out.println(n.addSaleItem(2, 20));*/
		
		cart.addItem("brandon@gmail.com", 1, 12);
		cart.addItem("brandon@gmail.com", 2, 2);
		System.out.println(cart.quantityElements());
		
		credit.setCardType("VISA");
		credit.setIdClient(1234567);
		credit.setNumberCard(122334545);
		credit.setRateNumber(4);
		
	    cart.buyShoppCart("brandon@gmail.com", "creditCard", credit);
		System.out.println(cart.quantityElements());
	}

}
