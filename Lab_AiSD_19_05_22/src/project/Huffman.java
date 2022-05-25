package project;

import java.util.PriorityQueue;

public class Huffman 
{
	private HuffmanNode root;
	
	public Huffman()
	{
		root = null;
	}
	
    private void printCode(HuffmanNode node, String s) 
    {    	
        if (node.left == null && node.right == null) 
        {
        	node.code = s;
            System.out.printf("%-5s|%-5s%n", node.c, s);
            return;
        }
                
        printCode(node.left, s + "0");
        printCode(node.right, s + "1");
    }
    
    public void createTree(char[] charArray, int charFreq[])
    {       	
        PriorityQueue <HuffmanNode> queue = new PriorityQueue <HuffmanNode> (charArray.length, new ImplementComparator());

        for (int i = 0; i < charArray.length; i++) queue.add(new HuffmanNode(charFreq[i], charArray[i], null, null)); 

        while (queue.size() > 1) 
        {
            HuffmanNode x = queue.poll();           
            HuffmanNode y = queue.poll();
           
            root = new HuffmanNode(x.item + y.item, '-', x, y);            
            queue.add(root);
        }        
    }
    
    private HuffmanNode findRecursive(HuffmanNode node, char key)
    {
    	if(node.left == null && node.right == null)
    	{
    		if(node.c == key) return node;
    		else return null;
    	}
    	else
    	{
    		if (findRecursive(node.left, key) != null) return findRecursive(node.left, key);
    		if (findRecursive(node.right, key) != null) return findRecursive(node.right, key);
    		
    		return null;
    	}
    }
    
    public HuffmanNode find(char key)
    {
    	return findRecursive(root, key);
    }
    
    public String codeText(String text)
    {
    	String res = "";
    	
    	for(int i = 0; i < text.length(); i++)
    	{
    		res += find(text.charAt(i)).code + " ";
    	}
    	
    	return res;
    }
    
    public void print()
    {
    	System.out.printf("%-5s|%-5s%n", "Znak", "Kod");
        System.out.println("--------------------");
    	printCode(root, "");
    }
}