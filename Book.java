/**
 * @author Devin
 *
 */
public class Book 
{
	int checkOutNum = 0;
	boolean checkedOut;
	String title;
	/**
	 * Create the book and give it a title
	 * @param t
	 */
	public Book(String t)
	{
		title = t;
	}
	
	/**
	 * @return the title of this book
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * @return variable checkedOut
	 */
	public boolean isCheckedOut()
	{
		return checkedOut;
	}
	

	/**
	 *  Set checkOut equal to true and increment checkout number by 1
	 */
	public void checkOut()
	{
		checkedOut = true;
		checkOutNum = checkOutNum + 1;
	}
	
	/**
	 *  Set checkOut equal to false
	 */
	public void checkIn()
	{
		checkedOut = false;
	}
	
	/**
	 * @return number of times book was checked out
	 */
	public int getNumberOfCheckOuts()
	{
		return checkOutNum;
	}
}
