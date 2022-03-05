public class Przemyslaw_Kojs_Zadanie3 
{
	public static void main(String[] args) 
	{
		Przemyslaw_Kojs_KomputerTab tab = new Przemyslaw_Kojs_KomputerTab(10);
		
		tab.Add("A", "a1", 16, 4, 3.5, "p1");
		tab.Add("A", "a2", 16, 6, 4.5, "p2");
		tab.Add("A", "a3", 32, 8, 5.5, "p3");
		tab.Add("B", "b1", 8, 4, 3.5, "p1");
		tab.Add("B", "b2", 8, 6, 3.5, "p2");
		tab.Add("B", "b3", 8, 8, 3.5, "p3");
		
		tab.Show();		
		tab.Show("A", 3.5, "p1");
	}
}
