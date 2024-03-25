public abstract class Media {
	private String title;
	private String author;
	private double duration;

	/**
	 * Default zero constructor for class Media, calls upon the 3 
	 * argument constructor to set default values to title
	 * and author and duration
	 */
	public Media() {
		this("title unknown", "author unknown", -99.99);
	}
	
	/**
	 * Default three constructor for the class Media, uses 
	 * String title, String author, and double duration to 
	 * set values to the variables title, author, and duration
	 * @param title the title
	 * @param author the author
	 * @param duration the duration
	 */
	public Media(String title, String author, double duration) {
		this.title = title;
		this.author = author;
		this.duration = duration;
	}
	
	//setters
	/**
	 * This is a setter that will set the title to whatever the
	 * given string parameter is set to
	 * @param title the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * This is a setter that will set the author to whatever the
	 * given string parameter is set to 
	 * @param author the author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
		
	/**
	 * This is a setter that will set the duration to whatever the 
	 * given double parameter is set to
	 * @param duration the duration
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	//getters
	/**
	 * This is a getter that return title
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * This is a getter that will return author
	 * @return author
	 */
	public String getAuthor() {
		return this.author;
	}
	
	/**
	 * This is a getter that will return duration
	 * @return duration
	 */
	public double getDuration() {
		return this.duration;
	}
	
	/**
	 * This is an equals method that will return whether or not 
	 * the given object parameter is the same as the one it is 
	 * being comapred to
	 * @return true or false
	 */
	@Override public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof Media)) {
			return false;
		} else {
			Media m = (Media) o;
			return getTitle().equalsIgnoreCase(m.getTitle()) && getAuthor().equalsIgnoreCase(m.getAuthor());
		}

	
}
	
}