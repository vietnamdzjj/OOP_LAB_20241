package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DVDs;

public class Store {
	private DVDs[] itemsInStore; // Array to hold DVDs
	private int currentCount; // To track the current number of DVDs in the store

	// Constructor
	public Store(int capacity) {
		itemsInStore = new DVDs[capacity]; // Initialize the array with the given capacity
		currentCount = 0; // Initially, no DVDs in the store
	}

	// Add a DVD to the store
	public void addDVD(DVDs dvd) {
		if (currentCount < itemsInStore.length) {
			itemsInStore[currentCount] = dvd; // Add DVD at the current position
			currentCount++;
			System.out.println("The DVD \"" + dvd.getTitle() + "\" has been added to the store.");
		} else {
			System.out.println("The store is full! Cannot add more DVDs.");
		}
	}

	// Remove a DVD from the store
	public void removeDVD(String title) {
		boolean found = false;
		for (int i = 0; i < currentCount; i++) {
			if (itemsInStore[i].getTitle().equalsIgnoreCase(title)) {
				found = true;
				System.out.println("The DVD \"" + itemsInStore[i].getTitle() + "\" has been removed from the store.");
				// Shift the remaining DVDs to fill the gap
				for (int j = i; j < currentCount - 1; j++) {
					itemsInStore[j] = itemsInStore[j + 1];
				}
				itemsInStore[currentCount - 1] = null; // Remove the last duplicate
				currentCount--;
				break;
			}
		}
		if (!found) {
			System.out.println("The DVD \"" + title + "\" was not found in the store.");
		}
	}

	// Display all DVDs in the store
	public void displayStore() {
		System.out.println("** STORE INVENTORY **");
		for (int i = 0; i < currentCount; i++) {
			System.out.println((i + 1) + ". " + itemsInStore[i].toString());
		}
		if (currentCount == 0) {
			System.out.println("The store is currently empty.");
		}
		System.out.println("**********************");
	}
}
