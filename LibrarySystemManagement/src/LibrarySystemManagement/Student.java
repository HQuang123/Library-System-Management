/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySystemManagement;

import java.util.ArrayList;

/**
 *
 * @author huyng
 */
class Student {
    private String studentName;
    private String studentID;
    private String contactNumber;

    public Student(String studentName, String studentID, String contactNumber) {
        this.studentName = capitalizeFirstLetter(studentName);
        this.studentID = studentID;
        this.contactNumber = contactNumber;
    }

    private String capitalizeFirstLetter(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentID() {
        return "HE" +  studentID;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setStudentName(String studentName) {
        this.studentName = capitalizeFirstLetter(studentName);
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "StudentName: " + studentName + ", StudentID: " + studentID + ", ContactNumber: " + contactNumber;
    }
    
    
    
}
