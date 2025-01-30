package main.library.shareholders;


import main.library.books.Book;
import main.library.books.Status;
import main.library.management.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reader extends Person implements ReaderInterface{

    private static Long idCounter = 1000L;
    private Long id;
    List<Book> books;
    public Reader(String name) {
        super(name);
        this.books = new ArrayList<>();
        this.id = ++idCounter;
        Library.getInstance().addReader(this);

    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void purchaseBook(Book book) {
        if (book.getStock() >=1) {
            System.out.println("Purchase free: " + book.getPrice());
            books.add(book);
            book.setStock(book.getStock()-1);
            System.out.println(book.getTitle() + " has been bought by " + this.getFullName());

        }

    }

    @Override
    public void borrowBook(Book book) {
        if (book.getStock() >= 1) {
            System.out.println("Loan fee: " + book.getPrice());
            books.add(book);
            book.setStock(book.getStock() - 1);
            book.setBookStatus(Status.LENDED);
            System.out.println("'" +book.getTitle() + "'" + " has been borrowed by " + this.getFullName());
        }
    }

    @Override
    public void returnBook(Book book) {
        books.remove(book);
        book.setStock(book.getStock() + 1);
        book.setBookStatus(Status.BORROWABLE);
        System.out.println(book.getTitle() + " has been returned by " + this.getFullName());

    }

    @Override
    public void whoAreYou() {
        System.out.println("I'm a " + getClass().getSimpleName().toLowerCase() + ", my name is " + getFullName() + ", my Library Member ID: " + id + ".");
    }

    public void showBook() {
        for(Book book : books) {
            System.out.println(getClass().getSimpleName() + "'s books:" + book);
        }
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


//    @Override
//    public String toString() {
//        return super.toString() + ", ID: " + id + ", " +getFullName() +" currently " + (books.isEmpty() ? "has not borrow any books." : (books.size() == 1 ? "has a book borrowed. It is: " + books.get(0) : "has " + books.size() + " books borrowed:\n" + books));
//    }


}
