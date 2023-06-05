/**
 * Exception caused by invalid zip codes
 * @author Devin
 */
public class ZipCodeException extends Exception
{
	private String message;
	
	/**
	 * @param string
	 */
	public ZipCodeException(String string)
	{
		this.message = string;
	}
	
	public final String toString()
	{
		return message;
	}
}
