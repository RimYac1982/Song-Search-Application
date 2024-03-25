import java.util.ArrayList;

public class Queue extends Music {
	private String songName;
	private String author;
	private ArrayList<Queue> queue = new ArrayList<Queue>();
	
	/**
	 * Default zero constructor for class Queue, calls upon the 2
	 * argument constructor to set default values to songName and author
	 */
	public Queue() {
		this("Song unknown", "unknown Artist");
	}
	
	/**
	 * Default two constructor for the class Queue, uses 
	 * String songName and String author to 
	 * set values to the variables songName and author.
	 * @param songName
	 * @param author
	 */
	public Queue(String songName, String author) {
		this.songName = songName;
		this.author = author;
	}

	
	// MUTATORS
	/**
	 * This method sets songName to whatever the given String parameter is 
	 * @param songName the song name
	 */
	public void setsName(String songName) {
		this.songName = songName;
	}
	
	/**
	 * This method sets the author to whatever the given String paremeter is 
	 * @param author the author
	 */
	public void setauthor(String author) {
		this.author = author;
	}
	
	// ACCESSORS
	/**
	 * This is a getter that will return the name of the song
	 * @return songName
	 */
	public String getsName() {
		return this.songName;
	}
	
	/**
	 * This is a getter that will return the author of the song
	 * @return author
	 */
	public String getauthor() {
		return this.author;
	}
	
	
	/**
	 * This will print the Queue out in the format we designed it to 
	 * print out for maximum good looks 
	 */
	public void printQueue() {
		
		for (int i = 0; i < queue.size(); i++) {
			System.out.println(queue.get(i).toString());
			System.out.println();
		}
	}
	
	/**
	 * A toString to print out the contents of a Queue if needed
	 */
	@Override public String toString() {
		return "\nTitle: " + this.getsName() 
				+"\nAuthor: " + this.getauthor()
				+"\n";
				
	}
}