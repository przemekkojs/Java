public class Function 
{
	public Note Soprano;
	public Note Alto;
	public Note Tenore;
	public Note Bass;
	
	public boolean StrongMeasure;	
	public TonationManager Tonation;
	
	public Function(Note soprano, Note alto, Note tenore, Note bass, boolean strongMeasure, TonationManager tonation)
	{
		Soprano = soprano;
		Alto = alto;
		Tenore = tenore;
		Bass = bass;
		
		StrongMeasure = strongMeasure;
		Tonation = tonation;
	}
	
	public Function Translate(String name, String extention, String alteration, boolean strongMeasure)
	{		
		Note soprano = new Note();
		Note alto = new Note();
		Note tenore = new Note();
		Note bass = new Note();
		
		switch(name)
		{
		default: //Tonic
			soprano = new Note(4, Tonation.Tonation[Tonation.tonationIndex][0]);
			alto = new Note(4, Tonation.Tonation[Tonation.tonationIndex][4]);
			tenore = new Note(4, Tonation.Tonation[Tonation.tonationIndex][7]);
			bass = new Note(4, Tonation.Tonation[Tonation.tonationIndex][0]);
			return new Function(soprano, alto, tenore, bass, strongMeasure, Tonation);
		}
	}
}