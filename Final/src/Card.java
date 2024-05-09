public class Card implements Comparable<Card>
{
	/**
	 * Construct a Card
	 * @param n the number of the card in the deck: range 1-13
	 * @param s the string description of the card: "D" or "C" or "H" or "S"
	 */
	public Card(int n, String s)
	{
		if(n <= 0 || n > 13)
			throw new IllegalArgumentException("Illegal Card: range is 1-13");
		if(s.length() != 1)
			throw new IllegalArgumentException("Suit must be a 1-character string");
		char c = Character.toUpperCase(s.charAt(0));
		if("DCHS".indexOf(c) < 0)
			throw new IllegalArgumentException("Suit must be \"D\" or \"C\" or \"H\" or \"S\"");
		number = n;
		suit = s.toUpperCase( );
	}
	
	/**
	 * Provided so that the cards can be sorted.  The cards are sorted first by suit
	 * (clubs, diamonds, hearts, spades) and then by card number.
	 * @param other - the card to be compared to this card
	 * @return 0 (equal cards) or 1 (this card is higher than other)
	 * or -1 (this card is lower than other)
	 */
	public int compareTo(Card other)
	{
		if(suit.equals(other.suit))
		{
            return Integer.compare(number, other.number);
		}
		if(suit.equals("S"))
			return 1;
		else if(suit.equals("H") && (other.suit.equals("C") || other.suit.equals("D")))
			return 1;
		else if(suit.equals("C") && other.suit.equals("D"))
			return 1;
		else
			return -1;
	}
	
	/**
	 * @return the string representation of the card
	 */
	public String toString( )
	{
		String str = "";
		switch(number)
		{
		case 1:
			str = "A"; break;
		case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
			str += number; break;
		case 10:
			str = "T"; break;
		case 11:
			str = "J"; break;
		case 12:
			str = "Q"; break;
		case 13:
			str = "K"; break;
		default:
			str = "error";
		}
		if(suit.equals("H") || suit.equals("C") || suit.equals("S") || suit.equals("D"))
			return str + suit;
		else
			return "error";
	}

	public String getSuit() {
		return suit;
	}

	public int getNumber() {
		return number;
	}

	private final int number;
	private final String suit;
}
