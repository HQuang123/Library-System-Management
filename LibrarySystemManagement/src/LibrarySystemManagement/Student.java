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

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    
    public void setStudentName(String studentName) {
        if (studentName.matches("[a-zA-Z]+")) {
            this.studentName = capitalizeFirstLetter(studentName);
        } else {
            throw new IllegalArgumentException("Student name must contain only letters.");
        }
    }
   
    
    public void setContactNumber(String contactNumber) {
       if (contactNumber.matches("\\d{1,10}")) {
            this.contactNumber = contactNumber;
        } else {
            throw new IllegalArgumentException("Contact number must contain only digits and be less than 11 digits.");
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
