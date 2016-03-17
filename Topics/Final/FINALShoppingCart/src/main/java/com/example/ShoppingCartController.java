package com.example;


import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wordnik.swagger.annotations.*;

import business.Client;
import business.Item;
import business.PayCreditCard;
import shoppingCart.ShoppingCart;
import shoppingCart.ShoppingOperations;
import shoppingCart.ServiceShoppingCart;

@RestController
public class ShoppingCartController {

    private static final String template = "Hello, %s!";
    private static final String template2 = "Bye, %s!";
    private final AtomicLong counter = new AtomicLong();
    ShoppingOperations shoppingCart;
    Item item;
    Client client;
    PayCreditCard creditCard;
    
    public ShoppingCartController(){
    	shoppingCart=  ServiceShoppingCart.getLocalService();
    	client = new Client();
    	creditCard = new PayCreditCard();
    }

    @RequestMapping(value="/{username}/addItem" , method=RequestMethod.POST)
    public String addItem( @PathVariable String username,
    		@RequestParam(value="idProduct", required = true) int idProduct,
    		@RequestParam(value="quantity", required = true) int quantity) {
    System.out.println("g "+username);
    	shoppingCart.addItem(username, idProduct, quantity);
    	return "Producto adicionado "+idProduct;
       
        
    }
    
    @RequestMapping("/{username}/deleteItem")
    public int deleteItem(@PathVariable String username,
    		@RequestParam(value="id", defaultValue="0", required = true) int id) {
    	return shoppingCart.deleteItem(username, id);
    }
    
    @RequestMapping("/{username}/searchCategory")
    public LinkedList<Item> searchCategoryItem(@RequestParam(value="categoryName", required = true) String categoryName)
    	 {
    	return shoppingCart.searchItemByCategory(categoryName);
    }
    
    @RequestMapping("/{username}/searchIdItem")
    public Item searchItembyId(@RequestParam(value="id", defaultValue="0", required = true) int id) {
    	return shoppingCart.searchItemById(id);
    }
    
    @RequestMapping("/{username}/searchNameItem")
    public Item searchItembyName(@RequestParam(value="name",  required = true) String name) {
    	return shoppingCart.searchItemByName(name);
    }
    
    @RequestMapping("/{username}/total")
    public int showTotalShoppingCart() {
    	return shoppingCart.showTotalShoppingCart();
    }
    
    @RequestMapping("/{username}/size")
    public int sizeShoppingCart() {
    	return shoppingCart.quantityElements();
    }
    
    @RequestMapping(value="/shoppCart/login", method=RequestMethod.POST)
    public int login(@RequestParam(value="username", required = true) String username,
    		@RequestParam(value="password", required = true) String password)
    	 {
    	return shoppingCart.loginUser(username, password);
    }
    
    @RequestMapping(value="/shoppCart/register", method=RequestMethod.POST)
    public String registerUser(@RequestParam(value="username", required = true) int id,
    		@RequestParam(value="name", required = true) String name,
	@RequestParam(value="lname", required = true) String lname,
@RequestParam(value="city", required = true) String city,
@RequestParam(value="neigh", required = true) String neighborhood,
@RequestParam(value="addre", required = true) String addres,
@RequestParam(value="phon", required = true) int phone,
@RequestParam(value="email", required = true) String email,
@RequestParam(value="username", required = true) String username,
@RequestParam(value="pasw", required = true) String password)

    	 {
    	client.setIdClient(id);
    	client.setNameClient(name);
    	client.setLastName(lname);
    	client.setCity(city);
    	client.setNeighborhood(neighborhood);
    	client.setAddress(addres);
    	client.setPhone(phone);
    	client.setEmail(email);
    	client.setUsername(username);
    	client.setPassword(password);
    	shoppingCart.registerUser(client);
    	String aux = "Client registered with id "+client.getIdClient();
    	return aux;
    }
    
    @RequestMapping(value="/{username}/buy", method=RequestMethod.POST)
    public String buyShopCart(@PathVariable String username,
    		@RequestParam(value="payForm", required = true) String payForm,
    		@RequestParam(value="cardType", required = true) String cardType,
	@RequestParam(value="idClient", required = true) int idClient,
@RequestParam(value="numberCard", required = true) int numberCard,
@RequestParam(value="rateNumber", required = true) int rateNumber)

    	 {
    	
    	creditCard.setCardType(cardType);
    	creditCard.setIdClient(idClient);
    	creditCard.setNumberCard(numberCard);
		creditCard.setRateNumber(rateNumber);
    	shoppingCart.buyShoppCart(username, payForm, creditCard);
    	String aux = "Sale realized! ";
    	return aux;
    }
    
}