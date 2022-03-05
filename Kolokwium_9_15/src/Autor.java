
public class Autor 
{
	private String imie;
	private String nazwisko;
	
	public Autor(String _imie, String _nazwisko)
	{
		imie = _imie;
		nazwisko = _nazwisko;
	}
	
	public String GetNazwisko()
	{
		return nazwisko;
	}
	
	public String GetImie()
	{
		return imie;		
	}
	
	public String ToString()
	{
		return String.format("%s %s", nazwisko, imie);
	}
	
	public boolean Equals(Autor a)
	{
		if(a.imie == imie && a.nazwisko == nazwisko)
		{
			return true;
		}
		
		return false;
	}
}
