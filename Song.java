/**
 * @author Devin
 *
 */
public class Song {
	
	String title;
	int duration;

	/**
	 * Constructor
	 * @param titleSetter
	 * @param durationSetter
	 */
	public Song(String titleSetter, int durationSetter) {
		title = titleSetter;
		duration = durationSetter;
	}

	/**
	 * @return song title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @return song duration
	 */
	public int getDuration()
	{
		return duration;
	}

	/**
	 * @return human friendly string with title and song duration
	 */
	public final String toString()
	{
		// Initialize return string
		String timeString;
		String placeholder = ":";
	
		// Convert seconds to minutes and seconds
		double minutes = (duration / 60.0);
		double seconds = (minutes - Math.floor(minutes)) * 60;
		// Round seconds since type casting rounds down
		seconds = Math.round(seconds);
		
		// If seconds are below 10 replace ":" with ":0"
		if (seconds < 10)
		{
			placeholder = ":0";
		}
		
		// Create string format
		timeString = title + ": " + (int)minutes + placeholder + (int)seconds;
		return timeString;
	}

	 
}
