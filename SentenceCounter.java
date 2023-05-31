import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Devin
 *
 */
public class SentenceCounter 
{
	// instance variable
	String sentence;
	
	/**
	 * Constructor
	 * @param s
	 */
	public SentenceCounter(String s) 
	{
		sentence = s;
	}

	/**
	 * @return sentence
	 */
	public String getSentence()
	{
		return sentence;
	}

	
	/**
	 * @return blankCount, number of blanks in string
	 */
	public int countBlanks() 
	{
		int blankCount = 0;
		// If character is equal to char ' '
		// increment blank count
		for (int i = 0; i <= sentence.length() - 1; i++) 
		{
			if (sentence.charAt(i) == ' ') 
			{
				++blankCount;
			}
		}
		return blankCount;
	}
	
	/**
	 * @return lowerCaseCount, amount of lower case characters
	 */
	public int countLowerCase()
	{
		int lowerCaseCount = 0;
		
		for (int i = 0; i <= sentence.length() - 1; i++) 
		{
			char ch = sentence.charAt(i);
			// if character is between lower case characters a-z 
			// increment lower case count
			if (ch >= 'a' && ch <= 'z')
			{
				lowerCaseCount++;
			}
		}
		return lowerCaseCount;
	}
	
	/**
	 * @return index of first blank 
	 * or -1 if no blanks exist
	 */
	public int firstBlankPosition()
	{
		for (int i = 0; i <= sentence.length() - 1; i++)
		{
			if (sentence.charAt(i) == ' ')
			{
				// return index of first blank
				return i;
			}
		}
		// If no blanks return -1
		return -1;
	}
	
	
	/**
	 * @param finalBlank
	 * @return index of final blank
	 */
	public int blankPosition(int finalBlank)
	{
		int blankCount = 0;
		for (int i = 0; i <= sentence.length() - 1; i++) 
		{
			if (sentence.charAt(i) == ' ')
			{
				blankCount++;
			}
			
			if (blankCount == finalBlank) 
			{
				return i;
			}
		}
		// If no blanks return -1
		return -1;
	}
	
	/**
	 * @param ch
	 * @return true if char is in string
	 */
	public boolean contains(char ch)
	{
		for (int i = 0; i <= sentence.length() - 1; i++)
		{
			if (sentence.charAt(i) == ch)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param s
	 * @return length if substring array
	 */
	public int countOccurrences(String s)
	{		
		// .split() returns array of substrings matching s
		// find length of array - 1 and return for occurrences 
		return (sentence.split(s).length - 1);
	}
	
	/**
	 * @param s
	 * @return s
	 */
	public int countWildCardMatches(String s)
	{
		int occurances = 0;
		
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(sentence);
		
		while (matcher.find())
		{
			occurances++;
		}
		
		return occurances;
	}

	

	
	
	
	
}
