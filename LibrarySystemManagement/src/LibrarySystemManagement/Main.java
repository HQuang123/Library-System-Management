/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySystemManagement;

import java.util.Scanner;

/**
 *
 * @author huyng
 */
public class Main {
    public static void main(String[] args) {
        MemberManagement studentList = new MemberManagement();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

//            switch (choice) {
//                case 1:
//                    studentList.registerStudent();
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
    }
    
    public static void menu(){
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Register new student");
            System.out.println("2. Update student information");
            System.out.println("3. Delete student account");
            System.out.println("4. Search for student");
            System.out.println("5. Print list of students");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
        }
    }
}
