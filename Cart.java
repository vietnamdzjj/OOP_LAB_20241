
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == 20) {
			System.out.println("The cart is almost full");
			return;
		}
		
		itemsOrdered[qtyOrdered] = disc;
		qtyOrdered += 1;
		
		System.out.println("The disc has been added");
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		int n = dvdList.length;
		
		if (qtyOrdered + n > 20) {
			System.out.println("The cart is almost full");
			return;
		}
		
		for (int i = 0; i < n; ++i, ++qtyOrdered)
			itemsOrdered[qtyOrdered] = dvdList[i];
		
		System.out.println(n + " discs has been added");
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered >= 19) {
			System.out.println("The cart is almost full");
			return;
		}
		
		itemsOrdered[qtyOrdered] = dvd1;
		itemsOrdered[qtyOrdered + 1] = dvd2;
		qtyOrdered += 2;
		
		System.out.println("2 discs has been added");
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; ++i)
			if (itemsOrdered[i] == disc) {
				for (int j = i; j < qtyOrdered - 1; ++j)
					itemsOrdered[i] = itemsOrdered[i + 1];
				
				qtyOrdered -= 1;
				System.out.println("The disc has been removed");
				return;
			}
		
		System.out.println("Disc not found!");
	}
	
	public float totalCost() {
		float total_cost = 0;
		for (int i = 0; i < qtyOrdered; ++i) 
			total_cost += itemsOrdered[i].getCost();
		return total_cost;
	}
}