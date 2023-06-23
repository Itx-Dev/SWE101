/**
 * @author Devin
 */
public class Zombie extends LifeForm 
{	
	/**
	 * @param fullLifePoints
	 */
	public Zombie(int fullLifePoints)
	{
		lifePoints = fullLifePoints;
	}
	
	/**
	 * Zombies can recover
	 */
	public void recover()
	{
		int recoveredDamage = (int) (randomDamage * 0.10);
		lifePoints += recoveredDamage;
	}
	

}
