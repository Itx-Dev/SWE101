/**
 * @author Merlin
 */
public class Fibonacci 
{
	private long oneBack = 1;
	private long twoBack = 0;
	
	/**
	 * @return next value in sequence
	 */
	public long findNext()
	{
		long result = oneBack + twoBack;
		if (result < oneBack)
		{
			oneBack = 0;
			twoBack = 1;
			result = 0;
		} else 
		{
			twoBack = oneBack;
			oneBack = result;
		}
		return result;
	}

	/**
	 * @return oneBack value
	 */
	public long getOneBack() {
		return oneBack;
	}

	/**
	 * @return twoBack value
	 */
	public long getTwoBack() {
		return twoBack;
	}
}
