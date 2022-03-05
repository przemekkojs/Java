package Wielokaty;

import java.util.ArrayList;
import java.util.Comparator;

import Figura.Figura;

public class Wielokaty 
{
	private ArrayList<Figura> figury;
	
	private CompareKolor cKolor;
	private CompareA cA;
	private CompareAll cAll;
	
	public Wielokaty()
	{
		figury = new ArrayList<>();
		CreateComparators();
	}
	
	public ArrayList<Figura> GetFigury()
	{
		return figury;
	}

	public CompareKolor GetCompareKolor()
	{
		return cKolor;
	}
	
	private void CreateComparators()
	{
		cKolor = new CompareKolor();
		cA = new CompareA();
		cAll = new CompareAll();
	}	
	
	public CompareA GetCompareA()
	{
		return cA;
	}	
	
	public CompareAll GetCompareAll()
	{
		return cAll;
	}	
	
	public String najwiekszyObwod()
	{		
		if(figury.size() > 0)
		{
			int curMax = figury.get(0).Obwod();
			int curMaxIndex = 0;
			
			for(int index = 1; index < figury.size(); index++)
			{
				if(figury.get(index).Obwod() > curMax)
				{
					curMax = figury.get(index).Obwod();
					curMaxIndex = index;
				}
			}
			
			return String.format("Figura [%d] o najwiekszym obwodzie: %s, wartosc: %d%n", curMaxIndex, figury.get(curMaxIndex).toString(), curMax);
		}
		
		return "";
	}
	
	class CompareKolor implements Comparator<Figura>
	{
		@Override
		public int compare(Figura o1, Figura o2) 
		{
			if(o1.GetColor().compareTo(o2.GetColor()) > 0)
			{
				return 1;
			}
			else if(o1.GetColor().compareTo(o2.GetColor()) < 0)
			{
				return -1;
			}
			
			return 0;
		}		
	}
	
	class CompareA implements Comparator<Figura>
	{
		@Override
		public int compare(Figura o1, Figura o2) 
		{
			if(o1.GetA() > o2.GetA())
			{
				return 1;
			}
			else if(o1.GetA() < o2.GetA())
			{
				return -1;
			}
			
			return 0;
		}		
	}
	
	class CompareAll implements Comparator<Figura>
	{
		@Override
		public int compare(Figura o1, Figura o2) 
		{
			if(o1.GetColor().compareTo(o2.GetColor()) > 0)
			{
				if(o1.GetA() > o2.GetA())
				{
					return 2;
				}
				else if(o1.GetA() < o2.GetA())
				{
					return 0;
				}

				return 1;
			}
			else if(o1.GetColor().compareTo(o2.GetColor()) < 0)
			{
				if(o1.GetA() > o2.GetA())
				{
					return 0;
				}
				else if(o1.GetA() < o2.GetA())
				{
					return -2;
				}

				return -1;
			}
			
			return 0;
		}		
	}
}