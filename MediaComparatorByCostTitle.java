import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // First compare by title
        int titleComparison = m1.getTitle().compareTo(m2.getTitle());
        
        // If titles are equal, then compare by cost in descending order
        if (titleComparison == 0) {
            return Float.compare(m2.getCost(), m1.getCost());
        }
        
        return titleComparison;
    }
}
