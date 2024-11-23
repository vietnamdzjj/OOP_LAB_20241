package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private int qtyOrdered = 0;

	private ArrayList<DVDs> itemsOrder = new ArrayList<>();
	private DVDs itemsOrdered[] = new DVDs[MAX_NUMBERS_ORDERED];

	public void printCart() {
		System.out.println("**CART**");
		float totalCost = 0;
		for (int i = 0; i < itemsOrder.size(); i++) {
			DVDs disc = itemsOrder.get(i);
			System.out.println((i + 1) + ". " + disc.toString());
			totalCost += disc.getCost();
		}
		System.out.println("Total cost: " + totalCost + " $");
		System.out.println("***");
	}

// Search for DVDs by ID
	public DVDs searchById(int id) {
		for (DVDs disc : itemsOrder) {
			if (disc.getId() == id) {
				return disc;
			}
		}
		System.out.println("No match found for ID: " + id);
		return null;
	}

// Search for DVDs by title
	public ArrayList<DVDs> searchByTitle(String title) {
		ArrayList<DVDs> results = new ArrayList<>();
		for (DVDs disc : itemsOrder) {
			if (disc.isMatch(title)) {
				results.add(disc);
			}
		}
		if (results.isEmpty()) {
			System.out.println("No match found for title: " + title);
		}
		return results;
	}

	public void addDigitalVideoDisc(DVDs disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
			if (qtyOrdered == MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is full.");
			}
		} else {
			System.out.println("The cart is already full.");
		}
	}

	public void addDigitalVideoDisc(DVDs[] dvdList) {
		for (DVDs dvd : dvdList) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = dvd;
				qtyOrdered++;
				System.out.println("The disc \"" + dvd.getTitle() + "\" has been added.");
			} else {
				System.out.println("The cart is full. Cannot add more discs.");
				break;
			}
		}
	}

	public void addDigitalVideoDisc(DVDs dvd1, DVDs dvd2) {
		if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			System.out.println("The disc \"" + dvd1.getTitle() + "\" has been added.");

			itemsOrdered[qtyOrdered] = dvd2;
			qtyOrdered++;
			System.out.println("The disc \"" + dvd2.getTitle() + "\" has been added.");
		} else if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			System.out.println("The disc \"" + dvd1.getTitle() + "\" has been added.");
			System.out.println("The cart is full. Cannot add the second disc.");
		} else {
			System.out.println("The cart is full. Cannot add any more discs.");
		}
	}

	public void removeDigitalVideoDisc(DVDs disc) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].equals(disc)) {
				found = true;
				for (int j = i; j < qtyOrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j + 1];
				}
				itemsOrdered[qtyOrdered - 1] = null; // Remove last element
				qtyOrdered--;
				System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
				break;
			}
		}
		if (!found) {
			System.out.println("The disc \"" + disc.getTitle() + "\" was not found in the cart.");
		}
	}

	public double totalCost() {
		double total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}

}