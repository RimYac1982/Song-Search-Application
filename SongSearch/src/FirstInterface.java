import java.util.ArrayList;

public interface FirstInterface<T> extends Comparable<T>{
	public void readSongs();
	public void printSongs();
	public void bubbleSort();
	public int linearSearch(T title);
	public int linearSearch(String title);
}
