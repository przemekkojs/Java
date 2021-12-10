package Platnosci;

import Portfel.Portfel;

public class PlatnoscKarta implements IPlatnosc
{
	@Override
	public void Plac(Portfel portfel, double cena)
	{		
		portfel.GetKarta().Zaplac(cena);
	}
}