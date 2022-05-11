public class BinaryTree
{
	private Node<String> root;
	private int leafsCount;
	private int height;
	private int nodesCount;
	
	public BinaryTree()
	{
		root = null;
		leafsCount = 0;
		height = 0;
		nodesCount = 0;
	}
	
	public void create(String[] expression)
	{
		@SuppressWarnings("unchecked")
		Node<String>[] s = new Node[100];
		int pointer = 0;
		Node<String> v;
		int index;
		
		for(index = 0; index < expression.length; index++)
		{
			String put = expression[index];
			
			if(put.equals(" ")) continue;
			
			v = new Node<String>(put);
			nodesCount++;
			
			if(put.equals("+") || put.equals("-") || put.equals("*") || put.equals("/") || put.equals("^") || put.equals("%"))
			{
				Node<String> toSet;				
				
				pointer--;			
				if(pointer < 0) toSet = null;	
				else toSet = s[pointer];
				v.setLeft(toSet);
				toSet.setParent(v);
						
				pointer--;
				if(pointer < 0) toSet = null;	
				else toSet = s[pointer];
				v.setRight(toSet);	
				toSet.setParent(v);
				
				height++;
			}
			else
			{
				v.setLeft(null);
				v.setRight(null);
				
				leafsCount++;				
			}
			
			s[pointer] = v;
			pointer++;			
		}
		
		root = s[pointer - 1];
	}
	
	public int calculate()
	{
		int res = 0;
		
		Node<String> current = root;
		
		return res;
	}
	
	private int result(int a, int b, String operator)
	{
		if(operator.equals("+")) return a + b;
		if(operator.equals("-")) return a - b;
		if(operator.equals("*")) return a * b;
		if(operator.equals("%")) return a%b;
		if(operator.equals("^")) return (int) Math.pow(a, b);
		return a / b;
	}
	
	public String toString()
	{
		return String.format("wysokoœæ: %d, iloœæ liœci: %d, iloœæ wêz³ów: %d, wartosc wyrazenia: %d", height, leafsCount, nodesCount, calculate());
	}
}