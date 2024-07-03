/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySystemManagement;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author huyng
 */
public class RentBook {
    private ArrayList<Student> member;
    private Student student;
    private Book book;
    private LocalDate rentDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fine;
    
    public RentBook(ArrayList<Student> member ,Student student, Book book, String rentDate, String dueDate){
        if(member.contains(student)){
            this.member = member;
            this.student = student;
            this.book = book;
            this.rentDate = LocalDate.parse(rentDate);
            this.dueDate = LocalDate.parse(dueDate);
            book.setTaken(true);
        }
        else{
            System.out.println("Can not find student in the member list");
        }
    }
    
    
    public LocalDate getRentDate() {
        return rentDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }


    public LocalDate getReturnDate() {
        return returnDate;
    }


    public Student getStudent() {
        return student;
    }

    public Book getBook() {
        return book;
    }
   
    public void setReturnDate(LocalDate returnDate){
        this.returnDate = returnDate;
    }
    
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }    

    public void trackOverdue() {
        LocalDate today = LocalDate.now();
        if (this.dueDate == null) {
            this.fine = 0;
        } 
        else if(this.returnDate == null) {
            Period period = Period.between(this.dueDate, today);
            int days = period.getDays();
            if (this.dueDate.isBefore(today)) {
                this.fine = days * 5000;
            }
        }
        else{
            if(this.returnDate.isAfter(this.dueDate)){
                Period period = Period.between(this.dueDate, this.returnDate);
                int days = period.getDays();
                this.fine = days*5000;
            }
        }
    }
}
