/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySystemManagement;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MemberManagement {
    private ArrayList<Student> member;

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
    
    public void updateStudent(Student studentId, String studentName, String contactNumber) {
        boolean status = true;
        for (Student student : member) {
            if(student.getStudentID().equals(studentId)){
                student.setStudentName(studentName);
                student.setContactNumber(contactNumber);
                status = false;
                break;
            }
        }
        if(status){
            System.out.println("Can not find the student to update information !");
        }
        
    }

    public void deleteStudent(Student studentId) {      
        boolean status = true;
        for (Student student : member) {
            if(student.getStudentID().equals(studentId)){
                member.remove(student);
                status = false;
                break;
            }
        }
        if(status){
            System.out.println("Can not find the student do delete information");
        }
    }

    public void searchStudent(String studentId) {
        boolean status = true;
        for (Student student : member) {
            if(student.getStudentID().equals(studentId)){
                System.out.println(student);
                status = false;
                break;
            }
        }
        if(status){
            System.out.println("Can not find the student to print out information");
        }
    }

    public void printAllStudents() {
        if (member.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            for (Student student : member) {
                System.out.println(student);
            }
        }
    }

//    public void menuStudent() {
//        while (true) {
//            System.out.println("\nStudent Management System");
//            System.out.println("1. Register new student");
//            System.out.println("2. Update student information");
//            System.out.println("3. Delete student account");
//            System.out.println("4. Search for student");
//            System.out.println("5. Print list of students");
//            System.out.println("6. Exit");
//            System.out.print("Choose an option: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    registerStudent();
//                    break;
//                case 2:
//                    updateStudent();
//                    break;
//                case 3:
//                    deleteStudent();
//                    break;
//                case 4:
//                    searchStudent();
//                    break;
//                case 5:
//                    printAllStudents();
//                    break;
//                case 6:
//                    System.out.println("Exiting...");
//                    return;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
    
}