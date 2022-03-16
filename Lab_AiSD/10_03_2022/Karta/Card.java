package Karta;

public class Card 
{
	private int value;
	private int color;
	
	public Card(int _value, int _color)
	{
		value = _value;
		color = _color;
	}
	
	public int GetValue()
	{
		return value;
	}
	
	public int GetColor()
	{
		return color;
	}
	
	public String toString()
	{
		return String.format("Wartosc: %d, Kolor: %d", value, color);
	}
	
	public boolean Equals(Card card)
	{
		if(card.GetColor() == color && card.GetValue() == value)
		{
			return true;
		}
		
		return false;
	}
}