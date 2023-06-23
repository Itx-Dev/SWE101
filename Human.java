/**
 * @author Devin
 */
public class Human extends LifeForm
{	

	/**
	 * @param points
	 */
	public Human(int points)
	{
		lifePoints = points;
	}
	
	/**
	 * @return number of weapons in backpack
	 */
	public int numberWeaponsInBackPack()
	{
		int counter = 0;
		for (int i = 0; i < weaponsBackPack.length; i++)
		{
			if (weaponsBackPack[i] != 0)
			{
				counter++;
				System.out.println();
			}
		}
		return counter;
	}
	
	
	/**
	 * @param strength
	 * @return true if current weapon matches strength else return false
	 */
	public boolean isCarryingWeapon(int strength)
	{
		for (int i = 0; i < weaponsBackPack.length; i++)
		{
			if (strength == weaponsBackPack[i])
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Swap better weapon in backpack for current
	 */
	public void swapBestWeapon()
	{
		for (int i = 0; i < backpackSize; i++)
		{
			if (weaponsBackPack[i] > weaponStrength)
			{
				int temp = weaponStrength;
				weaponStrength = weaponsBackPack[i];
				weaponsBackPack[i] = temp;
			}
		}
	}
}
