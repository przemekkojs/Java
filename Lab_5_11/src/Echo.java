
public class Echo {

	public static void main(String[] args) 
	{
		Zwierzak zwierzak = new Zwierzak();
		Roslina roslina = new Roslina(10);
		
		int index = 0;
		
		while(roslina.Dlugosc > 0)
		{			
			roslina.Rosnij();
			System.out.print("Wzrost o 1: ");
			roslina.Pokaz();
			
			zwierzak.Zjedz(roslina, 2);
			System.out.print("Zwierzak zjada o 2: ");
			roslina.Pokaz();
			
			if(index%3 == 0)
			{
				roslina.RosnijDuzo(2);
				System.out.print("Wzrost o 2: ");
				roslina.Pokaz();
			}
			
			index++;			
		}
	}
}
