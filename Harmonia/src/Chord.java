public class Chord 
{
	public Note Root;
	public Note Third;
	public Note Fifth;
	public Note Sixth;
	public Note Seventh;
	public Note Ninth;
	
	public Chord(Note root, Note third, Note fifth, Note sixth, Note seventh, Note ninth)
	{
		Root = root;
		Third = third;
		Fifth = fifth;
		Sixth = sixth;
		Seventh = seventh;
		Ninth = ninth;
	}
}