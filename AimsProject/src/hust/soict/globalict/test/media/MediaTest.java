package hust.soict.globalict.test.media;

import hust.soict.globalict.aims.media.*;
import java.util.*;

public class MediaTest {
	
	public static void CompactDiscTest() {
		CompactDisc disc = new CompactDisc("liebestraum", "fish");
		Track a = new Track("a", 1);
		Track b = new Track("b", 2);
		Track c = new Track("c", 3);
		
		System.out.println(disc.getArtist());
		
		disc.addTrack(a);
		disc.addTrack(b);
		disc.addTrack(c);
		disc.addTrack(c);
		disc.removeTrack(a);
		disc.removeTrack(a);
		
		System.out.println(disc.getLength());
		
		disc.play();
	}
	
	public static void BookTest() {
		Book book = new Book("data structures and algorithms");
		
		book.addAuthor("a");
		book.addAuthor("b");
		book.addAuthor("c");
		book.addAuthor("c");
		book.removeAuthor("a");
		book.removeAuthor("a");
	}
	
	public static void DVDTest() {
		DigitalVideoDisc dvd1 = 
				new DigitalVideoDisc(
						"The Lion King", 
						"Animation", 
						"Roger Allers", 
						87,
						19.95f);
		System.out.println("dvd1 = " + dvd1.getId());
		
		DigitalVideoDisc dvd2 = 
				new DigitalVideoDisc(
						"Star Wars", 
						"Science Fiction", 
						"George Lucas", 
						87,
						24.95f);
		System.out.println("dvd2 = " + dvd2.getId());
		
		DigitalVideoDisc dvd3 = 
				new DigitalVideoDisc(
						"Aladin", 
						"Animation", 
						18.99f);
		System.out.println("dvd3 = " + dvd3.getId());
	}
	
	public static void MediaEqualityTest() {
		DigitalVideoDisc dvd1 = 
				new DigitalVideoDisc(
						"Star Wars", 
						"Science Fiction", 
						"George Lucas", 
						87,
						24.95f);
		DigitalVideoDisc dvd2 = 
				new DigitalVideoDisc(
						"Aladin", 
						"Animation", 
						18.99f);
		Book book = new Book("Aladin");
		String s = "Aladin";
		Track track1 = new Track("Aladin", 1);
		Track track2 = new Track("Aladin", 1);
		if (dvd1.equals(book))
			System.out.println("dvd1 == book");
		if (book.equals(dvd1))
			System.out.println("book == dvd1");
		if (dvd2.equals(book))
			System.out.println("dvd2 == book");
		if (book.equals(dvd2))
			System.out.println("book == dvd2");
		if (book.equals(s))
			System.out.println("book == s");
		if (track1.equals(book))
			System.out.println("track1 == book");
		if (book.equals(track1))
			System.out.println("book == track1");
		if (track1.equals(track2))
			System.out.println("track1 == track2");
	}
	
	public static void MediaToString() {
		List<Media> mediae = new ArrayList<Media>();
		
		Track track1 = new Track("Track A", 1);
		Track track2 = new Track("Track B", 2);
		CompactDisc cd = 
				new CompactDisc(
						"Liebestraum", 
						"Liszt", 
						"Classical", 
						24.95f);
		cd.addTrack(track1);
		cd.addTrack(track2);
		DigitalVideoDisc dvd = 
				new DigitalVideoDisc(
						"Star Wars", 
						"Science Fiction", 
						"George Lucas", 
						87,
						24.95f);
		Book book = new Book(
				"Data structures and algorithms", 
				"Textbook",
				10.05f);
		book.addAuthor("Nguyen Van A");
		book.addAuthor("Tran Thi B");
		book.addAuthor("Le Van C");
		
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		
		for (Media m : mediae) {
			System.out.println(m.toString());
		}
	}

	public static void main(String[] args) {
//		CompactDiscTest();
//		BookTest();
//		DVDTest();
//		MediaEqualityTest();
		MediaToString();
	}

}