import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Devin
 *
 */
public abstract class TestLifeForm {
	/**
	 * Create a life form appropriate to the subclass  we are testing
	 * @param points the number of life points the life form
	 * should be given
	 * @return the new object
	 */
	public abstract LifeForm createLifeForm(int points);
	
	/**
	 * Test hit randomly hitting lifeform
	 */
	@Test
	public void hitsHurtRandomly()
	{
		int originalHealth = 50;
		int weaponStrength = 5;
		int[] damage = new int[weaponStrength+1];
		int numberOfHits = 10000;
		for (int i = 0; i < numberOfHits; i++)
		{
			LifeForm deadFred = createLifeForm(originalHealth);
			deadFred.takeHit(weaponStrength);
			damage[originalHealth - deadFred.getLifePoints()]++;
		}
		
		int hitsPerDamage = numberOfHits / (weaponStrength + 1);
		int epsilon = (int)(hitsPerDamage * 0.15);
		for (int i = 0; i < damage.length; i++)
		{
			assertTrue("not enough examples of damage = " + i,
					(hitsPerDamage - epsilon) < damage[i]);
			assertTrue("too many enough examples of damage = " + i,
					(hitsPerDamage + epsilon) > damage[i]);
		}
	}
	
	/**
	 * Test weapon strength of lifeform
	 */
	@Test
	public void testWeaponStrength()
	{
		LifeForm it = createLifeForm(50);
		assertEquals(0, it.getCurrentWeaponStrength());
		it.pickUpWeapon(15);
		assertEquals(15, it.getCurrentWeaponStrength());
	}
	
	/**
	 * Test life form only picks up stronger weapon
	 */
	@Test
	public void pickUpWeakerWeapon()
	{
		LifeForm it = createLifeForm(50);
		it.pickUpWeapon(15);
		it.pickUpWeapon(14);
		assertEquals(15, it.getCurrentWeaponStrength());
	}
	
	/**
	 * Test that shooting decreases power of weapon
	 */
	@Test
	public void testShooting()
	{
		LifeForm it = createLifeForm(50);
		LifeForm victim = createLifeForm(30);
		it.pickUpWeapon(12);
		it.shoot(victim);
		assertEquals(11, it.getCurrentWeaponStrength());
		assertEquals(1,  victim.getNumberHitsTaken());
	}
	
	/**
	 * Test how many times the life form was hit
	 */
	@Test
	public void testHitCount()
	{
		LifeForm it = createLifeForm(50);
		assertEquals(0, it.getNumberHitsTaken());
		it.takeHit(5);
		assertEquals(1, it.getNumberHitsTaken());
		it.takeHit(5);
		assertEquals(2, it.getNumberHitsTaken());
	}
	
	/**
	 * Test shooting when life form has no weapon
	 */
	@Test
	public void testShootingNoWeaponStrength()
	{
		LifeForm it = createLifeForm(50);
		LifeForm victim = createLifeForm(30);
		it.shoot(victim);
		assertEquals(0, it.getCurrentWeaponStrength());
		assertEquals(0, victim.getNumberHitsTaken());
		assertEquals(30, victim.getLifePoints());
	}
	
}
