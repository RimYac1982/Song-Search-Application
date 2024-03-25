public class Music extends Media {
	private String genre;
	private static String lines = "---------------------------";
	private static String unknown = "unknown";
	private static double unknownDuration = -99.99;
	
	/**
	 * Default zero constructor for class Music, calls upon the 4 
	 * argument constructor to set default values to title
	 * and author and genre and duration
	 */
	public Music() {
		this(unknown, unknown, unknown, unknownDuration);
	}
	
	/**
	 * Default four constructor for the class Music, uses 
	 * String title, String author, String genre, and double duration to 
	 * set values to the variables title, author, genre, and duration.
	 * Also uses super to call the constructor in MEDIA
	 * @param title the title
	 * @param author the author
	 * @param genre the genre
	 * @param duration the duration
	 */
	public Music(String title, String author, String genre, double duration) {
		super(title,author,duration);
		this.genre = genre;
	}
	
	/**
	 * Default two constructor for the class Music, uses the 
	 * parameters String title and String author to set the 
	 * title and author
	 * @param title the title
	 * @param author the author
	 */
	public Music(String title, String author) {
		this.setTitle(title);
		this.setAuthor(author);		
	}
	
	//setter
	/**
	 * This is a setter that will set the genre to whatever the
	 * given string parameter is set to
	 * @param genre the genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	//getter
	/**
	 * This is a getter that return genre
	 * @return genre
	 */
	public String getGenre() {
		return this.genre;
	}
	
	/**
	 * This is a static menu that will display whatever Song we give it 
	 * in a specific format 
	 * @param m a type of Music to display
	 */
	public static void displayMusic(Music m) {
		System.out.print(lines + "\n");
		System.out.println(m.toString());
		System.out.println(lines + "\n");
		System.out.println("returning to main menu...\n\n");
		
	}
	
	/**
	 * toString to print out type Music in a certain way
	 */
	@Override public String toString() {
		return lines + "\nTitle: " + this.getTitle() 
				+"\nAuthor: " + this.getAuthor()
				+"\nGenre: " + this.genre
				+"\nDuration: " + this.getDuration()
				+"\n"+lines;
				
	}
}