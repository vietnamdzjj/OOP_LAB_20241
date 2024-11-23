package hust.soict.dsai.aims.disc;

public class DVDs {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private int id;
	private static int nbDVDs = 0;

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	public float getCost() {
		return cost;
	}

	public int getId() {
		return id;
	}

	public static int getNbDVDs() {
		return nbDVDs;
	}

	public DVDs(String title) {
		super();
		this.title = title;
	}

	public DVDs(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public DVDs(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}

	public DVDs(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}

	public void setTitle(String title2) {
		// TODO Auto-generated method stub

	}

	public boolean isMatch(String title) {
		return this.title.toLowerCase().contains(title.toLowerCase());
	}

	// toString method for DVD details
	@Override
	public String toString() {
		return "DVD - " + title + " - " + category + " - " + director + " - " + length + " mins: " + cost + " $";
	}

	public DVDs(String title, String category, String director, int length, float cost, int id) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;

		// Increment the total number of DVDs created and assign a unique ID
		nbDVDs++;
		this.id = nbDVDs++;
	}
}