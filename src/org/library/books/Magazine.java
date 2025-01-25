package org.library.books;

import org.library.shareholders.Person;

public class Magazine extends Book {


    public Magazine(long ISBN, Category category, String title, Person author, int edition, Status bookStatus, double price) {
        super(ISBN, category, title, author, edition, bookStatus, price);
    }
}