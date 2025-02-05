package org.librarybeko.entity.management.pr;

import org.librarybeko.entity.management.hr.PersonInterface;
import org.librarybeko.entity.management.sectionmanagement.Book;

public interface ReaderInterface extends PersonInterface {

     void purchaseBook(Book book);
     void borrowBook(Book book);
     void returnBook(Book book);
}
