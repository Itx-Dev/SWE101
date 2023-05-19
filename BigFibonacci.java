import java.math.BigInteger;

/**
 * @author Merlin
 *
 */
public class BigFibonacci {
	private BigInteger oneBack = new BigInteger("1");
	private BigInteger twoBack = new BigInteger("0");
	
	/**
	 * @return next value
	 */
	public BigInteger findNext()
	{
		BigInteger result = oneBack.add(twoBack);
		twoBack = oneBack;
		oneBack = result;
		return result;
	}
	
	/**
	 * @return oneBack value
	 */
	public BigInteger getOneBack()
	{
		return oneBack;
	}
	
	/**
	 * @return twoBack value
	 */
	public BigInteger getTwoBack()
	{
		return twoBack;
	}

}
