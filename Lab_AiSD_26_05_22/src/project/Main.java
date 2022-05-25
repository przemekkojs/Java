package project;

import java.util.Vector;

public class Main 
{
	private static TextReader reader;
	private static RBTree tree;
	private static Vector<Word> words;
	
	public static void main(String[] args) 
	{
		init();
		write();
		
		delete("parasol");
		delete("i");
		delete("w");
		
		write();
	}
	
	private static void init()
	{
		reader = new TextReader("input.txt");		
		System.out.println("Czytanie pliku...");
		words = reader.readText();
		System.out.println("Czytanie pliku zakoñczone");
	
		System.out.println("Tworzenie drzewa...");
		tree = new RBTree();		
		tree.createTree(words);
		System.out.println("Tworzenie drzewa zakoñczone");
	}
	
	private static void write()
	{
		tree.printTree();
	}
	
	private static void delete(String _word)
	{
		Word search = null;
		int size = words.size();
		
		for(int i = 0; i < size; i++)
		{
			if(words.elementAt(i).word().equals(_word))
			{
				search = words.elementAt(i);
				break;
			}
		}
		
		if(search == null) 
		{
			System.err.println("Nie znaleziono s³owa");
			return;
		}
		
		Node toDelete = tree.searchTree(search);
		tree.deleteNode(toDelete);
		System.out.println(" ==> Usuniêto " + _word + " <==");		
	}
}