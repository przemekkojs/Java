package Pracownik;

import java.io.Serializable;

public class Pracownik implements Comparable<Pracownik>, Serializable
{	
	private static final long serialVersionUID = 1L;
	private long PESEL;
	private String initials;
	private String birthDate;
	private String position;
	private int salary;
	private int hours;
	
	public Pracownik(long p, String i, String bd, String pos, int s, int h)
	{
		PESEL = p;
		initials = i;
		birthDate = bd;
		position = pos;
		salary = s;
		hours = h;
	}
	
	public double Premia()
	{
		if(hours > 20)
		{
			return 0.2f * salary;
		}
		else if(hours > 10)
		{
			return 0.1f * salary;
		}
		
		return 0;
	}
	
	public long Pesel()
	{
		return PESEL;
	}
	
	public String Initials()
	{
		return initials;
	}
	
	public String BirthDate()
	{
		return birthDate;
	}
	
	public String position()
	{
		return position;
	}
	
	public int Salary()
	{
		return salary;
	}
	
	public int Hours()
	{
		return hours;	
	}
	
	@Override
	public int compareTo(Pracownik o) 
	{
		if(o.PESEL > PESEL)
		{
			return -1;
		}
		else if(o.PESEL < PESEL)
		{
			return 1;
		}
		
		return 0;
	}
	
	public String toString()
	{
		return String.format("%d, %s, %s, %s, %dz³, %d lat, %.2f premia", PESEL, initials, birthDate, position, salary, hours, Premia());
	}
}
