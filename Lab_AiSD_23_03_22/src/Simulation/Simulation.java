package Simulation;

import java.util.Random;

import Karta.Karta;
import List.LinkedList;

public class Simulation 
{
	private LinkedList<Karta> list;
	private boolean[] tab;
	
	private int covered;
	private int shown;
	
	public Simulation()
	{
		list = new LinkedList<Karta>();
		tab = new boolean[52];
		
		for(int i = 0; i < tab.length; i++)
		{
			tab[i] = false;
		}
		
		covered = tab.length;
		shown = 0;
	}
	
	public void Init()
	{
		Random random = new Random();
		
		int value = random.nextInt(15);
		int color = random.nextInt(4);
		
		while(value != 0)
		{			
			if(value != 14 && color * 13 + value < 52)
			{
				if(tab[color * 13 + (value - 1)] == false)
				{
					Karta toAdd = new Karta(color, value, true);
					System.out.println(toAdd.toString());
					
					tab[color * 13 +  (value - 1)] = true;
					Add(toAdd);					
				}				
			}		
			
			value = random.nextInt(15);
			color = random.nextInt(4);
		}	
		
		AddCovered();
	}
	
	public void RemoveCovered()
	{
		int startIndex = 0;
		
		while(list.get(startIndex).GetZnacznik())
		{
			startIndex++;
		}
		
		while(list.size() > startIndex)
		{
			list.remove();
		}
	}
	
	public String Write()
	{
		String res = "";
		
		res += ("\n");
		res += ("Karty:\n");		
		
		for(Karta k : list)
		{
			res += (k.toString() + "\n");
		}
		
		res += ("=================================\n");	
		
		return res;
	}
	
	public String WriteColor(int color)
	{
		String res = "";
		
		res += ("\n");
		res += ("Karty o kolorze " + color + ":\n");		
		
		for(Karta k : list)
		{
			if(k.GetKolor() == color && k.GetZnacznik() == true)
			{
				res += (k.toString() + "\n");
			}			
		}
		
		res += ("=================================\n");	
		
		return res;
	}
	
	public String WriteValue(int value)
	{
		String res = "";
		
		res += ("\n");
		res += ("Karty o wartoœci " + value + ":\n");		
		
		for(Karta k : list)
		{
			if(k.GetWartosc() == value && k.GetZnacznik() == true)
			{
				res += (k.toString() + "\n");
			}			
		}
		
		res += ("=================================\n");	
		
		return res;
	}
	
	public String ShowInfo()
	{
		return String.format("Odkryte: %d, Zakryte: %d, Iloœæ w talii: %d", shown, covered, list.size());
	}
	
	public int Shown()
	{
		return shown;
	}
	
	public int Covered()
	{
		return covered;
	}
	
	private void AddCovered()
	{
		int color = 0;
		int value = 0;
		
		for(boolean b : tab)
		{
			if(value > 12)
			{
				value = 0;
				color++;
			}
			
			if(b == false)
			{
				list.add(new Karta(color, value, false));
			}
			
			value++;
		}
	}
	
	private void Add(Karta toAdd)
	{			
		int index = 0;
		
		while(index < list.size())
		{
			if(toAdd.GetKolor() <= list.get(index).GetKolor())
			{
				break;
			}
			
			index++;
		}
		
		while(index < list.size())
		{
			if(toAdd.GetKolor() != list.get(index).GetKolor() || toAdd.GetWartosc() < list.get(index).GetWartosc())
			{
				break;
			}
			
			index++;
		}
		
		list.add(toAdd, index);
		covered--;
		shown++;
	}
}