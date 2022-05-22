package project;

public class HuffmannTree
{
	private Node root;
	private Node listRoot;
	private String coded;
	
	public HuffmannTree(Node _root)
	{
		root = _root;	
		listRoot = _root;			
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
			
			//Jezeli lista posortowana
			if(_root == null || (p.weight() <= _root.weight()))
			{
				p.setNext(_root);
				_root = p;
				continue;
			}
			
			r = _root;
			
			//Sortowanie listy z powrotem, jezeli nieposortowana
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
		Node p = listRoot;
		
		while(p != null)
		{
			System.out.println(p.toString());			
			p = p.next();
		}
	}
	
	public void printCodes()
	{
		System.out.println("Kody: ");		
		Node p = listRoot;
		
		while(p != null)
		{
			if(p.key() != '?')
			{
				System.out.println(p.key() + ": " + p.code());		
			}
				
			p = p.next();
		}
	}
	
	private void codeSign(char sign, Node p, String sequence)
	{		
		if(p.left() == null)
	  	{
			if(sign != p.key()) return;
			else
			{
				p.setCode(sequence);
				System.out.print(sequence);
				coded = sequence;
				return;
			}
	  	}
	  	else 
  		{
	  		codeSign(sign, p.left(), sequence + "0");
	  		codeSign (sign, p.right(), sequence + "1");
  		}		
	}

	public Node root()
	{
		return root;
	}
	
	public String codeText(Node p, String sequence)
	{	  
		System.out.println("Tekst zakodowany: ");
		String res = "";
		
		for(int i = 0; i < sequence.length( ); i++ )
		{
			codeSign(sequence.charAt(i), root, "");
			res += coded;
		}	 
		
		System.out.println();
		return res;
	}
}