package hust.soict.dsai.test.cart.CartTest;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DVDs;

public class CartTest {
	public static void main(String[] args) {
		// Create a new cart
		Cart cart = new Cart();

		// Create new DVD objects and add them to the cart
		DVDs dvd1 = new DVDs("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);

		DVDs dvd2 = new DVDs("Star Wars", "Science Fiction", "George Lucas", 120, 24.95f);
		cart.addDigitalVideoDisc(dvd2);

		DVDs dvd3 = new DVDs("Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);

		// Print the cart
		cart.printCart();

		// Search for DVD by ID
		DVDs foundById = cart.searchById(2);
		if (foundById != null) {
			System.out.println("Found by ID: " + foundById.toString());
		}

		// Search for DVDs by title
		ArrayList<DVDs> foundByTitle = cart.searchByTitle("Star");
		if (!foundByTitle.isEmpty()) {
			System.out.println("Found by title:");
			for (DVDs disc : foundByTitle) {
				System.out.println(disc.toString());
			}
		}

		// Search for a non-existing title
		cart.searchByTitle("Unknown Title");
	}
}
