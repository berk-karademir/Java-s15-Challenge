package main.library.shareholders;


import main.library.books.Book;

import java.util.List;
import java.util.Objects;

public class Reader extends Person {

    private static Long idCounter = 1000L;
    private Long id;
    List<Book> books;

    public Reader(String name, List<Book> books) {
        super(name);
        this.books = books;
        this.id = ++idCounter;
    }

    public void purchaseBook(Book book) {

    }

    public void borrowBook(Book book) {

    }

    public void returnBook(Book book) {

    }

    @Override
    public void whoAreYou() {
        System.out.println("I'm a " + getClass().getSimpleName().toLowerCase() + ", my name is " + getFullName() + ", my Library Member ID: " + id + ".");
    }


    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Reader reader)) return false;
        return Objects.equals(id, reader.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    @Override
    public String toString() {
        return super.toString() + ", ID: " + id + ", currently i " + (books.isEmpty() ? "haven't borrow any books." : (books.size() == 1 ? "have a book borrowed. It is: " + books.get(0) : "have " + books.size() + " books borrowed:\n" + books));
    }
}
