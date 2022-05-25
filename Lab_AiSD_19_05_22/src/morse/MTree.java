package morse;

public class MTree 
{
	private Node root;	
	private Node found;
	private boolean flag = false;
	
	public MTree()
	{
		root = new Node("", null, null, ' ');
	}
	
	public void createTree()
	{
		add(root, 0);
	}
	
	private void add(Node _root, int level)
	{
		if(level >= 4) return;
		
		Node parent = _root;
		Node left = new Node(parent.code + ".", null, null, MorseDecoder.MorseToLetter(parent.code + "."));
		Node right = new Node(parent.code + "_", null, null, MorseDecoder.MorseToLetter(parent.code + "_"));
		
		parent.left = left;
		parent.right = right;
		
		add(left, level + 1);
		add(right, level + 1);
	}
	
	private void printHelp(Node p)
	{
		if(p.letter != ' ') System.out.println(p.toString());			
		if(p.left == null && p.right == null) return;	
			
		printHelp(p.left);
		printHelp(p.right);
	}
	
	public void print()
	{
		printHelp(root);
	}

	public void find(Node temp, char key) 
	{
		if (temp == null) return;

		if (temp.letter == key) 
		{
			flag = true;
			found = temp;
			return;
		}

		if (flag == false) 
		{
			find(temp.left, key);
		}

		if (flag == false) 
		{
			find(temp.right, key);
		}
 }
	
	public String code(String text)
	{
		String res = "";
		
		for(int i = 0; i < text.length(); i++)
		{		
			char key = text.charAt(i);
			find(root, key);
			flag = false;
			res += found.code + "/";
		}
		
		return res;
	}
	
	public String decode(String text)
	{
		String res = "";
		String characters = "";
		
		for(int i = 0; i < text.length(); i++)
		{			
			if(text.charAt(i) == '/')
			{
				res += MorseDecoder.MorseToLetter(characters);
				characters = "";
			}
			else
			{
				characters += text.charAt(i);
			}			
		}
		
		return res;
	}
}
