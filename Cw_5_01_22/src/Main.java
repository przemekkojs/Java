import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Main 
{
	private static ArrayList<String> slowa = new ArrayList<String>();
	private static TreeSet<Integer> liczby = new TreeSet<Integer>();
	private static HashSet<Double> rzeczywiste = new HashSet<Double>();
	
	public static void main(String[] args) 
	{
		Slowa();
		Liczby();
		Rzeczywiste();
	}
	
	public static void Slowa()
	{
		slowa.add("Jeden");
		slowa.add("Dwa");
		slowa.add("Trzy");
		
		Write(slowa.toArray());
		
		slowa.remove("Dwa");
		
		Write(slowa.toArray());
	}
	
	public static void Liczby()
	{
		liczby.add(0);
		liczby.add(2);
		liczby.add(1);
		liczby.add(7);
		liczby.add(4);
		
		Write(liczby.toArray());
	}
	
	public static void Rzeczywiste()
	{
		rzeczywiste.add(9.0);
		rzeczywiste.add(2.0);
		rzeczywiste.add(7.0);
		rzeczywiste.add(3.0);		
		rzeczywiste.add(8.0);	
	
		Iterator<Double> i = rzeczywiste.iterator();
		
		while(i.hasNext())
		{
			Write(new Object[] {i.next().hashCode()});
		}
		
		Write(rzeczywiste.toArray());
	}
	
	public static<T> void Write(T[] array)
	{
		for(T e : array)
		{
			System.out.println(e);
		}
	}
}
