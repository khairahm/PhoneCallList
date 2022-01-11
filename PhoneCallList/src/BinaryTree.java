import java.util.Formatter;

/**
 * Represents the Binary Tree data structure
 * 
 ]
 * @author Khair Ahmed
 */
public class BinaryTree {

	/**
	 * Reference to the root Node of the tree
	 */
	BinaryTreeNode root = null;

	/**
	 * Insert the data into the tree
	 * 
	 * @param newData New int to store in the tree
	 */
	public void insertInTree(BinaryTreeNode tempNode) {
		if (root == null)
			root = tempNode;
		else
			root.insert(tempNode);
	}
	/**
	 * Searches the tree if the boolean exist
	 * @param tempNode the information of the user that needs to be searched
	 * @return	true if found false otherwise
	 */
	
	public boolean searchTree(BinaryTreeNode tempNode) {
		if (root == null){
			return false;
		}
		else {
			return root.searchTree(tempNode);
			
		}
	}

	/**
	 * Method to display the contents of the tree
	 */
	public void displayInOrder() {
		displayInOrder(root);
	}
	/**
	 * checks if the first node is null
	 * @return true if is null else return false
	 */
	public boolean isNull() {
		if(root==null)
			return true;
		return false;
	}
	/**
	 * Traverse the tree using InOrder traversal and display the content to the
	 * console
	 * 
	 * @param subRoot The node to start with
	 */
	private void displayInOrder(BinaryTreeNode subRoot) {
		if (subRoot == null) {
			
			return;
		}
		displayInOrder(subRoot.getLeft());
		System.out.print(subRoot.getData());
		displayInOrder(subRoot.getRight());
	
	}
	/**
	 * method to display who calls who
	 */
	
	public void callWhom() {
		callWhom(root);
	}
	/**
	 * displays who calls who
	 * @param subRoot is the binary tree
	 */
	private void callWhom(BinaryTreeNode subRoot) {
		if (subRoot == null) {
			
			return;
		}
		if(subRoot.getRight()==null && subRoot.getLeft() ==null)
			System.out.println(subRoot.getName() + " calls No Contact");
		if(subRoot.getRight()!=null && subRoot.getLeft() !=null)
			System.out.println(subRoot.getName() + " calls " + subRoot.getLeft().getName() + " and "+ subRoot.getRight().getName());
		if(subRoot.getRight()!=null && subRoot.getLeft() ==null)
			System.out.println(subRoot.getName() +  " calls " + subRoot.getRight().getName());
		if(subRoot.getRight()==null && subRoot.getLeft() !=null)
			System.out.println(subRoot.getName() +  " calls " + subRoot.getLeft().getName());
		
		callWhom(subRoot.getLeft());
		callWhom(subRoot.getRight());

		

	}
	/**
	 * save the file 
	 * @param saveFile takes a file and saves it
	 */
	
	public void saveFile(Formatter saveFile) {
		saveFile( saveFile,  root);
	}
	
	/**
	 * saves user information to a file
	 * @param saveFile the file where the information is being saved
	 * @param subRoot the next root that needs to be saved
	 */
	private void saveFile(Formatter saveFile, BinaryTreeNode subRoot) {
		if (subRoot == null) {
			
			return;
		}		
		saveFile.format("%s\n%s\n", subRoot.getName(),subRoot.getPhoneNumber());
		saveFile(saveFile,subRoot.getLeft());
		saveFile(saveFile, subRoot.getRight());

	}
//
//	public int getHeight() {
//		return getHeight(root);
//
//	}
//	private int getHeight(BinaryTreeNode subRoot) {
//		if(subRoot == null) {
//			return 0;
//		}
//		
//		int leftHeight = getHeight(subRoot.getLeft());
//		int rightHeight = getHeight(subRoot.getRight());
//		
//		if (leftHeight > rightHeight) {
//			return (leftHeight +1);
//			
//		}else {
//			return (rightHeight +1 );
//		}
//	}
}
