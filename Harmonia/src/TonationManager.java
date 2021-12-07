public class TonationManager 
{
	public String[][] Tonation = new String[12][];		
	public String CurrentTonation;
	
	protected int tonationIndex;
	
	public TonationManager()
	{
		CurrentTonation = "C";
		tonationIndex = 0;
		Tonation[0] = new String[]{"C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "B", "H"};
	}
	
	public void SetTonation(String newTonation)
	{
		CurrentTonation = newTonation;
		int index = 0;
		
		while(Tonation[index][0] != CurrentTonation)
		{
			index++;
		}		
		
		tonationIndex = index;
	}
}