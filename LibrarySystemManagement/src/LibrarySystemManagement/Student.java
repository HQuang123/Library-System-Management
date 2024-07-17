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
        while(true){
            try{
            System.out.println("Enter Student Name");
            this.studentName = capitalizeFirstLetter(input.nextLine());
            if (!this.studentName.matches("[A-Za-z.\\s_-]+$")) {
                    throw new IllegalArgumentException("Name should only contain letters and no numbers.");
            }
            break;
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }        
        System.out.println("Enter StudentId");
        this.studentID = input.nextLine();
        while(true){
            try{
            System.out.println("Enter Contact Number");
            this.contactNumber = input.nextLine();
            if (!this.contactNumber.matches("\\d{0,15}")) {
                    throw new IllegalArgumentException("Number should only contain numbers.");
            }
            break;
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }        
    }

    private String capitalizeFirstLetter(String name) {
        String[] nameList = name.split("\\s+");
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

    public void setStudentName() {
        while(true){
            try{
            System.out.println("Enter Student Name");
            this.studentName = capitalizeFirstLetter(input.nextLine());
            if (!this.studentName.matches("[A-Za-z.\\s_-]+$")) {
                    throw new IllegalArgumentException("Name should only contain letters and no numbers.");
            }
            break;
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void setContactNumber() {
       while(true){
            try{
            System.out.println("Enter Contact Number");
            this.contactNumber = input.nextLine();
            if (!this.contactNumber.matches("\\d{0,15}")) {
                    throw new IllegalArgumentException("Number should only contain numbers and do not have leading 0.");
            }
            break;
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
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
