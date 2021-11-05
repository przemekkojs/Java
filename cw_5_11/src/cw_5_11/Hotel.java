package cw_5_11;

public class Hotel 
{
	public Pokoj[] Pokoje;
	
	public Hotel(int iloscPokoi)
	{
		Pokoje = new Pokoj[iloscPokoi];
		
		for(int index = 0; index < iloscPokoi; index++)
		{
			Pokoje[index] = new Pokoj(index);
		}
	}
	
	public void Wynajmij(int numer, Osoba os)
	{
		if(Pokoje[numer].Wlasciciel == null)
		{
			Pokoje[numer].Wynajmij(os);
		}
	}
	
	public void Zwolnij(int numer)
	{
		Pokoje[numer].Zwolnij();
	}
	
	public boolean SprawdzWlasciciela(int numer, String nazwisko)
	{
		if(nazwisko == Pokoje[numer].Wlasciciel.Nazwisko)
		{
			return true;
		}
		
		return false;
	}
	
	public void PokojeOsoby(Osoba os)
	{
		System.out.print("Pokoje " + os.Imie + " " + os.Nazwisko + ": ");
		
		for(int index = 0; index < Pokoje.length; index++)
		{
			if(Pokoje[index].Wlasciciel != null && Pokoje[index].Wlasciciel.Nazwisko == os.Nazwisko)
			{
				System.out.print(index + " ");
			}
		}
		
		System.out.println();
	}
	
	public int IleWolnychPokoi()
	{
		int res = 0;
		
		for(Pokoj p : Pokoje)
		{
			if(p.Wlasciciel == null)
			{
				res++;
			}
		}
		
		return res;
	}
}
