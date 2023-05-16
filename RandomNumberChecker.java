public class RandomNumberChecker 
{
	static final int MAX_VALUE = 6;
	static final int MIN_VALUE = 1;
	static final int NUMBER_OF_VALUES = (MAX_VALUE - MIN_VALUE + 1);
	static final int NUMBER_OF_TRIALS = 1000;
	
	public static void main(String args[])
	{
		int[] count;
		count = new int[NUMBER_OF_VALUES];
		
		for (int i = 0; i < NUMBER_OF_TRIALS; i++)
		{
			int position;
			int random;
			double randomReal;
			randomReal = Math.random() * NUMBER_OF_VALUES + MIN_VALUE;
			random = (int)(randomReal);
			position = random - MIN_VALUE;
			count[position] = count[position] + 1;
		}
		
		System.out.println( "Counts" );
		for (int i = 0; i < count.length; i++)
		{
			System.out.println((i + MIN_VALUE) + ": " + count[i]);
		}
		int expectedCount;
		expectedCount = NUMBER_OF_TRIALS / NUMBER_OF_VALUES;
		System.out.println("The expected count is " + expectedCount);
		
		System.out.println("Distance From Average");
		for (int i = 0; i < count.length; i++) 
		{
			int distanceFromExpected;
			distanceFromExpected = count[i] - NUMBER_OF_TRIALS / NUMBER_OF_VALUES;
			System.out.println((i + MAX_VALUE) + ": " + Math.abs(distanceFromExpected));
		}
		
		
	}
}
