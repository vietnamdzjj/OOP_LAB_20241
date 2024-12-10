import hust.soict.dsai.aims.media.DVDs;

public class TestPassingParameter {
	public static void main(String[] args) {
		DVDs jungleDVD = new DVDs("Jungle");
		DVDs cinderellaDVD = new DVDs("Cinderella");
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}

	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = 02;
		o2 = tmp;
	}

	public static void changeTitle(DVDs dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DVDs(oldTitle);
	}

}
