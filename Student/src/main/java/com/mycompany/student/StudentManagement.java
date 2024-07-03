
package com.mycompany.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StudentManagement {
    private final List<Student> students;
    private final Scanner scanner;

    public StudentManagement() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void registerStudent() {
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter Student ID (HE+ID number): ");
        String studentID = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();
        students.add(new Student(studentName, studentID, contactNumber));
        System.out.println("Student registered successfully.");
    }

    public void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String studentID = scanner.nextLine();
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                System.out.print("Enter new Student Name: ");
                String studentName = scanner.nextLine();
                System.out.print("Enter new Contact Number: ");
                String contactNumber = scanner.nextLine();
                student.setStudentName(studentName);
                student.setContactNumber(contactNumber);
                System.out.println("Student information updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
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

    public void menu() {
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

    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        management.menu();
    }
}