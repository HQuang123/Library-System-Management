/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySystemManagement;

import java.util.Comparator;

/**
 *
 * @author huyng
 */
public class SortByISBN implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getISBN().compareTo(o2.getISBN());
    }
    
}
