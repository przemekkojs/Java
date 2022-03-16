package Pracownik;

import java.io.Serializable;

public abstract class Pracownik implements Serializable
{	
	private static final long serialVersionUID = 1L;
	
	protected String nazwisko;
	protected String imie;
	protected String stanowisko;
	protected long pesel;	
	protected int staz;
	
	public Pracownik()
	{
		imie = "Imie";
		stanowisko = "Nikt";
		pesel = 1000000000;
		staz = 0;
	}
	
	public Pracownik(String _imie, String _nazwisko, String _stanowisko, long _pesel, int _staz)
	{
		imie = _imie;
		nazwisko = _nazwisko;
		stanowisko = _stanowisko;
		pesel = _pesel;
		staz = _staz;
	}
	
	@Override
	public String toString()
	{
		double p = pensja();
		String s = String.format("%-20s|%-20s|%-20d|%-20s|%-20d|%-20.2f|", nazwisko, imie, pesel, stanowisko, staz, p);
		return s;
	}
	
	public void Wyswietl()
	{
		System.out.printf("%s%n", toString());
	}
	
	public abstract double pensja();	
}