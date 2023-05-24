/**
 * @author Devin
 *
 */
public class MySorter 
{
	/**
	 * Sort the given array
	 * @param array the array to be sorted
	 */
	public void bubbleSort(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++)
		{
			for (int j = 0; j < array.length - 1; j++)
			{
				if (array[j] > array[j + 1])
				{
					swap(array, j, j+1);
				}
			}
		}
	}
	
	private void swap(int[] x, int i, int j)
	{
		int t = x[i];
		x[i]= x[j];
		x[j]= t; 
	}
	
	/**
	 * @param array
	 * @param end
	 * @return Index of largest value in unsorted part of array
	 */
	public int maxPosition(int[] array, int end) 
	{
		int largestIndex = 0;
		
		for (int i = 0; i <= end; i++)
		{
			if (array[i] > array[largestIndex])
			{
				largestIndex = i;
			}
		}
		return largestIndex;
	}
	
	/**
	 * @param array
	 */
	public void selectionSort(int[] array) 
	{
		int lastPosition = array.length - 1;
		for (int i = 0; i < lastPosition; i++)
		{
			if (array[maxPosition(array, i)] > array[lastPosition])
			{
				swap(array, lastPosition, maxPosition(array, i));
			}
		}
	}
	
	/**
	 * @param array
	 */
	public void insertionSort(int[] array)
	{
	    for (int i = 1; i < array.length; i++) 
	    {
	      int currentPosition = array[i];
	      int j = i - 1;

	      while (j >= 0 && currentPosition < array[j]) 
	      {
	        array[j + 1] = array[j];
	        --j;
	      }
	      array[j + 1] = currentPosition;
	    }
	}
}
