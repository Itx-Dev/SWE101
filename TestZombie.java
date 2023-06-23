import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Devin
 *
 */
public class TestZombie extends TestLifeForm 
{

	/**
	 * @see TestLifeForm#createLifeForm(int)
	 */
	public LifeForm createLifeForm(int points) 
	{
		return new Zombie(points);
	}
	
	/**
	 * Zombies have health at creation
	 */
	@Test
	public void testCreation()
	{
		LifeForm deadFred = new Zombie(50);
		
		assertEquals(50, deadFred.getLifePoints());
	}
	
	/**
	 * 
	@Test
	public void testTakeHit()
	{
		Zombie deadFred = new Zombie(50);
		
		// Test 5 damage taken
		deadFred.takeHit(5);
		assertEquals(45, deadFred.getLifePoints());
		
		// Test 45 more damage taken
		deadFred.takeHit(45);
		assertEquals(0, deadFred.getLifePoints());
	}
	*/
	
	
	/**
	 * Test life points going negative return 0 health
	 */
	@Test
	public void negativeLifePoints()
	{
		int originalHealth = 50;
		int weaponStrength = 5;
		
		// Create Zombie
		LifeForm deadFred = new Zombie(originalHealth);

		// Take hits until life points are not positive
		while (deadFred.getLifePoints() > 0)
		{
			// Take hit
			deadFred.takeHit(weaponStrength);
		}

		assertEquals(0, deadFred.getLifePoints());
		
		// Test getting hit after knowing life points are zero
		deadFred.takeHit(weaponStrength);
		assertEquals(0,  deadFred.getLifePoints());
	}
	
	/**
	 * Test recovery feature of zombies
	 */
	
	@Test
	public void testRecovery()
	{
		int originalHealth = 1000;
		int weaponStrength = 50;
		
		// Create Zombie
		Zombie deadFred = new Zombie(originalHealth);
		
		// Zombie takes damage
		deadFred.takeHit(weaponStrength);
		// How many points are taken from zombie's health
		int damageCaused = originalHealth - deadFred.getLifePoints();
		
		// Zombie regains 10% of health lost
		deadFred.recover();
		
		double regained = damageCaused * 0.10;
		// damaged health value plus 10% of damage taken
		int actual = (originalHealth - damageCaused) + (int) (regained);
		
		assertEquals(actual, deadFred.getLifePoints());
	}
	
	/**
	 * Test borders where each hit and recovery uses 
	 * the original life points and current life points
	 */
	@Test
	public void testBorderRecovery()
	{
		int originalHealth = 50;
		int weaponStrength = 5;
		
		// Create Zombie 
		Zombie deadFred = new Zombie(originalHealth);
		
		deadFred.takeHit(weaponStrength);
		
		// Damage is original health minus new health
		int damageCaused = originalHealth - deadFred.getLifePoints();
		// desired value for test is current life points + 10% of damage caused
		int actual = (originalHealth - damageCaused) + (int) (damageCaused * 0.10);

		// Recover life points
		deadFred.recover();
		
		// Test values
		assertEquals(actual, deadFred.getLifePoints()); 
		
		deadFred.takeHit(weaponStrength);
		
		// Damage is original health minus new health
		int damageCaused2 = originalHealth - deadFred.getLifePoints();
		// desired value for test is current life points + 10% of damage caused
		int actual2 = (originalHealth - damageCaused2) + (int) (damageCaused2 * 0.10);
		
		// Recover life points
		deadFred.recover();
			
		assertEquals(actual2, deadFred.getLifePoints()); 
	}
	
	
	
	

}
