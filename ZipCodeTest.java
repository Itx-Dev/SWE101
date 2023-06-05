import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

/**
 * @author Devin
 *
 */
public class ZipCodeTest {

	/**
	 * @throws ZipCodeException
	 * Test for initialization
	 */
	@Test
	public void testInitializationSimple() throws ZipCodeException
	{
		ZipCode z1 = new ZipCode(17257);
		assertEquals("17257", z1.toString());
	}
	
	/**
	 * @throws ZipCodeException
	 * Test zipCode gets converted to a string
	 */
	@Test
	public void TesttoString() throws ZipCodeException
	{
		ZipCode z1 = new ZipCode(12340);
		ZipCode z2 = new ZipCode(12300);
		ZipCode z3 = new ZipCode(12000);
		ZipCode z4 = new ZipCode(10000);
		ZipCode z5 = new ZipCode(1234);
		assertEquals("12340", z1.toString());
		assertEquals("12300", z2.toString());
		assertEquals("12000", z3.toString());
		assertEquals("10000", z4.toString());
		assertEquals("01234", z5.toString());
	}
	/**
	 * @throws ZipCodeException
	 * Test zipCode gets converted to a string when partially filled
	 */
	@Test
	public void TesttoString2() throws ZipCodeException 
	{
		ZipCode z1 = new ZipCode(123);
		ZipCode z2 = new ZipCode(12);
		ZipCode z3 = new ZipCode(1);
		
		assertEquals("00123", z1.toString());
		assertEquals("00012", z2.toString());
		assertEquals("00001", z3.toString());
	}

	/**
	 * @throws ZipCodeException
	 * Test check digit
	 */
	@Test
	public void testCheckDigit() throws ZipCodeException
	{
		ZipCode z1 = new ZipCode(2);
		ZipCode z2 = new ZipCode(12);
		ZipCode z3 = new ZipCode(22);
		ZipCode z4 = new ZipCode(01234);
		ZipCode z5 = new ZipCode(11234);

		
		assertEquals(8, z1.getCheckDigit());
		assertEquals(7, z2.getCheckDigit());
		assertEquals(6, z3.getCheckDigit());
		assertEquals(0, z4.getCheckDigit());
		assertEquals(9, z5.getCheckDigit());
	} 
	/**
	 * @throws ZipCodeException
	 * Test for accurate barCode
	 */
	@Test
	public void testBarCode() throws ZipCodeException
	{
		ZipCode z1 = new ZipCode(17257);
		
		assertEquals("|```|||```|``|`|`|`|`|```||``|`|", z1.getBarCode());
	}
	
	/**
	 * @throws ZipCodeException
	 * Test exception for negative number is being thrown
	 */
	@Test(expected = ZipCodeException.class)
	public void testNegative() throws ZipCodeException
	{
		ZipCode z = new ZipCode(-1);
	}
	
}
