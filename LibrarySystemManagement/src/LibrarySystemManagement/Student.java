/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySystemManagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author huyng
 */
class Student {
    private String studentName;
    private String studentID;
    private String contactNumber;
    public Book borrowedBook[] = new Book[3];
    private int booksCount;
    Scanner input = new Scanner(System.in);

    public Student() {
        System.out.println("Enter Student Name");
        this.studentName = capitalizeFirstLetter(input.nextLine());
        System.out.println("Enter StudentId");
        this.studentID = input.nextLine();
        System.out.println("Enter Contact Number");
        this.contactNumber = input.nextLine();
    }

    private String capitalizeFirstLetter(String name) {
        String[] nameList = name.split(" ");
        for(int i = 0;i<nameList.length;i++){
            nameList[i] = Character.toUpperCase(nameList[i].charAt(0)) + nameList[i].substring(1).toLowerCase();
        }
        
        return String.join(" ", nameList);
       
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getContactNumber() {
        return contactNumber;
    }

 
    public void setStudentName(String studentName) {
      try {
            if (!studentName.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Name should only contain letters and no numbers.");
            }
           this.studentName = capitalizeFirstLetter(studentName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    public void setContactNumber(String contactNumber) {
       try {
            if (!contactNumber.matches("\\d+")) {
                throw new IllegalArgumentException("Contact number should only contain digits.");
            }
            if (contactNumber.length() >= 11) {
                throw new IllegalArgumentException("Contact number should be less than 11 digits.");
            }
            this.contactNumber = contactNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    public int getBooksCount() {
        return booksCount;
    }

    public void setBooksCount(int booksCount) {
        this.booksCount = booksCount;
    }

    public Book[] getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(Book[] borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }
    
    

    @Override
    public String toString() {
        return "StudentName: " + studentName + ", StudentID: " + studentID + ", ContactNumber: " + contactNumber;
    }
    
    
    
}
