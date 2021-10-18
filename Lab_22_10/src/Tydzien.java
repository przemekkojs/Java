public class Tydzien 
{
	public static void main(String[] args) 
	{
		//Przyj¹³em numeracjê 1 - pon, 2 - wt itd.
		
		//Wszystkie przypadki:
		Day(1,0,0);
		Day(2,1000,0.85d);
		Day(3,0,0);
		Day(4,0,0);
		Day(5,0,0);
		Day(6,0,0);
		Day(7,0,0);
		Day(8,0,0);
	}
	
	public static double Training(int count, double length)
	{
		return count * length;
	}
	
	public static void Day(int num, int count, double length)
	{
		switch(num)
		{
		case 1:
			System.out.println("Poniedzialek");	
			break;
		case 2:
			System.out.printf("Wtorek, trening dla dlugosci kroku %f i ilosci %d: %f%n", length, count, Training(count, length));	
			break;
		case 3:
			System.out.println("Sroda");	
			break;
		case 4:
			System.out.println("Czwartek");	
			break;
		case 5:
			System.out.println("Piatek");	
			break;
		case 6:
			System.out.println("Sobota");	
			break;
		case 7:
			System.out.println("Niedziela");	
			break;
		default:
			System.out.println("Mamy tylko 7 dni w tygodniu ;)");
		}	
	}
}
