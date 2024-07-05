/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySystemManagement;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class MemberManagement {
    private ArrayList<Student> member = new ArrayList<Student>();
    Scanner input = new Scanner(System.in);
    public static int count = 0;

    public void registerStudent(Student student){
        boolean status = true;
        for (Student student1 : member) {
            if(student1.getStudentID().equals(student.getStudentID())){
                System.out.println("The student is already a member !");
                status = false;
                break;
            }
        }
        
        if(status){
            member.add(student);
        }
    }
    
    public void printAllStudents() {
        
        if (member.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            System.out.println("Student Name\t\tStudentId\t\tContact Number");
            for (Student student : member) {
                System.out.println(student.getStudentName() + "\t\t" + student.getStudentID() + "\t\t" + student.getContactNumber());
            }
        }
    }   
    
    public int isStudent(){
        System.out.println("Enter the StudentId");
        String studentId = input.nextLine();
        for (Student student : member) {
            if(student.getStudentID().equals(studentId)){
                return member.indexOf(student);
            }
        }
        System.out.println("Student is not Registered");
        System.out.println("Get Registered First");
        return -1;
    }
    
    public void checkOutBook(BookManagement book){
        int studentIndex = this.isStudent();
        
        if(studentIndex != -1){
            System.out.println("Checking out");
            book.printBooks();
            Book b = book.checkOutBook();
            System.out.println("Checking out");
            if(b!=null){
                if(member.get(studentIndex).getBooksCount()<=3){
                    System.out.println("Adding book");
                    member.get(studentIndex).borrowedBook[member.get(studentIndex).getBooksCount()] = b;
                    member.get(studentIndex).setBooksCount(member.get(studentIndex).getBooksCount()+1);      
                    return;
                }
                else{
                    System.out.println("Student can not borrow more than 3 books");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }
    
    public void checkInBook(BookManagement book){
        
        int studentIndex = this.isStudent();
        if(member.get(studentIndex).getBooksCount() == 0){
            System.out.println("This Student Has Not Borrowed Any Book");
            return;
        }
        if(studentIndex != -1){
            System.out.println("S.No\t\tBook Name\t\tAuthor Name\t\tRentDate\t\tDueDate\t\tReturnDate\t\tFine");
            Student student = member.get(studentIndex);
            for(int i =0; i< student.getBooksCount();i++){
                System.out.println(
                student.borrowedBook[i].getISBN()+"\t\t"+
                student.borrowedBook[i].getTitle() + "\t\t"+
                student.borrowedBook[i].getAuthor()+"\t\t"+
                student.borrowedBook[i].getRentDate()+"\t\t"+
                student.borrowedBook[i].getDueDate()+"\t\t"+
                student.borrowedBook[i].getReturnDate()+"\t\t"
                );
            }
            //display message
            System.out.println("Enter Serial Number of Book to be Checked In:");
            String ISBN = input.nextLine();
            for(int i =0; i< student.getBooksCount();i++){
                 if(student.getBorrowedBook()[i].getISBN().equals(ISBN)){
                     book.checkInBook(student.getBorrowedBook()[i]);
                     System.out.println("Your fine: " +student.borrowedBook[i].getFine() );
                     student.borrowedBook[i].setRentDate(null);
                     student.borrowedBook[i].setReturnDate(null);
                     student.borrowedBook[i].setDueDate(null);
                     student.borrowedBook[i] = null;
                     return;
                 }
                
                System.out.println("Book of Serial No " + ISBN + "not found");             
    }
    }
    
    }
    public void updateStudent() {
        System.out.println("Enter the student id");
        String studentId = input.nextLine();
        for (Student student : member) {
            if(student.getStudentID().equals(studentId)){
                System.out.println("Enter the student name:");
                student.setStudentName(input.nextLine());
                System.out.println("Enter the student contact");
                student.setContactNumber(input.nextLine());
                return;
            }
        }
        System.out.println("Can not find the student to update information !");
        
    }

    public void deleteStudent() { 
        System.out.println("Enter the student id");
        String studentId = input.nextLine();
        for (Student student : member) {
            if(student.getStudentID().equals(studentId)){
                member.remove(student);
                System.out.println("Delele Successfully");
                return;
            }
        }
        System.out.println("Can not find the student to delete information !");
    }

    public void searchStudent() {
        System.out.println("Enter the student id");
        String studentId = input.nextLine();
        for (Student student : member) {
            if(student.getStudentID().equals(studentId)){
                System.out.println(student);
                return;
            }
        }
        
        System.out.println("Can not find the student to print out information");
    }

    
    
}