import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		BinaryTree t = new BinaryTree();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Wyrazenie: ");
		String next = scanner.next();
		String[] arr = ONP.convert(next);
		System.out.println("Wyrazenie ONP: " + ArrayManager.arrayToString(arr));
		
		t.create(arr);
		System.out.println(t.toString());
		
		scanner.close();
	}
}