/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibrarySystemManagement;

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Home
 */
public class BookManagement {
    
    private ArrayList<Book> books;

    public BookManagement() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter new author: ");
                String newAuthor = scanner.nextLine();
                System.out.print("Enter new genre: ");
                String newGenre = scanner.nextLine();
                book.setAuthor(newAuthor);
                book.setGenre(newGenre);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found.");
    }

    public void deleteBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
    }

    public void searchBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found.");
    }

    public void printBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
