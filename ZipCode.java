/**
 * @author Devin
 *
 */
public class ZipCode 
{
	static final int ZIPCODEMAX = 5;
	
	private static final String[] CODE = 
	{		"||```",
			"```||",
			"``|`|",
			"``||'",
			"`|``|",
			"`|`|`",
			"`||``",
			"|```|",
			"|``|`",
			"|`|``"};
	
	int zipCode;
	
	int[] zipDigits = new int[ZIPCODEMAX];
	
	String zipString;
	
	/**
	 * @param z
	 * @throws ZipCodeException 
	 */
	
	public ZipCode(int z) throws ZipCodeException 
	{
		if (z <= 0 || z >= 100000)
		{
			throw new ZipCodeException("Zip Code cannot be negative");
		}
		// Convert int to string and format to 5 places with zeros as left padding
		zipString = String.format("%05d", z);
		
		// Put each digit of int into an array of ints
		for (int i = 0; i <= zipString.length() - 1; i++)
		{
			// Get char at each place of zip code and subtract ASCII value to get decimal value
			zipDigits[i] = zipString.charAt(i) - '0';
		}
		
	}
	
	/**
	 * @return zipCode as String formatted so 5 or 9 zeros pad the left side
	 * Suppress warning as program is designed for the const zipCodeMax to be changed by user
	 */

	public String toString()
	{	
		return zipString;
	}
	
	/**
	 * @return checkDigit, sum of each digit
	 */
	
	public int getCheckDigit()
	{
		int checkDigit = 0, digit;
		boolean isSpecial = false;
		
		// Start at end of digit array 
		for (int i = zipDigits.length - 1; i >= 0; i--)
		{
			// Set digit equal to selected array element
			digit = zipDigits[i];
			
			// If sum is 9 and next digit is one break, returning 9
			if (checkDigit == 9 && digit == 1)
			{
				isSpecial = true;
				break;
			}
			
			// Add each digit in array
			checkDigit += digit;
		}
		
		int remainder = checkDigit % 10;
		checkDigit = 10 - remainder;
		
		// If checkDigit is divisible by 10 return 0
		if (checkDigit % 10 == 0)
		{
			return 0;
		}
		
		if (isSpecial)
		{
			return 9;
		}
		else 
		{
			return checkDigit;
		}
	}
	
	/**
	 * @return printed bar code
	 */
	public String getBarCode()
	{
		String fullData = "", individualData, checkDigitData;
		
		// Create data string for bar code
		// Corresponding zip code digits go with index of CODE string array
		for (int i = 0; i <= zipDigits.length - 1; i++)
		{
			individualData = CODE[zipDigits[i]];
			fullData += individualData;
		}
		
		// Find bar code sequence for check digit
		checkDigitData = CODE[getCheckDigit()];
		// Add check digit sequence to data set
		fullData += checkDigitData;

		// Define format of barcode
		String frame = "|" + fullData + "|";
		
		// Return everything put together
		return frame;
	}
	
}
