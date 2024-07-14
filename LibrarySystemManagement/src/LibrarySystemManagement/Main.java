package LibrarySystemManagement;

// Java Program to Illustrate Application CLass
// To Create The Menu For the Program

// Importing required classes
import java.util.Scanner;

// Class
public class Main {

	// Main driver method
	public static void main(String[] args)
	{
		// Creating object of Scanner class
		// to take input from user
		Scanner input = new Scanner(System.in);

		// Displaying menu
		System.out.println(
			"********************Welcome to the GFG Library!********************");
		System.out.println(
			"				 Select From The Following Options:			 ");
		System.out.println(
			"**********************************************************************");

		// Creating object of Book class
		BookManagement ob = new BookManagement();
		// Creating object of MemberManagement class
		MemberManagement obStudent = new MemberManagement();

		int choice;
		int searchChoice;

		// Creating menu
		// using do-while loop
		do {

			ob.dispMenu();
			choice = input.nextInt();

			// Switch case
			switch (choice) {

				// Case
                        case 0:
                                System.out.println("See You Later1");
                                choice = 0 ;
                                break;
                                
			case 1:
				Book b = new Book();
				ob.addBook(b);
				break;

				// Case
			case 2:
				ob.searchBookbySNo();
				break;
                                
				// Case
			case 3:
				ob.printBooks();
				break;

				// Case
			case 4:
				Student s = new Student();
				obStudent.registerStudent(s);
				break;

				// Case
			case 5:
				obStudent.printAllStudents();
				break;

				// Case
			case 6:
				obStudent.checkOutBook(ob);
				break;

				// Case
			case 7:
				obStudent.checkInBook(ob);
				break;

				
                        case 8: 
                                obStudent.deleteStudent();
                                break;
                        case 9:
                                obStudent.updateStudent();
                                break;
                        case 10:
                                ob.deleteBook();
                                break;
                                
                        case 11:
                                ob.updateBook();
                                break;
                        //
                        case 12:
                                ob.extendDuedate();
                                break;

			default:
				// Print statement
				System.out.println("ENTER BETWEEN 1 TO 12.");
			}

		}

		// Checking condition at last where we are
		// checking case entered value is not zero
		while (choice != 0);
	}
}
