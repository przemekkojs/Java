public class Ksiazka
{
	private Autor autor;
	private String tytul;
	private String wydawnictwo;
	private int rokWydania;	
	
	public Ksiazka(Autor a, String t, String w, int r)
	{
		autor = a;
		tytul = t;
		wydawnictwo = w;
		rokWydania = r;		
	}
	
	public Autor GetAutor()
	{
		return autor;
	}
	
	public String GetTytul()
	{
		return tytul;
	}
	
	public String GetWydawnictwo()
	{
		return wydawnictwo;
	}
	
	public int GetRokWydania()
	{
		return rokWydania;
	}
	
	public String ToString()
	{
		return String.format("%s	, tytul: %s	, wydawnictwo %s	, rok wydania: %d	", autor.ToString(), tytul, wydawnictwo, rokWydania);
	}	
}