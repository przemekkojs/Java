package Platnosci;

import Portfel.Portfel;

public class MetodaPlatnosci 
{
	private IPlatnosc p;

	public MetodaPlatnosci(IPlatnosc _p)
	{
		p = _p;
	}
	
	public void Zaplac(Portfel portfel, double cena)
	{
		p.Plac(portfel, cena);
	}
}
