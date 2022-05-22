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
		tree.createCodes();
		tree.printCodes();
		tree.makeTree(tree.root());		
		
		System.out.print("Tekst zakodowany: ");		
		System.out.println(codedText);
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
