package Deck;

import java.util.ArrayList;
import java.util.Iterator;

import Karta.Card;

public class Deck 
{
	private ArrayList<Card> deck;
	
	public Deck()
	{
		deck = new ArrayList<Card>();
	}
	
	public ArrayList<Card> GetDeck()
	{
		return deck;
	}
	
	public void Init(Card card)
	{
		deck.add(card);
	}
	
	public void Add(Card card)
	{
		int valueIndex = 0;
		int colorIndex = 0;
		
		while(valueIndex < deck.size() && deck.get(valueIndex).GetValue() < card.GetValue())
		{
			valueIndex++;
		}
		
		while(valueIndex + colorIndex < deck.size() && deck.get(valueIndex + colorIndex).GetColor() < card.GetColor() && deck.get(valueIndex + colorIndex).GetValue() == card.GetValue())
		{
			colorIndex++;
		}
		
		deck.add(valueIndex + colorIndex, card);
	}
	
	public void Trim()
	{
		int index = 0;
		
		while(index < deck.size() - 1)
		{
			if(deck.get(index).Equals(deck.get(index + 1)))
			{
				deck.remove(index);
				index--;
			}
			
			index++;
		}
	}
	
	public void WriteDeck()
	{
		System.out.println("Talia:");
		
		for(int index = 0; index < deck.size(); index++)
		{
			System.out.println(deck.get(index).toString());
		}
		
		System.out.println();
	}
	
	public void WriteSize()
	{
		System.out.println("Iloœæ kart: " + deck.size());
		System.out.println();
	}
	
	public void WriteValued(int value)
	{
		System.out.println("Karty o wartoœci " + value + ":");
		
		for(Card c : deck)
		{
			if(c.GetValue() == value)
			{
				System.out.println(c.toString());
			}			
		}
		
		System.out.println();
	}
	
	public void WriteColor(int color)
	{
		System.out.println("Karty o kolorze " + color + ":");
		Iterator<Card> i = deck.iterator();
		
		while(i.hasNext())
		{
			Card c = i.next();
			
			if(c.GetColor() == color)
			{
				System.out.println(c.toString());
			}	
		}
		
		System.out.println();
	}
}
