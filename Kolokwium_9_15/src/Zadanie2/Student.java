package Zadanie2;

public class Student 
{
	private int NumerIndeksu;
	private String Nazwisko;
	private String Imie;
	private float Ocena1;
	private float Ocena2;
	private float Ocena3;
	
	public Student(int nr, String n, String i, float o1, float o2, float o3)
	{
		NumerIndeksu = nr;
		Nazwisko = n;
		Imie = i;
		Ocena1 = o1;
		Ocena2 = o2;
		Ocena3 = o3;
	}	
	
	@Override
	public String toString()
	{
		return String.format("%d	%s	%s	%.1f	%.1f	%.1f", NumerIndeksu, Nazwisko, Imie, Ocena1, Ocena2, Ocena3);
	}
}
