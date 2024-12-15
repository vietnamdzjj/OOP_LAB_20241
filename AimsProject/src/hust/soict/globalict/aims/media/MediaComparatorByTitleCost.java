package hust.soict.globalict.aims.media;
import java.util.*;

public class MediaComparatorByTitleCost implements Comparator<Media>{
	public int compare(Media o1, Media o2) {
		int res = o1.getTitle().compareTo(o2.getTitle());
		if (res != 0)
			return res;
		if (o1.getCost() == o2.getCost())
			return 0;
		return o1.getCost() > o2.getCost() ? -1 : 1;
	}

}