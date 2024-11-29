import java.util.*;

public class Aims {

    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner sc = new Scanner(System.in);

    // Show the main menu
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    // Show the store menu
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    // Show media details menu
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    // Show the cart menu
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    // Main method that handles the flow
    public static void main(String[] args) {
        // Initialize sample data
        initializeStore();

        boolean running = true;
        while (running) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    viewStoreMenu();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    viewCartMenu();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    // Initialize some sample data in the store
    private static void initializeStore() {
        // Add some sample media to the store (CompactDisc, DigitalVideoDisc, Book)
        store.addMedia(new CompactDisc("CD1", 20.0f, "Artist1"));
        store.addMedia(new DigitalVideoDisc("DVD1", 15.0f, "Director1", 120));
        store.addMedia(new Book("Book1", 10.0f, "Author1"));
    }

    // View the store and interact with the store menu
    private static void viewStoreMenu() {
        boolean storeMenuRunning = true;
        while (storeMenuRunning) {
            storeMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    viewCartMenu();
                    break;
                case 0:
                    storeMenuRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    // Display details of a media item in the store
    private static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = sc.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            System.out.println(media);
            mediaDetailsMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Added to cart.");
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    // Add media to the cart
    private static void addToCart() {
        System.out.print("Enter media title to add to cart: ");
        String title = sc.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Added to cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    // Play media (if playable)
    private static void playMedia() {
        System.out.print("Enter media title to play: ");
        String title = sc.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media not found or cannot be played.");
        }
    }

    // View the cart and interact with the cart menu
    private static void viewCartMenu() {
        boolean cartMenuRunning = true;
        while (cartMenuRunning) {
            cartMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    filterCart();
                    break;
                case 2:
                    sortCart();
                    break;
                case 3:
                    removeFromCart();
                    break;
                case 4:
                    playMediaInCart();
                    break;
                case 5:
                    placeOrder();
                    cartMenuRunning = false;
                    break;
                case 0:
                    cartMenuRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Filter cart by title or ID
    private static void filterCart() {
        System.out.println("Filter by: 1. Title 2. ID");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                System.out.print("Enter title to filter: ");
                String title = sc.nextLine();
                List<Media> filteredByTitle = cart.filterByTitle(title);
                System.out.println("Filtered Cart: " + filteredByTitle);
                break;
            case 2:
                System.out.print("Enter ID to filter: ");
                String id = sc.nextLine();
                List<Media> filteredById = cart.filterById(id);
                System.out.println("Filtered Cart: " + filteredById);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Sort cart items
    private static void sortCart() {
        System.out.println("Sort by: 1. Title 2. Cost");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                cart.sortByTitle();
                System.out.println("Sorted by Title.");
                break;
            case 2:
                cart.sortByCost();
                System.out.println("Sorted by Cost.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Remove media from the cart
    private static void removeFromCart() {
        System.out.print("Enter title of media to remove: ");
        String title = sc.nextLine();
        if (cart.removeMediaByTitle(title)) {
            System.out.println("Removed from cart.");
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    // Play media from the cart
    private static void playMediaInCart() {
        System.out.print("Enter media title to play from cart: ");
        String title = sc.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media not found or cannot be played.");
        }
    }

    // Place the order (simple notification for now)
    private static void placeOrder() {
        System.out.println("Order placed successfully!");
        cart.clear();
    }

    // Update the store (add/remove media)
    private static void updateStore() {
        System.out.println("Options: ");
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                addMediaToStore();
                break;
            case 2:
                removeMediaFromStore();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Add media to the store
    private static void addMediaToStore() {
        System.out.print("Enter media type (1. CD, 2. DVD, 3. Book): ");
        int type = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter cost: ");
        float cost = sc.nextFloat();
        sc.nextLine(); // Consume newline
        Media media = null;
        switch (type) {
            case 1:
                media = new CompactDisc(title, cost, "Artist");
                break;
            case 2:
                media = new DigitalVideoDisc(title, cost, "Director", 120);
                break;
            case 3:
                media = new Book(title, cost, "Author");
                break;
            default:
                System.out.println("Invalid type.");
                return;
        }
        store.addMedia(media);
        System.out.println("Media added to store.");
    }

    // Remove media from the store
    private static void removeMediaFromStore() {
        System.out.print("Enter title of media to remove: ");
        String title = sc.nextLine();
        if (store.removeMediaByTitle(title)) {
            System.out.println("Media removed from store.");
        } else {
            System.out.println("Media not found in store.");
        }
    }
}
