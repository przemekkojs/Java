package project;

public class Main 
{	
	private static final String readPath = "input.txt";
	private static final String writePath = "output.txt";
	
	private static String text;	
	private static String codedText;
	
	private static HuffmannTree tree;
	
	public static void main(String[] args)
	{
		init();
		write();
		code();
		save();
	}
	
	private static void init()
	{
		text = TextReader.read(readPath);		
		Node root = TextReader.convertToSortedNodeVector(text);
		tree = new HuffmannTree(root);
	}
	
	private static void code()
	{		
		tree.makeTree(tree.root());	
		codedText = tree.codeText(tree.root(), text);
		System.out.println(codedText);
		tree.printCodes();		
	}
	
	private static void save()
	{
		TextWriter.write(codedText, writePath);
	}
	
	private static void write()
	{
		System.out.println("Tekst: " + text);				
		tree.printElements();			
	}
}
