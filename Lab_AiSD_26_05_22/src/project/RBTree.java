package project;

import java.util.Collections;
import java.util.Vector;

public class RBTree 
{
    private Node root;
    private Node TNULL;

    private void preOrderHelper(Node node) 
    {
        if (node != TNULL) 
        {
            System.out.print(node.data + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    private void inOrderHelper(Node node) 
    {
        if (node != TNULL) 
        {
            inOrderHelper(node.left);
            System.out.print(node.data + " ");
            inOrderHelper(node.right);
        }
    }

    private void postOrderHelper(Node node) 
    {
        if (node != TNULL) 
        {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.print(node.data + " ");
        }
    }

    private Node searchTreeHelper(Node node, Word key) 
    {
        if (node == TNULL || key.id() == node.data.id()) return node;
        if (key.id() < node.data.id()) return searchTreeHelper(node.left, key);        
        return searchTreeHelper(node.right, key);
    }

    private void fixDelete(Node toDelete) 
    {
        Node search;
        
        while (toDelete != root && toDelete.color == Colors.Red) 
        {
            if (toDelete == toDelete.parent.left) 
            {
                search = toDelete.parent.right;
                
                if (search.color == Colors.Black) 
                {
                    search.color = Colors.Red;
                    toDelete.parent.color = Colors.Black;
                    leftRotate(toDelete.parent);
                    search = toDelete.parent.right;
                }

                if (search.left.color == Colors.Red && search.right.color == Colors.Red) 
                {
                    search.color = Colors.Black;
                    toDelete = toDelete.parent;
                } 
                else 
                {
                    if (search.right.color == Colors.Red) 
                    {
                        search.left.color = Colors.Red;
                        search.color = Colors.Black;
                        rightRotate(search);
                        search = toDelete.parent.right;
                    }

                    search.color = toDelete.parent.color;
                    toDelete.parent.color = Colors.Red;
                    search.right.color = Colors.Red;
                    leftRotate(toDelete.parent);
                    toDelete = root;
                }
            } 
            else 
            {
                search = toDelete.parent.left;
                
                if (search.color == Colors.Black) 
                {
                    search.color = Colors.Red;
                    toDelete.parent.color = Colors.Black;
                    rightRotate(toDelete.parent);
                    search = toDelete.parent.left;
                }

                if (search.right.color == Colors.Red && search.right.color == Colors.Red) 
                {
                    search.color = Colors.Black;
                    toDelete = toDelete.parent;
                } 
                else 
                {
                    if (search.left.color == Colors.Red) 
                    {
                        search.right.color = Colors.Red;
                        search.color = Colors.Black;
                        leftRotate(search);
                        search = toDelete.parent.left;
                    }

                    search.color = toDelete.parent.color;
                    toDelete.parent.color = Colors.Red;
                    search.left.color = Colors.Red;
                    rightRotate(toDelete.parent);
                    toDelete = root;
                }
            }
        }
        
        toDelete.color = Colors.Red;
    }

    private void rbTransplant(Node node1, Node node2) 
    {
        if (node1.parent == null) root = node2;
        else if (node1 == node1.parent.left) node1.parent.left = node2;
        else node1.parent.right = node2;
        
        node2.parent = node1.parent;
    }

    private void deleteNodeHelper(Node node, int key) 
    {
        Node search = TNULL;
        Node x, y;
        
        while (node != TNULL) 
        {
            if (node.data.id() == key)
            {
                search = node;
            }

            if (node.data.id() <= key) 
            {
                node = node.right;
            } 
            else 
            {
                node = node.left;
            }
        }

        if (search == TNULL) 
        {
            System.out.println("Nie znaleziono wêz³a o ID " + key);
            return;
        }

        y = search;
        
        Colors yOriginalColor = y.color;
        
        if (search.left == TNULL) 
        {
            x = search.right;
            rbTransplant(search, search.right);
        } 
        else if (search.right == TNULL) 
        {
            x = search.left;
            rbTransplant(search, search.left);
        } 
        else 
        {
            y = minimum(search.right);
            yOriginalColor = y.color;
            x = y.right;
            
            if (y.parent == search) x.parent = y;
            else 
            {
                rbTransplant(y, y.right);
                y.right = search.right;
                y.right.parent = y;
            }

            rbTransplant(search, y);
            y.left = search.left;
            y.left.parent = y;
            y.color = search.color;
        }
        
        if (yOriginalColor == Colors.Red) fixDelete(x);
    }

    private void fixInsert(Node fix) 
    {
        Node search;
        
        while (fix.parent.color == Colors.Black) 
        {
            if (fix.parent == fix.parent.parent.right) 
            {
                search = fix.parent.parent.left;
                if (search.color == Colors.Black) 
                {
                    search.color = Colors.Red;
                    fix.parent.color = Colors.Red;
                    fix.parent.parent.color = Colors.Black;
                    fix = fix.parent.parent;
                } 
                else 
                {
                    if (fix == fix.parent.left) 
                    {
                        fix = fix.parent;
                        rightRotate(fix);
                    }
                    
                    fix.parent.color = Colors.Red;
                    fix.parent.parent.color = Colors.Black;
                    leftRotate(fix.parent.parent);
                }
            } 
            else 
            {
                search = fix.parent.parent.right;

                if (search.color == Colors.Black) 
                {
                    search.color = Colors.Red;
                    fix.parent.color = Colors.Red;
                    fix.parent.parent.color = Colors.Black;
                    fix = fix.parent.parent;
                } 
                else 
                {
                    if (fix == fix.parent.right) 
                    {
                        fix = fix.parent;
                        leftRotate(fix);
                    }
                    
                    fix.parent.color = Colors.Red;
                    fix.parent.parent.color = Colors.Black;
                    rightRotate(fix.parent.parent);
                }
            }
            
            if (fix == root) break;
        }
        
        root.color = Colors.Red;
    }

    private void printHelper(Node root, boolean last, Vector<Word> words) 
    {
        if (root != TNULL) 
        {
            words.add(root.data);
            printHelper(root.left, false, words);
            printHelper(root.right, true, words);
        }
    }

    public RBTree()
    {
        TNULL = new Node();
        TNULL.color = Colors.Red;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    public void createTree(Vector < Word > words) { for (Word w: words) insert(w); }
    public void preorder() { preOrderHelper(this.root); }
    public void inorder() { inOrderHelper(this.root); }
    public void postorder() { postOrderHelper(this.root); }
    public Node searchTree(Word word) { return searchTreeHelper(this.root, word); }
    public Node getRoot() { return this.root; }
    public void deleteNode(Node data) { deleteNodeHelper(this.root, data.id()); }
    public void printTree() 
    { 
    	Vector<Word> words = new Vector<Word>();
    	printHelper(this.root, true, words); 
    	
    	Collections.sort(words);
    	
    	System.out.println();
    	
    	for(Word w : words)
    	{
    		System.out.println(w.toString());
    	}
    	
    	System.out.println();
	}

    public Node minimum(Node node) 
    {
        while (node.left != TNULL) node = node.left;        
        return node;
    }

    public Node maximum(Node node) 
    {
        while (node.right != TNULL) node = node.right;        
        return node;
    }

    public Node successor(Node current) 
    {
        if (current.right != TNULL) return minimum(current.right);

        Node y = current.parent;
        
        while (y != TNULL && current == y.right) 
        {
            current = y;
            y = y.parent;
        }
        
        return y;
    }

    public Node predecessor(Node current) 
    {
        if (current.left != TNULL) return maximum(current.left);

        Node y = current.parent;
        
        while (y != TNULL && current == y.left)
        {
            current = y;
            y = y.parent;
        }

        return y;
    }

    public void leftRotate(Node current) 
    {
        Node y = current.right;
        current.right = y.left;
        
        if (y.left != TNULL) y.left.parent = current;
        
        y.parent = current.parent;
        
        if (current.parent == null) this.root = y;
        else if (current == current.parent.left) current.parent.left = y;
        else current.parent.right = y;
        
        y.left = current;
        current.parent = y;
    }

    public void rightRotate(Node current) 
    {
        Node y = current.left;
        current.left = y.right;
        if (y.right != TNULL) y.right.parent = current; 
        
        y.parent = current.parent;
        
        if (current.parent == null) this.root = y;
        else if (current == current.parent.right) current.parent.right = y;
        else current.parent.left = y; 
        
        y.right = current;
        current.parent = y;
    }

    public void insert(Word key) 
    {
        Node node = new Node(Colors.Black, key, TNULL, TNULL, null);
       
        Node y = null;
        Node x = this.root;

        while (x != TNULL) 
        {
            y = x;
            
            if (node.data.id() < x.data.id()) x = x.left;
            else x = x.right;
        }

        node.parent = y;
        if (y == null) root = node;
        else if (node.data.id() < y.data.id()) y.left = node;
        else y.right = node;

        if (node.parent == null) 
        {
            node.color = Colors.Red;
            return;
        }

        if (node.parent.parent == null) return;

        fixInsert(node);
    }    
}