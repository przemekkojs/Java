
public class Zamowienie 
{
	private int liczbaSztuk;
	private String nazwa;
	private double cena;
	
	public Zamowienie(String _n, int _ls, double _c)
	{
		nazwa = _n;
		liczbaSztuk = _ls;
		cena = _c;
	}	
	
	public double Serve()
	{
		System.out.println("-> nazwa zamowienia: " + nazwa + ", kwota do zap³aty = " + (liczbaSztuk * cena * 1.0d) + ", iloœæ sztuk: " + liczbaSztuk + ", cena: " + cena);
		return liczbaSztuk * cena * 1.0d;
	}
}