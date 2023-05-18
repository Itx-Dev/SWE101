public class GraphPrinter 
{
	private static final int MAX_SCALE = 65;
	private static final double MIN_POINT = -1.0;
	private static final double MAX_POINT = 1.0;

	
	private static int calculateHeight(double x)
	{
		double shifted;
		double rangeSize;
		double numBlanks;
		
		shifted = x - MIN_POINT;
		rangeSize = MAX_POINT - MIN_POINT;
		numBlanks = shifted / rangeSize * MAX_SCALE;
		return (int) numBlanks;
	}
	
	public static void printHeading() 
	{
		System.out.println(" Simple Bar Graph Without Graphics");
		System.out.print("-1");
		for (int i = 0; i < MAX_SCALE/2; i++)
		{
			System.out.print(" ");
		}
		System.out.print("0");
		for (int i = 0; i < MAX_SCALE/2; i++) 
		{
			System.out.print(" ");
		}
		System.out.print("1");
		System.out.println();
		for (int i = 0; i < MAX_SCALE + 3; i++) 
		{
			System.out.print("-");
		}
		System.out.println();
	}
	
	public static void printBar(int height)
	{
		System.out.print(" ");
		for (int i = 0; i < height; i++)
		{
			System.out.print(" ");
		}
		System.out.println("*");
	}
	
	static void printBetween2Bar(int h1, int h2)
	{
		int min = Math.min(h1,  h2);
		int max = Math.max(h1, h2);
		int i = 0;
		while (i <= min)
		{
			System.out.print(" ");
			i = i + 1;
		}
		System.out.print("*");
		
		i = i + 1;
		while (i <= max)
		{
			System.out.print("*");
			i = i + 1;
		}
		System.out.print("*");
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		printHeading();
		
		for (double h = -Math.PI; h <= Math.PI; h = h + 0.15)
		{
			double sin;
			sin = Math.sin(h);
			double cos;
			cos = Math.cos(h);
			printBetween2Bar(calculateHeight(sin),calculateHeight(cos));
		}
	}
}

