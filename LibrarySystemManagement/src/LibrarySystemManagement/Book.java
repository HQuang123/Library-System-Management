/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibrarySystemManagement;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Home
 */
public class Book {
    private String title;
    private String author;
    private String genre;
    private String ISBN;
    private boolean isTaken;
    private LocalDate rentDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fine;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    Scanner input = new Scanner(System.in);

    public String getRentDate() {
        if(this.rentDate == null){
            return null;
        }
        return rentDate.format(formatter);
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public String getDueDate() {
       if(this.dueDate == null){
            return null;
        }
        return this.dueDate.format(formatter);
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getReturnDate() {
       if(this.returnDate == null){
            return null;
        }
        return this.returnDate.format(formatter);
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book() {
        System.out.println("Enter Book Name: ");
        this.title = input.nextLine().toUpperCase();
        System.out.println("Enter The Author: ");
        this.author = capitalizeFirstLetterAuthor(input.nextLine());
        System.out.println("Enter The Genre: ");
        this.genre = input.nextLine().toUpperCase();
        System.out.println("Enter The ISBN");
        this.ISBN = input.nextLine();
        this.isTaken = false;
    }
  
    private String capitalizeFirstLetterAuthor(String author) {
        String[] nameList = author.split(" ");
        for(int i  = 0 ; i< nameList.length;i++){
            nameList[i] = nameList[i].substring(0, 1).toUpperCase() + nameList[i].substring(1).toLowerCase();
        }
        
        return String.join(" ", nameList);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean getIsTaken() {
        return isTaken;
    }

    public void setTitle(String title) {
        this.title = title.toUpperCase();
    }

    public void setAuthor(String author) {
        this.author = capitalizeFirstLetterAuthor(author);
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }
    
    public double getFine() {
        if(this.rentDate == null){
            this.fine =  0;
            return this.fine;
        }
        else if(this.returnDate == null && this.dueDate.isBefore(LocalDate.now())){
            Period period = Period.between(this.dueDate, this.rentDate);
            int days = period.getDays();
            this.fine = days*5000; 
            return this.fine;
        }
        else if(this.returnDate.isBefore(this.dueDate)){
            return 0;
        }
        else {
            
            Period period = Period.between(this.dueDate, this.returnDate);
            int days = period.getDays();
            this.fine =  days*5000; 
            return this.fine;
        }
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public String toString(){
        return "Title: " + this.title + ", Author: " + this.author + ", ISBN: " + this.ISBN + ", Genre: " + this.genre;
    }
}
