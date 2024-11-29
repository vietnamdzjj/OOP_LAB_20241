
public class Track implements Playable {
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter and Setter for 'title'
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength() + " minutes");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // Check if both references point to the same object
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) { // Check null or mismatched class
            return false;
        }
        Track track = (Track) obj; // Cast the object to Track
        return this.title != null && this.title.equals(track.title) && this.length == track.length; // Compare title and length
    }

    @Override
    public String toString() {
        return "Track [title=" + title + ", length=" + length + "]";
    }
}
