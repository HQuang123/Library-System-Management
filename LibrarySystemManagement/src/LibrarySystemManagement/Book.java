/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibrarySystemManagement;

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

    public Book(String title, String author, String genre, String ISBN) {
        this.title = title.toUpperCase();
        this.author = capitalizeFirstLetter(author);
        this.genre = genre;
        this.ISBN = ISBN;
        this.isTaken = false; 
    }
  private String capitalizeFirstLetter(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
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

    public boolean isTaken() {
        return isTaken;
    }
}
