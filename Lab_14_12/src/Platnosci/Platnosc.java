package Platnosci;

import Portfel.SrodekPlatnosci;

public class Platnosc implements IPlatnosc
{
	@Override
	public void Plac(SrodekPlatnosci srodek, double cena) 
	{
		double zaplacono = srodek.GetStan();			
		srodek.Zaplac(cena);
		cena -= zaplacono;
	}
}