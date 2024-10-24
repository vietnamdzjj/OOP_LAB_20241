public class Aims {
public static void main(String[] args) {
Cart anOrder = new Cart();
DVDs dvd1 = new DVDs("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
anOrder.addDigitalVideoDisc (dvd1);
DVDs dvd2 = new DVDs("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f); 
anOrder.addDigitalVideoDisc (dvd2);
DVDs dvd3= new DVDs("Aladin", "Animation", 18.99f);
anOrder.addDigitalVideoDisc (dvd3);
System.out.println("Total Cost is: ");
System.out.println(anOrder.totalCost());

anOrder.removeDigitalVideoDisc(dvd2);
System.out.println("Total cost after removing Movie 2: " + anOrder.totalCost());
System.out.println("\nTrying to remove a disc that is not in the cart...");
anOrder.removeDigitalVideoDisc(dvd2); 
System.out.println("\nRemoving another disc from the cart...");
anOrder.removeDigitalVideoDisc(dvd1);
System.out.println("Total cost after removing Movie 1: " + anOrder.totalCost());
}
}
