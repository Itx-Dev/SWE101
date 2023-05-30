import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Devin
 *
 */
public class TestSentenceCounter 
{
	private static final String SENTENCE1 = "This is my sentence.";
	private static final String SENTENCE2 = "These words make another sentence that is longer.";
	
	private SentenceCounter sc1;
	private SentenceCounter sc2;
	
	/**
	 * Create two instances we can play with
	 */
	@BeforeEach
	public void setup()
	{
		sc1 = new SentenceCounter(SENTENCE1);
		sc2 = new SentenceCounter(SENTENCE2);
	}

	/**
	 * Make sure the instance variable is correct
	 */
	@Test
	public void testConstructor()
	{
		assertEquals(SENTENCE1, sc1.getSentence());
		assertEquals(SENTENCE2, sc2.getSentence());
	}

	/**
	 * Test blank count
	 */
	@Test
	public void testCountBlanks()
	{
		assertEquals(3, sc1.countBlanks());
		assertEquals(7, sc2.countBlanks());
	}
	
	/**
	 * Test lower case count
	 */
	@Test
	public void testCountLower()
	{
		assertEquals(15, sc1.countLowerCase());
		assertEquals(40, sc2.countLowerCase());
	}
	

	/**
	 * Test lower case count on border
	 */
	@Test
	public void testCountLowerBorder()
	{
		SentenceCounter borderCounter = new SentenceCounter((char)96 + "az}");
		assertEquals(2, borderCounter.countLowerCase());
	}

	/**
	 * Test first blank position
	 */
	@Test
	public void testFirstBlankPosition()
	{
		assertEquals(4, sc1.firstBlankPosition());
		assertEquals(5, sc2.firstBlankPosition());
	}
	
	/**
	 * Test blank position if no blanks occur
	 */
	@Test
	public void testFirstBlankPositionNoBlanks()
	{
		SentenceCounter sc = new SentenceCounter("NoBlanksInThisSentence");
		assertEquals(-1, sc.firstBlankPosition());
	}
	
	/**
	 * Test blank position
	 */
	@Test
	public void testBlankPosition()
	{
		assertEquals(10, sc1.blankPosition(3));
		assertEquals(24, sc2.blankPosition(4));
	}
	
	/**
	 * Test blank position when not enough blanks occur
	 */
	@Test
	public void testBlankPositionTooFar()
	{
		assertEquals(-1, sc1.blankPosition(4));
	}
	
	/**
	 * Test if sentence contains char
	 */
	@Test
	public void testContains()
	{
		assertTrue(sc1.contains('T'));
		assertTrue(sc1.contains('y'));
		assertFalse(sc1.contains('z'));
		assertFalse(sc1.contains('Y'));
	}
	
	/**
	 * Test the occurrences of substring in sentence
	 */
	@Test
	public void testCountOccurances()
	{
		assertEquals(1,  sc1.countOccurances("ence"));
		assertEquals(2,  sc1.countOccurances("en"));
		assertEquals(1,  sc2.countOccurances("that"));
		assertEquals(0,  sc2.countOccurances("This"));
	}
	
	/**
	 * Test Wild Card Regular Expression Matches
	 */
	@Test
	public void testMatchesWildCard()
	{
		assertEquals(1, sc1.countWildCardMatches(".e..e..e"));
		assertEquals(2, sc2.countWildCardMatches("o..e"));
	}
	
}

