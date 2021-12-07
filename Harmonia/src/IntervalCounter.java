public class IntervalCounter 
{
	public int Semitones(Note note1, Note note2, TonationManager tonation)
	{		
		int note1Index = 0;
		int note2Index = 0;
		
		while(tonation.Tonation[tonation.tonationIndex][note1Index] != note1.Name)
		{
			note1Index++;
		}
		
		while(tonation.Tonation[tonation.tonationIndex][note2Index] != note1.Name)
		{
			note2Index++;
		}
	
		return Math.max(note1Index, note2Index) + (Math.abs(note1.Octave - note2.Octave) * 12);
	}
}