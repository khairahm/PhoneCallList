/**
 * Represents one node in a Binary Tree
 * 
 * @author Khair Ahmed
 *
 */
public class BinaryTreeNode implements Comparable<BinaryTreeNode> {

	/**
	 * Stores the integer of this node
	 */
	private String name;

	private String phoneNumber;
	/**
	 * Reference to the left BinaryTree
	 */
	private BinaryTreeNode left;
	/**
	 * Reference to the right BinaryTree
	 */
	private BinaryTreeNode right;

	/**
	 * Default Constructor
	 */
	public BinaryTreeNode() {
		left = null;
		right = null;
		name = "";
		phoneNumber = "0";
	}

	/**
	 * Constructor which specifies the data to be stored
	 * 
	 * @param data - Data to use when creating this node.
	 */
	public BinaryTreeNode(String name, String phoneNumber) {
		left = null;
		right = null;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Returns the data stored in this node
	 * 
	 * @return Data member variable
	 */
	public String getData() {
		return this.name + ": " + this.phoneNumber + "\n";
	}
	/**
	 * returns the name of the node
	 * @return this.name
	 */

	public String getName() {
		return this.name;
	}
	/**
	 * returns the phonenumber of the account
	 * @return this.phonenumber
	 */

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * Returns the left Binary Tree
	 * 
	 * @return Left binary tree
	 */
	public BinaryTreeNode getLeft() {
		return left;
	}

	/**
	 * Returns the right Binary Tree
	 * 
	 * @return Right binary tree
	 */
	public BinaryTreeNode getRight() {
		return right;
	}
	/**
	 * search the tree for a node that exist
	 * @param tempNode	is the node that needs to be searched
	 * @return	true if found else return false
	 */
	public boolean searchTree(BinaryTreeNode tempNode) {
		if (compareTo(tempNode) == 0) {
			
			return true;
		}else {
		if (right != null) 
			return right.searchTree(tempNode);

		if (left != null) 
			return left.searchTree(tempNode);
		
		}
		return false;
		
		
	}

	/**
	 * Inserts a node into either the left or right tree where appropriate
	 * 
	 * @param newData Reference to the new data
	 */

	public void insert(BinaryTreeNode tempNode) {
		if (compareTo(tempNode) == 0) {
			System.out.println("Duplicate - not adding " + tempNode.getName() + ": " + tempNode.getPhoneNumber());
			return;
		}
		if (compareTo(tempNode) < 1) {
			if (right == null)
				right = tempNode;
			else
				right.insert(tempNode);
		}
		if (compareTo(tempNode) > 1) {
			if (left == null)
				left = tempNode;
			else
				left.insert(tempNode);
		}

	}
	/**
	 * compare the values in the node to see if it matched with another node
	 * @return a positive negative or 0 value 
	 */
	public int compareTo(BinaryTreeNode o) {

		if (this.getName().compareTo(o.getName()) == 0) {
			String phoneOne = this.getPhoneNumber();
			String phoneTwo = o.getPhoneNumber();
			String formattedPhoneOne = "";
			String formattedPhoneTwo = "";
			for (int i = 0; i < phoneOne.length(); i++) {
				if (Character.isDigit(phoneOne.charAt(i)))
					formattedPhoneOne += phoneOne.charAt(i);

			}

			for (int i = 0; i < phoneTwo.length(); i++) {
				if (Character.isDigit(phoneTwo.charAt(i)))
					formattedPhoneTwo += phoneTwo.charAt(i);

			}

			double PhoneNumberOne = Double.parseDouble(formattedPhoneOne);
			double PhoneNumberTwo = Double.parseDouble(formattedPhoneTwo);
			return ((int) PhoneNumberTwo) - ((int) PhoneNumberOne);

		}
		return this.getName().compareTo(o.getName());
	}

}
