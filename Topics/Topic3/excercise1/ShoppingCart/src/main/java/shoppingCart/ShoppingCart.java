/**
 * 
 */
package shoppingCart;

import java.util.ArrayList;
import java.util.LinkedList;

import shoppingCart.*;

/**
 * @author Brandon
 *
 */
public class ShoppingCart implements ShoppingOperations {
	private Item product = new Item();
	private LinkedList<Item>  listItems = new LinkedList();
	
	protected ShoppingCart(){}
	
	@Override
	public void addItem(Item product) {
		listItems.add(product);
		
	}

	@Override
	public void deleteItem(Item product) {
		listItems.remove(product);
		
	}

	@Override
	public Item searchItemById(int id) {
		for(int i=0; i <listItems.size();i++){
			if(	listItems.get(i).getIdItem()==id){
				product=listItems.get(i);
				return product;}
		}	
			return null;
	}

	@Override
	public Item searchItemByName(String productName) {
		for(int i=0; i <listItems.size();i++){
			if(	listItems.get(i).getNameItem()==productName){
				product=listItems.get(i);
				return product;}
		}	
			return null;
	}


	@Override
	public void modifyColorItem(int id, String newColor) {
		for(int i=0; i <listItems.size();i++){
			if(	listItems.get(i).getIdItem()==id){
				listItems.get(i).setColor(newColor);
				}
		}	
			
	}

	@Override
	public void modifyQuantityItem(int id, int newQuantity) {
		for(int i=0; i <listItems.size();i++){
			if(	listItems.get(i).getIdItem()==id){
				listItems.get(i).setQuantity(newQuantity);
				}
		}
	}

	@Override
	public int showTotalShoppingCart() {
		int total=0, aux =0;
		for(int i=0; i <listItems.size();i++){
			aux = listItems.get(i).getPriceUnit()*listItems.get(i).getQuantity();
			total = total+aux;
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
