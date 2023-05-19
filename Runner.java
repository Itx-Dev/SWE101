import java.math.BigInteger;

/**
 * @author Merlin
 *
 */
public class Runner {
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Fibonacci f = new Fibonacci();
		long next = f.findNext();
		while (next > 0)
		{
			System.out.println(next);
			next = f.findNext();
			System.out.println("next = " + next + ", oneBack " + f.getOneBack() + ", and twoBack = " + f.getTwoBack());
		}
		
		int j;
		for (j = 0; j < 5; j++)
		{
			next = f.findNext();
			System.out.println("next = " + next + ", oneBack " + f.getOneBack() + ", and twoBack = " + f.getTwoBack());
		}
		
		System.out.println("");
		System.out.println("Adding one . . .");
		int i;
		for (i = 2147483645; i > 0; i++)
		{
			System.out.print(" " + i);
		}
		System.out.println(" " + i);
		
		BigFibonacci bigF = new BigFibonacci();
		BigInteger bigNext = bigF.findNext();
		while (bigNext.compareTo(new BigInteger("9999999999999999")) < 1)
		{
			System.out.println(bigNext);
			bigNext = bigF.findNext();
			}
		System.out.println(bigNext);
	}
}
