
import java.util.ArrayList;
public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    // Constructor
    public Store() {
    }

    // Add a media item to the store
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println(media.getTitle() + " has been added to the store.");
        } else {
            System.out.println(media.getTitle() + " is already in the store.");
        }
    }

    // Remove a media item from the store
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println(media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println(media.getTitle() + " is not in the store.");
        }
    }
    public Media findMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;  // Return null if no media with the given title is found
    }
    
    public boolean removeMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {  // Compare titles ignoring case
            	itemsInStore.remove(media);  // Remove the media from the list
                return true;  // Return true if media was successfully removed
            }
        }
        return false;  // Return false if no media was found with the given title
    }

    // Print the contents of the store
    public void printStore() {
        System.out.println("Store contents:");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
            return;
        }
        for (int i = 0; i < itemsInStore.size(); i++) {
            Media media = itemsInStore.get(i);
            System.out.println((i + 1) + ". " + media.toString());
        }
    }
}
