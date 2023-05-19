public class Card 
{
	private static final String[] SUIT_DESCRIPTION = 
		{"Spades", "Hearts", "Diamonds", "Clubs"};
	private static final String[] FACE_VALUE_DESCRIPTION = 
		{"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "Jack", "Queen", "King"};
 	private int suit;
	private int faceValue;
	
	public Card(int v, int s)
	{
		faceValue = v;
		suit = s;
	}
	
	public int getSuit()
	{
		return suit;
	}
	
	public int getValue()
	{
		return faceValue;
	}
	
	public String toString()
	{
		return FACE_VALUE_DESCRIPTION[faceValue] + " of " + SUIT_DESCRIPTION[suit];
	}
}
