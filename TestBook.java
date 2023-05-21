import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class TestBook {
	// Set constant title of book to titleString
	private static final String titleString = "Catcher In The Rye";

	// Set book1 variable
	Book book1 = new Book(titleString);
	
	/*
	 * When a book is created, it should know its title and number of checkouts should be zero
	 */
	
	@Test
	public void testInitialization() 
	{
		assertEquals(titleString, book1.getTitle());
		assertEquals(0, book1.getNumberOfCheckOuts());
	}
	
	/*
	 * Test if book was checked out once
	 */

	@Test
	public void testCheckOut()
	{
		book1.checkOut();
		assertTrue(book1.isCheckedOut());
		assertEquals(1,  book1.getNumberOfCheckOuts());
	}
	
	/*
	 * Test if book was checked out twice
	 */
	
	@Test
	public void testCheckOutTwice()
	{
		book1.checkOut();
		assertTrue(book1.isCheckedOut());
		book1.checkOut();
		assertEquals(2, book1.getNumberOfCheckOuts());
		
	}
	
	/*
	 * Test if book was checked in
	 */
	
	@Test
	public void testCheckIn()
	{
		book1.checkOut();
		book1.checkIn();
		assertFalse(book1.isCheckedOut());
	}

}
