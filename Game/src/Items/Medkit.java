package Items;

import Processors.Constants;

public class Medkit extends Item
{
	private int RegenerationAmount;
	
	public Medkit(int regenerationAmount) 
	{
		super("Medkit", true, Constants.MEDKITS_AT_BEGIN, Constants.MEDKIT_BODY);		
		RegenerationAmount = regenerationAmount;
	}	
	
	public int Regeneration()
	{
		return RegenerationAmount;
	}
}