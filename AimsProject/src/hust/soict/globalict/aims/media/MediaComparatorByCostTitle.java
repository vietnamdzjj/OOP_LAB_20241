package hust.soict.globalict.aims.media;
import java.util.*;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	public int compare(Media o1, Media o2) {
		if (o1.getCost() != o2.getCost())
			return o1.getCost() > o2.getCost() ? -1 : 1;
		return o1.getTitle().compareTo(o2.getTitle());
	}
	
}