
public class Tree {
	
	// this class represent single Node
	static class Node
	{
		// data members
		char value;
		Node left;
		Node right;
		
		// Constructor 
		public Node(char value) 
		{
			this.value = value;
			left = null;
			right = null;
		}
	}
	
	

	 
	
	
	// to insert value in the tree
	public void insert(Node node, char value)
	{
		if(value < node.value) 
		{
			if(node.left != null) 
			{
				insert(node.left, value);
			}
			else 
			{
				Node newNode = new Node(value);
				node.left = newNode;
				System.out.println("Inserted "+value+" to the left of "+node.value);
			}
		}
		else 
		{
			if(node.right != null) 
			{
				insert(node.right, value);
			}
			else 
			{
				
				Node newNode = new Node(value);
				node.right = newNode;
				System.out.println("Inserted "+value+" to the right of "+node.value);
			}
		}
	}
	
	// pre order traversal of tree
	public void preorderTraversal(Node node)
	{
		if(node != null)  
		{
			System.out.print(node.value+" ");
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		}
	}
	
	// Getting height of the tree
	private int getHeight(Node root) 
	{
		if (root == null) 
		{
			return 0;
		}
        else
        {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
 
           
            if (leftHeight> rightHeight)
            {
            	 return leftHeight + 1;
            }
            else 
            {
            	return rightHeight + 1;
            }
                
        }
	}
	
	// level order traversal of tree
	public void levelOrderTraversal(Node root) 
	{
		int h = getHeight(root);
        System.out.println("\nTraversing tree level order height "+h);
		for (int i = 1; i <= h; i++) 
        {
        	currentLevel(root, i);
        }
            
	}
	
	
	private void currentLevel(Node root, int level)
    {
        if (root == null) 
        {
        	return;
        }
            
        if (level == 1) 
        {
        	System.out.print(root.value + " ");
        }
        else if (level > 1)
        {
            currentLevel(root.left, level - 1);
            currentLevel(root.right, level - 1);
        }
    }
	
	
	public static void main(String agrs[]) 
	{
		Tree tree = new Tree();
		System.out.println("Building tree with root value a");
		Node root = new Node('a');
		tree.insert(root, 'D');
		tree.insert(root, 'h');
		tree.insert(root, 'e');
		tree.insert(root, 'i');
		tree.insert(root, 'k');
		tree.insert(root, 'F');
		tree.insert(root, 'B');
		tree.insert(root, 'A');
		tree.insert(root, 'C');
		tree.insert(root, 'c');
		tree.insert(root, 'G');
		System.out.println("Traversing tree in preorder");
		tree.preorderTraversal(root);
		tree.levelOrderTraversal(root);
	}
	
}
