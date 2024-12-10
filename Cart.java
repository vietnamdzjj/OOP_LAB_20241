import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();
    public static void main(String[] args) {
        // Create some sample Media objects (CompactDisc, DigitalVideoDisc, Book)
        Media cd = new CompactDisc("Thriller", 19.99f, "Michael Jackson");
        Media dvd = new DigitalVideoDisc("Inception", 14.99f, "Christopher Nolan", 148);
        Media book = new Book("The Great Gatsby", 10.99f, "F. Scott Fitzgerald");

        // Create a list of Media objects
        List<Media> mediaList = new ArrayList<>();
        mediaList.add(cd);
        mediaList.add(dvd);
        mediaList.add(book);
        
        // Sort by title, then by cost (if titles are the same)
        Collections.sort(mediaList, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Sorted by title, then cost:");
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }

        // Sort by cost, then by title (if costs are the same)
        Collections.sort(mediaList, Media.COMPARE_BY_COST_TITLE);
        System.out.println("\nSorted by cost, then title:");
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
    // Constructor
    public Cart() {
    }

    // Add a media item to the cart
    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added to the cart.");
        } else {
            System.out.println(media.getTitle() + " is already in the cart.");
        }
    }

    // Remove a media item from the cart
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
        }
    }
    public boolean removeMediaByTitle(String title) {
        // Loop through the items and find the one with the matching title
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            if (media.getTitle().equalsIgnoreCase(title)) {
                itemsOrdered.remove(i); // Remove the media from the list
                System.out.println("Media with title '" + title + "' has been removed.");
                 // Exit the method once the media is removed
            }
        }

        // If the media with the given title is not found, print a message
        System.out.println("No media found with title '" + title + "'.");
        return true;
    }

    public Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {  // Compare titles, ignoring case
                return media;  // Return the media if the title matches
            }
        }
        return null;  // Return null if no media with the given title was found
    }
    
    public List<Media> filterByTitle(String title) {
        // Use Java Stream API to filter the list based on title
        return itemsOrdered.stream()
                .filter(media -> media.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }
    public List<Media> filterById(String id) {
        // Use Java Stream API to filter the list based on id
        return itemsOrdered.stream()
                .filter(media -> media.getId().equalsIgnoreCase(id))  // Assuming getId() method in Media class
                .collect(Collectors.toList());
    }
    public void sortByTitle() {
        Collections.sort(itemsOrdered, new MediaComparatorByTitleCost());
    }
    public void sortByCost() {
        Collections.sort(itemsOrdered, new MediaComparatorByCostTitle());
    }
    // Calculate the total cost of items in the cart
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
    public void clear() {
        itemsOrdered.clear();  // This will remove all items from the cart
    }
    // Print the contents of the cart
    public void printCart() {
        System.out.println("Cart contents:");
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
            return;
        }
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            System.out.println((i + 1) + ". " + media.toString());
        }
        System.out.println("Total cost: " + totalCost());
    }
}
