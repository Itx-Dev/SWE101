public class Deck 
{
	private static final int NUMBER_OF_SUITS = 4;
	private static final int NUMBER_OF_CARDS = 52;
	Card[] cards;
	
	public Deck()
	{
		cards = new Card[NUMBER_OF_CARDS];
		int position = 0;
		for (int suit = 0; suit < NUMBER_OF_SUITS; suit++)
		{
			for (int faceValue = 0; faceValue < NUMBER_OF_CARDS / NUMBER_OF_SUITS; faceValue++) 
			{
				cards[position] = new Card(faceValue, suit);
				position++;
			}
		}
	}
	
	public final String toString()
	{
		String s = new String();
		for (int i = 0; i < cards.length; i++)
		{
			s = s + cards[i] + "\n";
		}
		return s;
	}
	
	public final void shuffle()
	{
		for (int i = 0; i< NUMBER_OF_CARDS; i++)
		{
			int swapPosition = (int)(Math.random() * (NUMBER_OF_CARDS - i) + i);
			Card temp = cards[i];
			cards[i] = cards[swapPosition];
			cards[swapPosition] = temp;
		}
	}
}
