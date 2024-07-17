/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibrarySystemManagement;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Scanner;

/**
 *
 * @author Home
 */
public class Book  {
    private String title;
    private String author;
    private String genre;
    private String ISBN;
    private boolean isTaken;
    private LocalDate rentDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fine;
    DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendOptional(DateTimeFormatter.ofPattern("d-M-yyyy")).appendOptional(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toFormatter();
    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    Scanner input = new Scanner(System.in);

    public String getRentDate() {
        if(this.rentDate == null){
            return null;
        }
        return rentDate.format(outputFormatter);
    }

    public void setRentDate() {
         while(true){
                try{
                    System.out.println("Enter the date to rent(dd-mm-yyyy):");
                    this.rentDate = LocalDate.parse(input.nextLine(), formatter);
                    break;
                }
                catch(Exception e){
                    System.out.println("Enter the right format");
                }
            }
    }

    public String getDueDate() {
       if(this.dueDate == null){
            return null;
        }
        return this.dueDate.format(outputFormatter);
    }

    public void setDueDate() {
        while(true){
                try{
                    System.out.println("Enter the due date(dd-mm-yyyy):");
                    this.dueDate = LocalDate.parse(input.nextLine(), formatter);
                    break;
                }
                catch(Exception e){
                    System.out.println("Enter the right format");
                }
            } 
    }
    

    public String getReturnDate() {
       if(this.returnDate == null){
            return null;
        }
        return this.returnDate.format(outputFormatter);
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    
    public void resetRentDate(){
        this.rentDate = null;
    }
    
    public void resetDueDate(){
        this.dueDate = null;
    }
    
    public void resetReturnDate(){
        this.returnDate = null;
    }
    


   public Book() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Book Name: ");
        this.title = input.nextLine().toUpperCase();
        while(true) {
            try {
                System.out.println("Enter The Author: ");
                this.author = capitalizeFirstLetterAuthor(input.nextLine());
                if (!this.author.matches("^[A-Za-z.\\s_-]+$")) {
                    throw new IllegalArgumentException("Name should only contain letters and no numbers.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
  
        while(true){
            try{
            System.out.println("Enter The Genre: ");
            this.genre = input.nextLine().toUpperCase();
            if (!this.genre.matches("[A-Za-z.\\s_-]+$")) {
                    throw new IllegalArgumentException("Genre should only contain letters and no numbers.");
            }
            break;
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        while(true) {
            try {
                System.out.println("Enter The ISBN : ");
                this.ISBN = input.nextLine();
                Long.parseLong(this.ISBN);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid ISBN format. ISBN should contain only numeric digits.");
            }
        }
    
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

    public void setTitle() {
        System.out.println("Enter New Title");
        this.title = input.nextLine().toUpperCase();
    }

    public void setAuthor() {
        while(true) {
            try {
                System.out.println("Enter New Author:");
                this.author = capitalizeFirstLetterAuthor(input.nextLine());
                if (!this.author.matches("^[A-Za-z.\\s_-]+$")) {
                    throw new IllegalArgumentException("Name should only contain letters and no numbers.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setGenre() {
        while(true) {
            try {
                System.out.println("Enter New Genre:");
                this.genre = capitalizeFirstLetterAuthor(input.nextLine());
                if (!this.genre.matches("^[A-Za-z.\\s_-]+$")) {
                    throw new IllegalArgumentException("Genre should only contain letters and no numbers.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
        else if(this.returnDate == null && this.dueDate.isAfter(LocalDate.now())){
            return 0;
        }
        else {
            
            Period period = Period.between(this.dueDate, this.returnDate);
            int days = period.getDays();
            this.fine =  days*5000; 
            if(this.fine < 0){
                return 0;
            }
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
