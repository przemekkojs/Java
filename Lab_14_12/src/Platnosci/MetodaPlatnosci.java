package Platnosci;

import Portfel.SrodekPlatnosci;

public class MetodaPlatnosci 
{
	private IPlatnosc p;

	public MetodaPlatnosci(IPlatnosc _p)
	{
		p = _p;
	}
	
	public void Zaplac(SrodekPlatnosci srodek, double cena)
	{
		p.Plac(srodek, cena);
	}
}
