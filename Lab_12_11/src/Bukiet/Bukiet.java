package Bukiet;

public class Bukiet 
{
	private Kwiat kwiat = new Kwiat();
	private boolean dostepny;
	
	public Bukiet()
	{
		kwiat.SetNazwa(0);
		dostepny = false;
	}
	
	public Bukiet(int numer, boolean d)
	{
		kwiat.SetNazwa(numer);
		dostepny = d;
	}	
	
	public Kwiat GetKwiat()
	{
		return kwiat;
	}
	
	public boolean GetDostepny()
	{
		return dostepny;
	}
	
	public void SetDostepny(boolean value)
	{
		dostepny = value;
	}
	
	public void SetKwiat(Kwiat kwiat)
	{
		this.kwiat = kwiat;
	}
	
	public void JestWKwiaciarni()
	{
		SetDostepny(true);
	}
	
	public void NieMaWKwiaciarni()
	{
		SetDostepny(false);
	}
}
