import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // First compare by cost in descending order
        int costComparison = Float.compare(m2.getCost(), m1.getCost());
        
        // If costs are equal, then compare by title
        if (costComparison == 0) {
            return m1.getTitle().compareTo(m2.getTitle());
        }
        
        return costComparison;
    }
}
