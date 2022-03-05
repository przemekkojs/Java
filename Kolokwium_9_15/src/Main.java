public class Main 
{
	private static Biblioteka b = new Biblioteka();
	
	public static void main(String[] args) 
	{
		b.Add(new Ksiazka(new Autor("A", "A"), "2", "w1", 2002));
		b.Add(new Ksiazka(new Autor("A", "B"), "1", "w1", 2001));
		b.Add(new Ksiazka(new Autor("B", "C"), "3", "w2", 2003));
		b.Add(new Ksiazka(new Autor("B", "C"), "6", "w2", 2003));
		b.Add(new Ksiazka(new Autor("B", "C"), "7", "w3", 2003));
		b.Add(new Ksiazka(new Autor("C", "A"), "4", "w1", 2007));
		b.Add(new Ksiazka(new Autor("C", "A"), "5", "w3", 2007));
		
		b.WriteByTitle();	
		
		b.WriteBy(new Autor("C", "A"));
		b.WriteDistributor("w1");
		
		b.Remove(new Autor("A", "A"));		
		b.WriteByAuthor();
	}
}
