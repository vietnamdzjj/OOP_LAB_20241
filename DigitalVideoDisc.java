
public class DigitalVideoDisc extends Media implements Playable {
    private String director;
    private int length;

    public DigitalVideoDisc(String title, float cost, String director, int length) {
        this.setTitle(title);   // Set the title inherited from Media class
        this.setCost(cost);     // Set the cost inherited from Media class
        this.director = director;  // Set the director specific to DigitalVideoDisc
        this.length = length;      // Set the length specific to DigitalVideoDisc
    }
    // Constructor
    public DigitalVideoDisc() {
        super();
    }

    public DigitalVideoDisc(String id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    // Getter and Setter for 'director'
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Getter and Setter for 'length'
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Implement the play() method
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength() + " minutes");
    }

    @Override
    public String toString() {
        return super.toString() + ", director=" + director + ", length=" + length;
    }
}
