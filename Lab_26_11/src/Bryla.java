public abstract class Bryla 
{
	private String nazwa;
	private int wysokosc;
	
	public Bryla()
	{
		nazwa = "";
		wysokosc = 0;
	}
	
	public Bryla(String _nazwa, int _wysokosc)
	{
		nazwa = _nazwa;
		wysokosc = _wysokosc;
	}
	
	public String ToString()
	{
		return String.format("Bryla o nazwie: %s%n", nazwa);
	}
	
	public int GetWysokosc()
	{
		return wysokosc;
	}
	
	public String GetNazwa()
	{
		return nazwa;
	}
	
	public abstract double Objetosc();
	public abstract double Pole();
}
