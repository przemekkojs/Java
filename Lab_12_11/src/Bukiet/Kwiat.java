package Bukiet;

public class Kwiat 
{
	private int nazwa;
	
	public Kwiat(int nazwa)
	{
		this.nazwa = nazwa;
	}
	
	public Kwiat()
	{
		nazwa = 0;
	}	
	
	public int GetNazwa()
	{
		return nazwa;
	}
	
	public void SetNazwa(int n)
	{
		nazwa = n;
	}
}
