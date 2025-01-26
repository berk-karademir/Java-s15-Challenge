package org.library.books;

import org.library.shareholders.Person;

public class Fantasy extends Book {
    public Fantasy(long ISBN,String title, Person author, int edition, Status bookStatus, double price) {
        super(ISBN, title, author, edition, bookStatus, price);
    }
}
