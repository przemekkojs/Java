package Osoba;

import java.io.Serializable;
import java.util.Random;

import Portfel.Portfel;
import Portfel.SrodekPlatnosci;

public class Osoba implements Serializable
{	
	private static final long serialVersionUID = 1L;
	private static double zadluzenie;
	private static Portfel portfel;
	
	public Osoba()
	{
		zadluzenie = 0;
		portfel = null;
	}
	
	public Osoba(Portfel _portfel)
	{
		portfel = _portfel;
	}
	
	public void IdzDoSklepu(double cena)
	{			
		portfel.Zaplac(cena);
		portfel.StanPortfela();
	}
	
	public void Kredyt(SrodekPlatnosci srodek, double ilosc)
	{
		srodek.Zarob(ilosc);
		zadluzenie += (ilosc + 0.15d * ilosc);
	}
	
	public void Splac(double ilosc)
	{
		zadluzenie -= ilosc;
	}
	
	public void StanZadluzenia()
	{
		System.out.printf("Zadlozenie: %.2f%n", zadluzenie);
	}
	
	public double Zadluzenie()
	{
		return zadluzenie;
	}
	
	public Portfel GetPortfel()
	{
		return portfel;
	}
	
	public void Sprzedaj(double cena)
	{
		Random random = new Random();
		double value = cena + cena * (random.nextDouble() - 0.5d);
		portfel.GetSrodki()[0].Zarob(value);
		System.out.printf("Sprzedano produkt o wartosci %.2f za %.2f. Zysk: %.2f.%n", cena, value, value - cena);
	}
}