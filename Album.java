/**
 * @author Devin
 */

public class Album {
	
	Song[] songs;
	
	String albumTitle;
	int albumSize, numberOfSongs;
	int duration;
	
	/**
	 * @param title 
	 * @param size 
	 */
	public Album(String title, int size)
	{
		// Set constructor parameters to global variables
		albumTitle = title;
		albumSize = size;
		
		// Define 
		songs = new Song[albumSize];
	}

	/**
	 * @return album title
	 */
	public String getTitle() {
		return albumTitle;
	}

	/**
	 * @return number of song album can hold
	 */
	public int getSize() {
		return albumSize;
	}
	/**
	 * @return number of songs on album
	 */
	public int getNumberOfSongs() {
		int songCount = 0;
		
		for (int i = 0; i < songs.length; i++)
		{
			// Count only non-null objects
			if (songs[i] != null)
			{
				songCount++;
			}
		}
		return songCount;
	}

	/**
	 * Add song to album
	 * @param s 
	 * @return songs, array of objects
	 */
	public Song[] addSong(Song s) {
		// Define beginning of array
		int position = albumSize - songs.length;
		
		// Search for empty position in object array
		while (songs[position] != null)
		{
			position++;
		}
		
		// Add song to empty array position
		songs[position] = s;
		
		// Return array of objects
		return songs;
	}
	
	/**
	 * @return Total album duration
	 */
	public int getDuration()
	{
		int durationSum = 0;
		// Sum duration of every non-empty spot in object array
		for (int i = 0; i <= songs.length - 1; i++)
		{
			if (songs[i] != null)
			{
				durationSum += songs[i].getDuration();
			}
		}
		
		return durationSum;
	}
	
	public String toString()
	{
		String albumLine = albumTitle + ':';
		String songLines = "";
		// Create string of each song on album with duration
		for (int i = 0; i <= songs.length - 1; i++)
		{
			if (songs[i] != null)
			{
				songLines =  songLines + "\n\t" + songs[i].toString();
			}
		}
		// Return album's title with string of each song
		return (albumLine + songLines);
	}
	
	
}
