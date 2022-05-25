package morse;

public class Main 
{
	private static MTree tree;
	
	public static void main(String[] args) 
	{
		init();
	}
	
	private static void init()
	{
		tree = new MTree();
		tree.createTree();
		tree.print();
		
		String coded = tree.code("przemyslawkojs");
		System.out.println(coded);
		String decoded = tree.decode(coded);
		System.out.println(decoded);
	}
}