import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Tests the BinaryTree and Node class.
 * 
 * @author Khair Ahmed
 *
 */
public class Assign4 {

	/**
	 * Main method
	 * 
	 * @param args - Passed in parameters from the command line.
	 */

	

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		keyboard.useDelimiter(Pattern.compile("[\\n\\r]+"));
		BinaryTree tree = new BinaryTree();

		int choice = 0;
		while (choice != 7) {
			displayMenu();
			if (keyboard.hasNext(Pattern.compile("[1-7]"))) {
				choice = keyboard.nextInt();
				switch (choice) {
				case 1: // Add Value to Tree
					System.out.println("Phone List:");
					if (tree.isNull() )
						System.out.println("List is empty");
					else
						tree.displayInOrder();
					

					break;
				case 2: // Add to list
					String tempName="";
					String tempPhone="";
					String formattedPhone = "";
					String nodeNumber="";
					keyboard.nextLine();
					System.out.print("Enter Name of Contact: ");
					tempName = keyboard.nextLine();
					System.out.print("Enter Phone Number for Contact: ");
					tempPhone = keyboard.next();
					while(!tempPhone.matches("^\\s*(?:\\+?(\\d{1,3}))?[- (]*(\\d{3})[- )]*(\\d{3})[- ]*(\\d{4})(?: *x(\\d+))?\\s*$")) {
						System.out.print("Please enter a valid US Phone number (10 or 11 digit)");
						tempPhone = keyboard.next();
				
					}
					
					for(int i = 0 ; i<tempPhone.length(); i++) {
						if(Character.isDigit(tempPhone.charAt(i)))
							formattedPhone+=tempPhone.charAt(i);
							
					}
					if (formattedPhone.length() == 10)
						formattedPhone = "1"+formattedPhone;
					
					nodeNumber = formattedPhone.charAt(0) +"-" + formattedPhone.substring(1,4) +"-" + formattedPhone.substring(4,7) +"-"+formattedPhone.substring(7,11) ;
					BinaryTreeNode tempNode=  new BinaryTreeNode(tempName,nodeNumber);
					tree.insertInTree(tempNode);
					break;
				case 3:
					String readFileName;
					System.out.print("Enter Name of File to Write To: ");
					readFileName = keyboard.next();
					Scanner readFile = null;
					
					try {
						readFile = new Scanner(new File(readFileName));
					}catch(FileNotFoundException e) {
						System.out.println("File Not Found");
						break;
					}
					
					while(readFile.hasNext()) {
						tempName  = readFile.nextLine();
						tempPhone = readFile.next();
						readFile.nextLine();
						tempNode=  new BinaryTreeNode(tempName,tempPhone);
						tree.insertInTree(tempNode);

						
					}
					readFile.close();
					break;
				case 4: 
					
					if(tree.isNull()) {
						System.out.println("List is empty");
						break;
					}
					String saveFileName;
					System.out.print("Specify a FileName to Save: ");
					saveFileName = keyboard.next();
					Formatter saveFile = null;
					try {
						saveFile = new Formatter(saveFileName);
					}catch(FileNotFoundException e) {
						System.out.println("File Not Created");
						break;
					}
					tree.saveFile(saveFile);
					saveFile.close();
					break;
				case 5:
					if(tree.isNull()) {
						System.out.println("List is empty");
						break;
					}
					String searchNumber ="";
					keyboard.nextLine();
				System.out.print("Enter Name of Contact: ");
				tempName = keyboard.nextLine();
				System.out.print("Enter Phone Number for Contact: ");
				tempPhone = keyboard.next();
				while(!tempPhone.matches("^\\s*(?:\\+?(\\d{1,3}))?[- (]*(\\d{3})[- )]*(\\d{3})[- ]*(\\d{4})(?: *x(\\d+))?\\s*$")) {
					System.out.print("Please enter a valid US Phone number (10 or 11 digit)");
					tempPhone = keyboard.next();
			
				}
				
				for(int i = 0 ; i<tempPhone.length(); i++) {
					if(Character.isDigit(tempPhone.charAt(i)))
						searchNumber+=tempPhone.charAt(i);
						
				}
				if (searchNumber.length() == 10)
					searchNumber = "1"+searchNumber;
				
				nodeNumber = searchNumber.charAt(0) +"-" + searchNumber.substring(1,4) +"-" + searchNumber.substring(4,7) +"-"+searchNumber.substring(7,11) ;
				BinaryTreeNode searchNode=  new BinaryTreeNode(tempName,nodeNumber);
				
				if(tree.searchTree(searchNode)) {
					System.out.println("Contact Found in Tree");
				}else {
					System.out.println("Contact Not Found in Tree");

				}
				break;
					
					
				case 6:
					if(tree.isNull()) {
						System.out.println("List is empty");
						break;
					}
					System.out.println("Here are Everyone's Responsibilities: ");
					tree.callWhom();
					break;
				case 7:
					System.out.println("Exiting...");
					break;
				default:
					break;
				}
			} else {
				System.out.println("Invalid choice");
				choice = 0;
				keyboard.next();
			}
		}
		keyboard.close();
	}

	/**
	 * Displays menu to screen
	 */
	public static void displayMenu() {
		System.out.println("1: Display The Phone Tree");
		System.out.println("2: Add One Contact To The List");
		System.out.println("3: Add Contacts To A File");
		System.out.println("4: Save Contacts To A File");
		System.out.println("5: Determine If A Contact Is In The List");
		System.out.println("6: List Out Who Calls Whom");
		System.out.println("7: To Exit");
		System.out.print("> ");
	}
	


}
