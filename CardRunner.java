public class CardRunner 
{
	public static void main(String[] args)
	{
		Card c1 = new Card(0,0);
		System.out.println(c1);
		
		Card c2 = new Card(12, 3);
		System.out.println(c2);
		
		System.out.println();
		Deck d = new Deck();
		System.out.println(d);
		
		d.shuffle();
	}
}
