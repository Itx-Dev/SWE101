import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class testAlbum {
	
	@Test
	public void testConstructor()
	{
		Album a1 = new Album("My Album", 3);
		Album a2 = new Album("My Second Album", 5);
		
		assertEquals("My Album", a1.getTitle());
		assertEquals(3, a1.getSize());
		assertEquals(0, a1.getNumberOfSongs());
		
		assertEquals("My Second Album", a2.getTitle());
		assertEquals(5, a2.getSize());
		assertEquals(0, a2.getNumberOfSongs());
	}

	@Test
	public void testOneSong()
	{
		Album a1 = new Album("My Cool Album", 3);
		Song s1 = new Song("Song Title", 272);
		
		// Add song s1 to album
		a1.addSong(s1);
		
		assertEquals("My Cool Album", a1.getTitle());
		assertEquals(1, a1.getNumberOfSongs());
		assertEquals(s1,  a1.songs[0]);
	}
	
	@Test
	public void testFullAlbum()
	{
		Album a1 = new Album("Full Album", 3);
		Song s1 = new Song("First Song", 272);
		Song s2 = new Song("Second Song", 305);
		Song s3 = new Song("Third Song", 249);
		
		a1.addSong(s1);
		a1.addSong(s2);
		a1.addSong(s3);
		
		assertEquals(s1, a1.getSong(0));
		assertEquals(s2, a1.getSong(1));
		assertEquals(s3, a1.getSong(2));

	}
	
	@Test
	public void testDurationSimple()
	{
		Album a1 = new Album("One Song", 1);
		Song s1 = new Song("Song One", 232);
		
		a1.addSong(s1);
		
		assertEquals(232, a1.getDuration());
	}
	
	@Test 
	public void testDurationFull()
	{
		Album a1 = new Album("Full Album", 3);
		Song s1 = new Song("First Song", 272);
		Song s2 = new Song("Second Song", 305);
		Song s3 = new Song("Third Song", 249);
		
		a1.addSong(s1);
		a1.addSong(s2);
		a1.addSong(s3);
		
		assertEquals(826, a1.getDuration());
	}
	
	@Test
	public void testDurationPartiallyFull()
	{
		Album a1 = new Album("Partially Full Album", 3);
		Song s1 = new Song("First", 272);
		Song s2 = new Song("Second", 305);
		
		a1.addSong(s1);
		a1.addSong(s2);
		
		assertEquals(577, a1.getDuration());
	}
	
	@Test
	public void testtoString()
	{
		String string1 = "Heavier Things:\n\tClarity: 4:32\n\tSomething's Missing: 5:05\n\tNew Deep: 4:09";
		
		Album a1 = new Album("Heavier Things", 3);
		Song s1 = new Song("Clarity", 272);
		Song s2 = new Song("Something's Missing", 305);
		Song s3 = new Song("New Deep", 249);
		
		a1.addSong(s1);
		a1.addSong(s2);
		a1.addSong(s3);
		
		assertEquals(string1, a1.toString());
	}
	
}
