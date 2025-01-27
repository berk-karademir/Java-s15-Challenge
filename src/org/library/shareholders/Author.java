package org.library.shareholders;

import org.library.books.Book;


public class Author extends Person {

    public Author(String name) {
        super(name);
    }

    public void newBook(Book book) {

    }

    public void showBook(Book book) {
        System.out.println(book.getAuthor());
    }

    @Override
    public void whoAreYou() {
        super.whoAreYou();
    }
}
