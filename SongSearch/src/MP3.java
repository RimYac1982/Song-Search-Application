import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public final class MP3 extends Music implements FirstInterface<Music> {
	private ArrayList<Music> music = new ArrayList<Music>();
	private ArrayList<Queue> queue = new ArrayList<Queue>();

	public void readSongs() {

		try {
			File file = new File("Songs.txt");
			Scanner input = new Scanner(file);

			String title = "";
			String author = "";
			String genre = "";

			double duration = 0.0;

			while (input.hasNextLine()) {

				if (input.hasNextLine()) {
					title = input.nextLine();
				}
				if (input.hasNextLine()) {
					author = input.nextLine();
				}
				if (input.hasNextLine()) {
					genre = input.nextLine();
				}
				if (input.hasNextDouble()) {
					duration = input.nextDouble();
					input.nextLine();
					input.nextLine();
				}
				Music m = new Music(title, author, genre, duration);
				music.add(m);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

	}

	public void printSongs() {
		for (int i = 0; i < music.size(); i++) {
			System.out.println(music.get(i).toString());
			System.out.println();
		}
	}

	public void bubbleSort() {

		Music test;
		boolean bubblesort = false;

		while (!bubblesort) {
			bubblesort = true;
			for (int i = 0; i < music.size() - 1; i++) {
				if (music.get(i).getTitle().compareToIgnoreCase(music.get(i + 1).getTitle()) > 0) {
					test = music.get(i);
					music.set(i, music.get(i + 1));
					music.set(i + 1, test);
					bubblesort = false;
				}
			}
		}
	}

	public int linearSearch(Music title) {
		for (int i = 0; i < music.size(); i++) {
			if (music.get(i).equals(title)) {
				return i;
			}
		}
		return -1;
	}

	public int linearSearch(String title) {
		for (int i = 0; i < music.size(); i++) {
			if (music.get(i).getTitle().equalsIgnoreCase(title)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		MP3 pro = new MP3();
		boolean stop = false;
		String userChoice;
		boolean currentlyPlayingTF = false;
		Music currrentlyplayingSong = null;

		Scanner userInput = new Scanner(System.in);

		// Reading the list of songs and adding them to arraylist music
		pro.readSongs();

		// bubble sorting the list of songs by alphabetically by title
		pro.bubbleSort();

		System.out.println("Welcome to Fakeify! Please choose from the below list of options\n");

		while (stop != true) {
			// IF USER IS CURRENTLY PLAYING A SONG
			if (currentlyPlayingTF == true) {
				System.out.println("\nCurrently playing: " + currrentlyplayingSong.getTitle() + " by "
						+ currrentlyplayingSong.getAuthor());
			}

			// MENU OPTIONS
			System.out.println("A. See all songs" + "\nB. Play a song" + "\nC. Stop all music/queue" + "\nD. Add a song"
					+ "\nE. Search for a song" + "\nF. Queue a song" + "\nG. View Queue" + "\nH. Skip to next song"
					+ "\nX. Exit");

			System.out.print("\nEnter your choice: ");
			userChoice = userInput.nextLine();

			// IF USER CHOOSES A
			if (userChoice.equalsIgnoreCase("A")) {
				System.out.println("\nHere is a list of our songs\n");
				pro.printSongs();

				// IF USER CHOOSES B
			} else if (userChoice.equalsIgnoreCase("B")) {

				System.out.print("\nEnter the name of the song: ");
				userChoice = userInput.nextLine();
				int yesNo = pro.linearSearch(userChoice);

				if (yesNo != -1 && currentlyPlayingTF == false) {
					System.out.println("\nWill now start playing: \n\n" + pro.music.get(yesNo) + "\n");
					currrentlyplayingSong = pro.music.get(yesNo);
					currentlyPlayingTF = true;
				} else if (currrentlyplayingSong != null) {
					try {
						Music oldSong = currrentlyplayingSong;
						Music newSong = pro.music.get(yesNo);
						System.out.println("\nStopping " + oldSong.getTitle() + " by " + oldSong.getAuthor()
								+ ". Now Playing:\n\n" + newSong);
						currrentlyplayingSong = pro.music.get(yesNo);
					} catch(IndexOutOfBoundsException e) {
						System.out.println("\nThat song does not exist. Returning to menu.");
					}
				} else {
					System.out.println("\nThat song has not been added, returning to menu.\n");
				}

				// IF USER CHOOSES C
			} else if (userChoice.equalsIgnoreCase("C")) {
				if (currentlyPlayingTF == true) {
					System.out.println("\nStopping the song: " + currrentlyplayingSong.getTitle());
					System.out.println();
					currentlyPlayingTF = false;
				} else {
					System.out.println("\nThere is no song playing at this very moment... returning to menu\n");
				}

				// IF USER CHOOSES D
			} else if (userChoice.equalsIgnoreCase("D")) {
				System.out.print("\nEnter the title of the song you want to enter: ");
				String tempTitle = userInput.nextLine();
				System.out.print("\nEnter the Author of the song: ");
				String tempAuthor = userInput.nextLine();
				System.out.print("\nEnter the Genre of the song: ");
				String tempGenre = userInput.nextLine();
				System.out.print("\nEnter the Duration of the song(Example: 3.23 for 3 minutes and 23 seconds): ");
				double tempDuration = userInput.nextDouble();
				userInput.nextLine();
				Music m = new Music(tempTitle, tempAuthor, tempGenre, tempDuration);
				pro.music.add(m);
				pro.bubbleSort();
				System.out.println("\n" + tempTitle + " has been added... returning to menu\n");

				// IF USER CHOOSES "E"
			} else if (userChoice.equalsIgnoreCase("E")) {
				System.out.print("\nEnter the Title of the song: ");
				String tempTitleF = userInput.nextLine();
				System.out.print("\nEnter the Author of the song: ");
				String tempAuthorF = userInput.nextLine();
				Music m = new Music(tempTitleF, tempAuthorF);
				int returnValue = pro.linearSearch(m);
				if (returnValue != -1) {
					System.out.println("\nWe found this song\n");
					System.out.println();
					Music.displayMusic(pro.music.get(returnValue));
				} else {
					System.out.println("\nWe do not have this song... returning to main menu\n");
				}

				// IF USER CHOOSES "F"
			} else if (userChoice.equalsIgnoreCase("F")) {
				try {
				if (currentlyPlayingTF == false) {
					System.out.println("\nPlease play a song before adding a song to the queue.\n");
				} else {
					System.out.print("\nEnter the title of the song you want to queue: ");
					String tempTitle = userInput.nextLine();
					String tempAuthor = "";

					int yesNo = pro.linearSearch(tempTitle);
					tempTitle = pro.music.get(yesNo).getTitle();

					Queue q = new Queue(tempTitle, tempAuthor);

					if (yesNo != -1) {
						pro.queue.add(q);
						System.out.println("\nAdding " + tempTitle + " to queue. Returning to menu");
					} else {
						System.out.println("\nCannot find this song in songs list. "
								+ "Add this song and try again. Returning to main menu\n");
					}

					if (currentlyPlayingTF == false) {
						currentlyPlayingTF = true;
						for (int i = 0; i < pro.music.size(); i++) {
							if (pro.queue.get(0).getsName().equals(pro.music.get(i).getTitle())) {
								currrentlyplayingSong = pro.music.get(i);
							}
						}
					}
				}
				} catch (IndexOutOfBoundsException e) {
					System.out.println("\nCannot find this song in songs list. "
							+ "Add this song and try again. Returning to main menu");
				}
				// IF USER CHOOSES "G"
			} else if (userChoice.equalsIgnoreCase("G")) {
				if (pro.queue.size() == 0 || currentlyPlayingTF == false) {
					System.out.println("\nThere are no songs in the queue. Queue song(s) and try again.\n");
				} else if (currentlyPlayingTF == true && pro.queue.size() == 1) {

					for (int a = 0; a < pro.queue.size(); a++) {
						for (int b = 0; b < pro.music.size(); b++) {
							Music old = pro.queue.get(a);
							Music fix = pro.music.get(b);
							if (pro.queue.get(a).getsName().equals(pro.music.get(b).getTitle())) {
								old = fix;

								System.out.println(pro.music.get(b));

							}
						}
					}
				} else {
					System.out.println("Accessing queue...\n");
					for (int a = 0; a < pro.queue.size(); a++) {
						for (int b = 0; b < pro.music.size(); b++) {
							Music old = pro.queue.get(a);
							Music fix = pro.music.get(b);
							if (pro.queue.get(a).getsName().equals(pro.music.get(b).getTitle())) {
								old = fix;

								System.out.println(pro.music.get(b));
							}
						}
					}
				}

				// IF USER CHOOSES "I"
			} else if (userChoice.equalsIgnoreCase("H")) {

				if (pro.queue.size() > 0) {
					Music oldSong = currrentlyplayingSong;

					for (int i = 0; i < pro.music.size(); i++) {
						if (pro.queue.get(0).getsName().equalsIgnoreCase(pro.music.get(i).getTitle())) {
							currrentlyplayingSong = pro.music.get(i);

						}
					}
					pro.queue.remove(0);
					System.out.println("\nStopping " + oldSong.getTitle() + " by " + oldSong.getAuthor()
							+ ". Now Playing:\n\n" + currrentlyplayingSong);

				} else {
					System.out.println("\nThere are no songs in the queue. Queue song(s) and try again.\n");
				}
				// }

				// IF USER CHOOSES "X"
			} else if (userChoice.equalsIgnoreCase("x")) {
				System.out.println("\nSigning off...");
				stop = true;

				// IF USER DID NOT ENTER ONE OF THE GIVEN MENU OPTIONS
			} else {
				System.out.println("\nThat response was invalid, try again\n");
			}

		}

		userInput.close();

	}

	@Override
	public int compareTo(Music o) {
		if (this.equals(o)) {
			return 0;

		} else if (!(getTitle().equals(o.getTitle()))) {
			return getTitle().compareTo(o.getTitle());

		} else if (!(getAuthor().equals(o.getAuthor()))) {
			return getAuthor().compareTo(o.getAuthor());

		} else if (!(getGenre().equals(o.getGenre()))) {
			return getGenre().compareTo(o.getGenre());

		} else {
			return Double.compare(getDuration(), o.getDuration());
		}
	}
}