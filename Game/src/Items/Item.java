package Items;

public class Item 
{
	private static String name;
	private static boolean stackable;
	private static int quantity;
	private static char body;
	
	public Item(String _name, boolean _stackable, int _quantity, char _body)
	{
		name = _name;
		stackable = _stackable;
		quantity = _quantity;
		body = _body;
	}
	
	public String ToString()
	{
		return String.format("Item %s, quantity: %d. Is stackable: %b. Body: %c", name, quantity, stackable, body);
	}
	
	public int GetQuantity()
	{
		return quantity;
	}
}
