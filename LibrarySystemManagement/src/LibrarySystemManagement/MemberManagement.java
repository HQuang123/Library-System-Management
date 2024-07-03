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
            }
        }
        
        if(status){
            member.add(student);
        }
    }
    
    public void updateStudent(Student studentid) {
        
    }

    public void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String studentID = scanner.nextLine();
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                students.remove(student);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String studentID = scanner.nextLine();
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void menuStudent() {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Register new student");
            System.out.println("2. Update student information");
            System.out.println("3. Delete student account");
            System.out.println("4. Search for student");
            System.out.println("5. Print list of students");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    printAllStudents();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
}