package Platnosci;

import Portfel.Portfel;

public class PlatnoscGotowka implements IPlatnosc
{
	@Override
	public void Plac(Portfel portfel, double cena)
	{
		portfel.GetGotowka().Zaplac(cena);
	}
}