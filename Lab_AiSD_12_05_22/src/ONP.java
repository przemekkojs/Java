import java.util.Stack;
import java.util.Vector;

public class ONP 
{
	public static String[] convert(String expression)
	{
		Vector<String> res = new Vector<String>();
		Stack<String> operators = new Stack<String>();
		
		for(int i = 0; i < expression.length(); i++)
		{			
			boolean check = false;
			String token = (expression.charAt(i) + "");			
			String a = "";
			
			while(i < expression.length() && (expression.charAt(i) >= '0' && expression.charAt(i) <= '9'))
			{
				a += expression.charAt(i);
				i++;	
				check = true;
			}			
			
			if(check) 
			{
				res.add(a);
				i--;
				continue;				
			}
			
			if(token.equals("("))
			{
				operators.push(token);				
			}
			else if(token.equals(")"))
			{				
				while(!operators.peek().equals("("))
				{
					res.add(operators.pop());
				}				
				
				operators.pop();
			}
			else
			{					
				while(!operators.isEmpty() && priority(operators.peek()) >= priority(token))
				{
					res.add(operators.pop());
				}				
				
				operators.push(token);
			}			
		}
		
		while(!operators.isEmpty())
		{
			res.add(operators.pop());
		}	
		
		return res.toArray(new String[res.size()]);
	}
	
	private static int priority(String op)
	{
		if(op.equals("*")) return indexes.MULTIPLY;
		else if(op.equals("/")) return indexes.MULTIPLY;
		else if(op.equals("%")) return indexes.MULTIPLY;
		else if(op.equals("+")) return indexes.PLUS;
		else if(op.equals("-")) return indexes.PLUS;		
		else if(op.equals("^")) return indexes.POWER;
		else return indexes.ZERO;		
	}
	
	class indexes
	{
		public static final int POWER = 2;
		public static final int MULTIPLY = 2;
		public static final int PLUS = 1;
		public static final int ZERO = 0;
	}	
}
