import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Devin
 */
public class TestHuman extends TestLifeForm
{
	
	/**
	 * @see TestLifeForm#createLifeForm(int)
	 */
	public LifeForm createLifeForm(int points) 
	{
		return new Human(points);
	}
	
	/**
	 * Test creation of human
	 */
	@Test
	public void testCreation()
	{
		Human wellington = new Human(100);
		assertEquals(100, wellington.getLifePoints());
	}
	
	/*
	 * @see TestLifeForm#pickUpWeakerWeapon()
	 */
	@Test
	public void pickUpWeakerWeapon()
	{
		Human wellington = new Human(100);
		assertEquals(0, wellington.numberWeaponsInBackPack());
		wellington.pickUpWeapon(15);
		wellington.pickUpWeapon(14);
		assertEquals(15, wellington.getCurrentWeaponStrength());
		assertEquals(1, wellington.numberWeaponsInBackPack());
		assertTrue(wellington.isCarryingWeapon(14));

	}
	
	/**
	 * test picking up two weaker weapons
	 */
	@Test
	public void pickUpTwoWeakerWeapons()
	{
		Human wellington = new Human(100);
		wellington.pickUpWeapon(15);
		wellington.pickUpWeapon(14);
		wellington.pickUpWeapon(12);
		assertEquals(15, wellington.getCurrentWeaponStrength());
		assertEquals(2, wellington.numberWeaponsInBackPack());
		assertTrue(wellington.isCarryingWeapon(14));
		assertTrue(wellington.isCarryingWeapon(12));
	}
	
	/**
	 * test picking up stronger and weaker weapon with full backpack
	 */
	@Test
	public void pickUpStrongerWithFullBackPack()
	{
		Human wellington = new Human(100);
		// Fill up backpack
		for (int i = 10; i >= 0; i--)
		{
			wellington.pickUpWeapon(5*(i+1));
		}
		// Test weaker weapon being picked up
		wellington.pickUpWeapon(8);
		assertEquals(55, wellington.getCurrentWeaponStrength());
		// Test stronger weapon being picked up
		wellington.pickUpWeapon(100);
		assertEquals(100, wellington.getCurrentWeaponStrength());
	}
	
	/**
	 * Test swapping of best weapons
	 */
	@Test
	public void swapWeapons()
	{
		Human wellington = new Human(100);
		// Fill up backpack
		for (int i = 10; i >= 0; i--)
		{
			wellington.pickUpWeapon(5*(i+1));
		}
		
		wellington.pickUpWeapon(500);
		
	}
	
}
