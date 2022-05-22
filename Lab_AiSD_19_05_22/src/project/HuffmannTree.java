package project;

public class HuffmannTree
{
	private Node root;
	
	public HuffmannTree(Node _root)
	{
		root = _root;			
	}
	
	public void makeTree(Node _r)
	{			
		Node r = null, p = null, v1 = null, v2 = null;		
		Node _root = _r;
		
		while(true)
		{
			v1 = _root;
			v2 = v1.next();
			
			if(v2 == null) break; //Dla 0 lub 1 elementu przerywamy
			
			_root = v2.next();
			
			p = new Node(v1, v2, '?', v1.weight() + v2.weight());
			
			if(_root == null || (p.weight() <= _root.weight()))
			{
				p.setNext(_root);
				_root = p;
				continue;
			}
			
			r = _root;
			
			while( r.next() != null && (p.weight() > r.next().weight())) 
			{
				r = r.next();
			}

		    p.setNext(r.next());
		    r.setNext(p);
		}
		
		root = p;
	}
	
	public void printElements()
	{
		System.out.println("Elementy: ");
		
		Node p = root;
		
		while(p != null)
		{
			System.out.println(p.toString());
			p = p.next();
		}
	}

	public void createCodes()
	{
		String code = "0";
		int length = 0;
		int index = 0;
		Node p = root;
		
		while(p != null)
		{
			length++;
			p = p.next();
		}
		
		p = root;
		
		while(length > 0)
		{			
			index = length - 1;
			
			while(index > 0)
			{
				p = p.next();
				index--;
			}
			
			p.setCode(code);
			
			if(code.charAt(code.length() - 1) == '0')
			{
				String help = "";
				
				for(int i = 0; i < code.length() - 1; i++) help += code.charAt(i);
				help += '1';
				code = help;
			}
			else
			{
				code += '0';
			}			
			
			p = root;
			length--;
		}
	}
	
	public void printCodes()
	{
		System.out.println();
		System.out.println("Kody:");
		
		Node p = root;
		
		while(p != null)
		{
			System.out.println(p.key() + ": " + p.code());
			p = p.next();
		}
	}
	
	public Node root()
	{
		return root;
	}
	
	public String codeText()
	{
		String res = "";		
		Node p = root;
		
		while(p != null)
		{
			res += p.code();
			p = p.next();
		}
		
		return res;
	}
}