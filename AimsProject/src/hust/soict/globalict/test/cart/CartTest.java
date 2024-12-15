package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.*;

public class CartTest {

	public static void main(String[] args) {
		//Create a new class
		Cart cart = new Cart();
		
		//Create new dvd objects and add them to the cart
		Media dvd1 = new DigitalVideoDisc(
						"The Lion King", 
						"Animation", 
						"Roger Allers", 
						87,
						19.95f);
		cart.addMedia(dvd1);
		
		Media dvd2 = new DigitalVideoDisc(
						"Star Wars", 
						"Science Fiction", 
						"George Lucas", 
						87,
						24.95f);
		cart.addMedia(dvd2);
		
		Media dvd3 = new DigitalVideoDisc(
						"Aladin", 
						"Animation", 
						18.99f);
		cart.addMedia(dvd3);
		
		//Test the print method
		cart.print();
		
		cart.searchById("2");
		cart.searchByTitle("Aladin");
		cart.searchByTitle("Zoo");
		
	}

}