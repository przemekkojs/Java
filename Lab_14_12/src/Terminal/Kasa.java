package Terminal;

import Platnosci.MetodaPlatnosci;
import Platnosci.PlatnoscGotowka;
import Platnosci.PlatnoscKarta;
import Portfel.Gotowka;
import Portfel.Karta;
import Portfel.Portfel;

public class Kasa 
{
	private static Portfel portfel = new Portfel(new Karta(10, 200d), new Gotowka(200d));
	private static double cena;
	
	public static void main(String args[])
	{
		cena = 200d;		
		MetodaPlatnosci metoda = new MetodaPlatnosci(new PlatnoscGotowka());;
		
		if(portfel.GetKarta().CzyWystarczy(cena))
		{
			metoda = new MetodaPlatnosci(new PlatnoscKarta());
			metoda.Zaplac(portfel, cena);
		}
		else if(portfel.GetGotowka().CzyWystarczy(cena))
		{
			metoda.Zaplac(portfel, cena);
		}
		else
		{						
			cena -= portfel.GetGotowka().GetStan();
			metoda.Zaplac(portfel, portfel.GetKarta().GetStan());
			metoda = new MetodaPlatnosci(new PlatnoscKarta());
			metoda.Zaplac(portfel, cena);
		}
	}
}
