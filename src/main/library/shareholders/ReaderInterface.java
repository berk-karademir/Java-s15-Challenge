package main.library.shareholders;

import main.library.books.Book;

public interface ReaderInterface {

     void purchaseBook(Book book);
     void borrowBook(Book book);
     void returnBook(Book book);
}
