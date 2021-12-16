package Portfel;

import Platnosci.MetodaPlatnosci;
import Platnosci.Platnosc;

public class Portfel 
{
	private SrodekPlatnosci[] srodki;
	
	public Portfel()
	{
		srodki = null;
	}
	
	public Portfel(SrodekPlatnosci[] _srodki)
	{
		srodki = _srodki;
	}
	
	public void Zaplac(double cena)
	{
		MetodaPlatnosci metoda = new MetodaPlatnosci(new Platnosc());
		int index = 0;
		
		while(index < this.GetSrodki().length && cena > 0)
		{			
			System.out.printf("Pozostalo do zaplaty: %.2f, %s", cena, this.GetSrodki()[index].ToString());			
			double zaplacono = this.GetSrodki()[index].GetStan();			
			metoda.Zaplac(this.GetSrodki()[index], cena);
			cena -= zaplacono;
			index++;			
		}	
		
		if(cena > 0)
		{
			System.out.printf("Nie udalo sie zaplacic%n----------------------------%n");
		}
		else
		{
			System.out.printf("Udalo sie zaplacic%n----------------------------%n");
		}	
	}
	
	public void StanPortfela()
	{		
		System.out.printf("Stan portfela:%n%s", this.ToString());		
	}
	
	public String ToString()
	{
		String res = "";
		
		int index = 0;
		
		for(SrodekPlatnosci s : srodki)
		{
			res += String.format("%d. %s", index, s.ToString());
			index++;
		}
		
		return res;
	}
	
	public double Lacznie()
	{
		double res = 0;
		
		for(SrodekPlatnosci s : srodki)
		{
			res += s.GetStan();
		}
		
		return res;
	}
	
	public SrodekPlatnosci[] GetSrodki()
	{
		return srodki;
	}
	
	public boolean CzyPusty()
	{		
		for(SrodekPlatnosci s : srodki)
		{
			if(s.GetStan() > 0)
			{
				return false;
			}
		}
		
		return true;
	}
}
