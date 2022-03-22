package Zadanie1;

public class Main 
{
	private static VTS<Integer> vts = new VTS<Integer>(10);
	private static ReverseStack<Integer> reverse = new ReverseStack<Integer>(5);
	
	public static void main(String[] args) 
	{
		VTSStack();
		//RStack();
	}
	
	private static void RStack()
	{
		try 
		{
			reverse.push(0);
			reverse.push(1);
			reverse.push(2);
			reverse.push(3);
			reverse.push(4);
			
			reverse.Reverse();
			
			while(!reverse.IsEmpty())
			{
				System.out.print(reverse.top());
				reverse.pop();
			}
		} 
		catch (FullStackException | EmptyStackException e) 
		{			
			e.printStackTrace();
		}		
	}
	
	private static void VTSStack()
	{
		try
		{
			vts.push(1);
			vts.push(2);
			vts.push(3);
			vts.push(4);
			vts.push(5);
			vts.push(6);
			
			System.out.print(vts.peek());
			vts.down();
			System.out.print(vts.peek());
			vts.down();
			System.out.print(vts.peek());
			vts.down();			
			System.out.println(vts.peek());			
			System.out.println(vts.size());
			System.out.println(vts.top());
			System.out.print(vts.peek());
			
		} catch (FullStackException | OutOfRangeException | EmptyStackException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
