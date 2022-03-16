package Pracownicy;

import Pracownik.Pracownik;

public class PracownikEtatowy extends Pracownik 
{	
	private static final long serialVersionUID = 1L;
	private double etat;
	private double stawka;
	
	public PracownikEtatowy()
	{
		super();
	}
	
	public PracownikEtatowy(String _imie, String _nazwisko, String _stanowisko, long _pesel, int _staz, double _etat, double _stawka)
	{
		super(_imie, _nazwisko, _stanowisko, _pesel, _staz);
		etat = _etat;
		stawka = _stawka;
	}
	
	@Override
	public String toString()
	{
		return String.format("%-20s%-20.2f|%-20.2f", super.toString(), etat, stawka);
	}
	
	@Override
	public double pensja() 
	{		
		return stawka * etat;
	}
}
