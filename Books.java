
import java.util.ArrayList;
import java.util.List;
 class Book extends Media {
    private List<String> authors = new ArrayList<>();
    private String author;

    public Book(String title, float cost, String author) {
        this.setTitle(title);   // Set the title inherited from Media class
        this.setCost(cost);     // Set the cost inherited from Media class
        this.author = author;   // Set the author specific to Book
    }
    // Constructor
    public Book() {
        super();
    }

    public Book(String id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    // Methods for adding and removing authors
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author " + authorName + " added.");
        } else {
            System.out.println("Author " + authorName + " is already in the list.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author " + authorName + " removed.");
        } else {
            System.out.println("Author " + authorName + " is not in the list.");
        }
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return super.toString() + ", authors=" + authors;
    }
}
