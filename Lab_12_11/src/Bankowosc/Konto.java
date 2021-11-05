package Bankowosc;

public class Konto
{
	private int numerKonta;
	private double saldo;
	
	public Konto()
	{
		numerKonta = 0;
		saldo = 0;
	}
	
	public Konto(int numer, double saldo)
	{
		this.saldo = saldo;
		numerKonta = numer;
	}
	
	public int GetNumerKonta()
	{
		return numerKonta;
	}
	
	public double GetSaldo()
	{
		return saldo;
	}
	
	public void SetNumerKonta(int nowyNumer)
	{
		numerKonta = nowyNumer;
	}
	
	public void SetSaldo(double noweSaldo)
	{
		saldo = noweSaldo;
	}
	
	public void GetStan()
	{
		System.out.printf("Numer konta: %d Saldo: %f%n", this.numerKonta, this.saldo);
	}
}
