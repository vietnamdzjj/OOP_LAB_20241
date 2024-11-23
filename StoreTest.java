package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.disc.DVDs;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		// Create a new store with a capacity of 5 DVDs
		Store store = new Store(5);

		// Create some DVD objects
		DVDs dvd1 = new DVDs("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DVDs dvd2 = new DVDs("Star Wars", "Science Fiction", "George Lucas", 120, 24.95f);
		DVDs dvd3 = new DVDs("Aladin", "Animation", 18.99f);
		DVDs dvd4 = new DVDs("Frozen", "Animation", "Chris Buck", 102, 22.50f);

		// Test adding DVDs
		store.addDVD(dvd1);
		store.addDVD(dvd2);
		store.addDVD(dvd3);

		// Display the store inventory
		store.displayStore();

		// Test removing a DVD
		store.removeDVD("Star Wars");

		// Display the store inventory again
		store.displayStore();

		// Test adding another DVD
		store.addDVD(dvd4);

		// Display the store inventory again
		store.displayStore();

		// Test removing a non-existent DVD
		store.removeDVD("Non-existent DVD");

		// Test adding DVDs beyond the store's capacity
		DVDs dvd5 = new DVDs("Avatar", "Science Fiction", "James Cameron", 162, 29.99f);
		DVDs dvd6 = new DVDs("Avengers", "Action", "Joss Whedon", 143, 19.99f);

		store.addDVD(dvd5);
		store.addDVD(dvd6); // This should fail since the store has a capacity of 5
	}
}
