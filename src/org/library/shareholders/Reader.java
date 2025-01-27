package org.library.shareholders;


import org.library.SectionManagement;
import org.library.books.Book;

import java.util.List;

public class Reader extends Person {

    List<Book> readerBooks;

    public Reader(String name, List<Book> readerBooks) {
        super(name);
        this.readerBooks = readerBooks;
    }

    public void purchaseBook(Book book) {

    }

    public void borrowBook(Book book) {

    }

    public void returnBook(Book book) {

    }

    

}
