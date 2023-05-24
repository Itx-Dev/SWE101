import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class testMySorter {
	
	/**
	 * Test Bubble Sort on a small, randomly ordered array
	 */
	@Test
	public void testBubbleSort()
	{
		int[] x = { 5, 3, 8, 1 };
		MySorter s = new MySorter();
		s.bubbleSort(x);
		for (int i = 0; i < x.length - 1; i++)
		{
			assertTrue("Out of order at" + i, x[i]< x[i + 1]);
		}
	
	}

	/**
	 * Test maxPosition for an element in the 
	 * middle of the unsorted portion
	 */
	@Test
	public void testMaxPositionMiddle()
	{
		int[] x = {1, 5, 3, 7, 8, 9};
		MySorter s = new MySorter();
		assertEquals(1,  s.maxPosition(x, 2));
	}
	
	@Test
	public void testMaxPositionFirst()
	{
		int[] x = {5, 1, 3, 2, 8, 9};
		MySorter s = new MySorter();
		assertEquals(0,  s.maxPosition(x, 3));
	}
	
	@Test
	public void testMaxPositionLast()
	{
		int[] x = {1, 5, 3, 7, 8, 9};
		MySorter s = new MySorter();
		assertEquals(3,  s.maxPosition(x, 3));
	}
	
	@Test
	public void testMaxPositionOneElement()
	{
		int[] x = {1, 5, 3, 7, 8, 9};
		MySorter s = new MySorter();
		assertEquals(0,  s.maxPosition(x, 0));
	}
	
	@Test
	public void testMaxPositionNegative()
	{
		int[] x = {-7, -6, -8, -3, -1};
		MySorter s = new MySorter();
		assertEquals(1,  s.maxPosition(x, 2));
	}
	
	@Test
	public void testSelectionSmall()
	{
		int[] x = {5, 3, 8, 1};
		MySorter s = new MySorter();
		s.selectionSort(x);
		for (int i = 0; i < x.length - 1; i++)
		{
			assertTrue("Out of order at " + i, x[i] < x[i + 1]);
		}
	}
	
	@Test
	public void testInsertionSmall()
	{
		int[] x = {5, 3, 8, 1};
		MySorter s = new MySorter();
		s.insertionSort(x);
		for (int i = 0; i < x.length - 1; i++)
		{
			assertTrue("Out of order at " + i, x[i]< x[i + 1]);
		}
	}
}
