
import java.util.ArrayList;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();
    public CompactDisc(String title, float cost, String artist) {
        this.setTitle(title);  // Set the title inherited from Media class
        this.setCost(cost);    // Set the cost inherited from Media class
        this.artist = artist;  // Set the artist specific to CompactDisc
    }
    // Constructor
    public CompactDisc() {
        super();
    }
    public CompactDisc(String id, String title, String category, float cost, String artist) {
        super(id, title, category, cost);
        this.artist = artist;
    }

    // Getter and Setter for 'artist'
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Add track
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added: " + track.getTitle());
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    // Remove track
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    // Get the total length of all tracks
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Implement the play() method
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("Total CD length: " + this.getLength() + " minutes");
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", artist=" + artist + ", number of tracks=" + tracks.size();
    }
}
