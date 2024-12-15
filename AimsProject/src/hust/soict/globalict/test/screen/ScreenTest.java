package hust.soict.globalict.test.screen;
import hust.soict.globalict.aims.*;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.screen.*;

public class ScreenTest {

	public static void main(String[] args) {		
		Track track1 = new Track("Turkish March", 2);
		Track track2 = new Track("Liebestraum", 3);
		Track track3 = new Track("Swan Lake", 5);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(
				"Tarzan", "Animation", "Jafar", 2, 18.25f);
		
		CompactDisc cd1 = new CompactDisc(
				"Classical Melody", "Various Artist", "Classical", 6.5f);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		cd1.addTrack(track3);
		
		Book book1 = new Book("DSA", "Textbook", 15.75f);
		book1.addAuthor("Nguyen Van A");
		Book book2 = new Book("Calculus III", "Textbook", 15.0f);
		book2.addAuthor("Bui Xuan Dieu");
		book2.addAuthor("Dao Tuan Anh");
		
		Store store = new Store();
		store.addMedia(dvd1);
		store.addMedia(cd1);
		store.addMedia(book1);
		store.addMedia(book2);
		
		new StoreScreen(store);
	}

}