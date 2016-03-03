/**
 * 
 */
package shoppingCart;

/**
 * @author Brandon
 *
 */

public interface ShoppingOperations {
	
	
	/*
	 * This method add a Item in shopping cart
	 */
	  public void addItem(Item product);
	  

		/*
		 * This method delete a Item in shopping cart
		 */
	   public void deleteItem(Item product);  
	   

		/*
		 * This method search a Item by Id in shopping cart
		 */
	   public Item searchItemById(int id);
	   
	   /*
		 * This method search a Item by Name in shopping cart
		 */
	   public Item searchItemByName(String productName);
	   
	   /*
		 * This method modify a ColorItem by Id in shopping cart
		 */
	   public void modifyColorItem(int id, String newColor);
	   
	   /*
		 * This method search a Quantity of a Item by Id in shopping cart
		 */
	   public void modifyQuantityItem(int id, int newQuantity);
	   
	   /*
		 * This method show the total of shopping cart
		 */
	   public int showTotalShoppingCart();
	   
	   /*
		 * This method show the quantity of elements on shopping cart
		 */
	   public int quantityElements();
	   
	   
	   
}
