package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.media.*;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.math.*;
import java.util.*;
import java.util.function.Predicate;

public class Cart {
	private static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = 
			FXCollections.observableArrayList();
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public double getTotalCost() {
		double totalCost = 0;
		for (Media media : this.itemsOrdered) 
			totalCost += media.getCost();
		return totalCost;
	}
	
	public String getTotalCostToString() {
		return Double.toString(Math.round(this.getTotalCost() * 100) / 100.0);
	}

	public void addMedia(Media media) {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full");
			return;
		}
		
		itemsOrdered.add(media);
		System.out.println("\"" + media.getTitle() + "\" has been added.");
	}
	
	public void addMedia(Media[] mediaList) {
		for (Media media : mediaList) 
			addMedia(media);
	}
	
	public void addMedia(Media media1, Media media2) {
		addMedia(media1);
		addMedia(media2);
	}
	
	public void removeMedia(Media media) {
		for (Media item : itemsOrdered)
			if (item.equals(media)) {
				itemsOrdered.remove(media);
				System.out.println("\"" + media.getTitle() + "\" has been removed.");
				return;
			}
		System.out.println("\"" + media.getTitle() + "\" is not found");
	}
	
	public void clear() {
		this.itemsOrdered.clear();
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		
		int i = 0;
		for (Media media : itemsOrdered) {
			i += 1;
			System.out.println(i + ". " + media.toString());
		}
		
		System.out.println("Total cost: " + getTotalCost() + " $");
		System.out.println("**************************************************");
	}

	public ObservableList<Media> searchById(String id) {
		ObservableList<Media> res = FXCollections.observableArrayList();
			
		if (id == "") {
			res.addAll(itemsOrdered);
			return res;
		}
		
		int cnt = 0;
		for (Media media : itemsOrdered)
			if (media.isMatchById(id)) {
				cnt += 1;
				System.out.println(cnt + ". " + media.toString());
				res.add(media);
			}
		if (cnt == 0)
			System.out.println("No result found!");
		
		return res;
	}
	
	public ObservableList<Media> searchByTitle(String title) {
		ObservableList<Media> res = FXCollections.observableArrayList();
		
		if (title == "") {
			res.addAll(itemsOrdered);
			return res;
		}
			
		int cnt = 0;
		for (Media media : itemsOrdered)
			if (media.isMatchByTitle(title)) {
				cnt += 1;
				System.out.println(cnt + ". " + media.toString());
				res.add(media);
			}
		if (cnt == 0)
			System.out.println("No result found!");
		
		return res;
	}
	
	public void sortByTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	
	public void sortByCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	
}