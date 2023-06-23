/**
 * @author Devin
 */
public class LifeForm 
{
	protected static int backpackSize = 10;
	
	protected int lifePoints;
	protected int weaponStrength;
	protected int numberOfHitsTaken;
	protected int randomDamage;
	int[] weaponsBackPack = new int[backpackSize];

	/**
	 * @return life points
	 */
	public int getLifePoints() 
	{
		if (lifePoints < 0)
		{
			return 0;
		} 
		else 
		{
			return lifePoints;
		}
	}
	
	/**
	 * @return weaponStrength
	 */
	public int getCurrentWeaponStrength()
	{
		return weaponStrength;
	}
	
	/**
	 * @return number of hits life form takes
	 */
	public int getNumberHitsTaken()
	{
		return numberOfHitsTaken;
	}

	/**
	 * @param strengthOfWeapon 
	 */
	public void takeHit(int strengthOfWeapon) 
	{
		int minValue = 0;
		randomDamage = (int) (Math.random() * (strengthOfWeapon - minValue + 1) + minValue); 
		if (strengthOfWeapon > 0)
		{
			lifePoints -= randomDamage;
			numberOfHitsTaken++;	
		}
	}
	
	/**
	 * Change lifeform's weapon's strength
	 * @param strength
	 */
	public void pickUpWeapon(int strength)
	{
		int i = 0;
		while (i < weaponsBackPack.length)
		{
			// If backpack slot is empty and item picked up
			// is weaker than current weapon
			if (weaponsBackPack[i] == 0 && weaponStrength >= strength)
			{
				weaponsBackPack[i] = strength;
				break;
			} 
			else 
			{
				i++;
			}
		}
		
		if (strength > weaponStrength)
		{
			weaponStrength = strength;
		}
	}
	
	/**
	 * @param otherPlayer 
	 * 
	 */
	public void shoot(LifeForm otherPlayer)
	{
		otherPlayer.takeHit(weaponStrength);
		if (weaponStrength > 0)
		{
			weaponStrength--;
		}
	}


	
}
