package project;

public class Main 
{
	private static Huffman tree;
	private static TextReader textReader;
	@SuppressWarnings("unused")
	private static TextWriter textWriter;
	
    public static void main(String[] args) 
    {
    	tree = new Huffman();
    	textReader = new TextReader("input.txt");
    	
    	tree.createTree(textReader.characters(), textReader.quantities());
    	tree.print();
    	
    	String coded = tree.codeText(textReader.text());
    	
    	System.out.println(coded);
    	
    	textWriter = new TextWriter("output.txt", coded);
    }  
}