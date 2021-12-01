public class Lokata 
{
	private int numerLokaty;
	private double kwota;
	private boolean czyZerwana;
	
	public Lokata()
	{
		numerLokaty = 0;
		kwota = 0;
		czyZerwana = false;
	}
	
	public Lokata(int _numerLokaty, double _kwota, boolean _czyZerwana)
	{
		numerLokaty = _numerLokaty;
		kwota = _kwota;
		czyZerwana = _czyZerwana;
	}
	
	public String ToString()
	{
		return String.format("lokata %s: %.2f z³, zerwana: %b%n", numerLokaty, kwota, czyZerwana);
	}
	
	public double GetKwota()
	{
		return kwota;
	}
}