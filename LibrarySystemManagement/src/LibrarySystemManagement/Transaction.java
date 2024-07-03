/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySystemManagement;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author huyng
 */
public class Transaction {
    private List<RentBook> transactions;
    
    public Transaction(RentBook rentBook){
        this.transactions.add(rentBook);
    }
    
    public List<RentBook> getTransactions() {
        return this.transactions;
    }
    
    public void returnBook(String studentId, String ISBN, LocalDate returnDate){
        boolean status = true;
        for (RentBook transaction : transactions) {
            if(transaction.getStudent().getStudentID().equals(studentId) && transaction.getBook().getISBN().equals(ISBN) && transaction.getBook().isTaken() == true){
                transaction.setReturnDate(returnDate);
                transaction.getBook().setTaken(false);
                status = false;
            }
        }
        if(status){
            System.out.println("The book is available, you can borrow !");
        }
    }
    
    
    
    
}
