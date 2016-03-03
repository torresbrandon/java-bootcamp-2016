package shoppingCart;



public class ServiceShoppingCart {
	private ServiceShoppingCart(){
		
	}

	public static ShoppingOperations getLocalService(){  
        return new ShoppingCart();  
    }  
  
}
