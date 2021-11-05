package cw_5_11;

public class Pokoj 
{	
	public int Numer;
	public Osoba Wlasciciel;
	
	public Pokoj(int numer)
	{
		Numer = numer;
	}
	
	public void Wynajmij(Osoba osoba)
	{
		Wlasciciel = osoba;
	}
	
	public void Zwolnij()
	{
		Wlasciciel = null;
	}
}
