package Pracownicy;

import Pracownik.Pracownik;

public class PracownikGodzinowy extends Pracownik 
{	
	private static final long serialVersionUID = 1L;
	private int liczbaGodzin;
	private double stawka;
	
	public PracownikGodzinowy()
	{
		super();
	}
	
	public PracownikGodzinowy(String _imie, String _nazwisko, String _stanowisko, long _pesel, int _staz, int _liczbaGodzin, double _stawka)
	{
		super(_imie, _nazwisko, _stanowisko, _pesel, _staz);
		liczbaGodzin = _liczbaGodzin;
		stawka = _stawka;
	}
	
	@Override
	public String toString()
	{
		return String.format("%-20s%-20d|%-20.2f", super.toString(), liczbaGodzin, stawka);
	}
	
	@Override
	public double pensja() 
	{		
		return stawka * liczbaGodzin;
	}
}
