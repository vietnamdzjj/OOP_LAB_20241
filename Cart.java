
public class Cart {
public static final int MAX_NUMBERS_ORDERED = 20; 
private DVDs itemsOrdered[] = new DVDs [MAX_NUMBERS_ORDERED]; 
private int qtyOrdered = 0;

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