package org.library.books;

import org.library.shareholders.Person;

public class Whodunit extends Book{
    public Whodunit(long ISBN, Category category, String title, Person author, int edition, Status bookStatus, double price) {
        super(ISBN, category, title, author, edition, bookStatus, price);
    }


}
