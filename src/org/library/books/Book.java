package org.library.books;

import org.library.shareholders.Author;
import org.library.shareholders.Person;
import org.library.shareholders.Reader;

import java.util.Objects;


public abstract class Book {

    private static int idCounter = 0;
    private int bookId;
    private long ISBN;
    private Category category;
    private String title;
    private Person author;
    private int edition;
    private Status bookStatus;
    private double price;


    public Book(long ISBN, Category category, String title, Person author, int edition, Status bookStatus, double price) {
        this.bookId = ++idCounter;
        this.ISBN = ISBN;
        this.category = category;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.bookStatus = bookStatus;
        this.price = price;

    }


    public int getBookId() {
        return bookId;
    }

    public long getISBN() {
        return ISBN;
    }

    public Category getCategory() {
        return category;
    }

    public int getEdition() {
        return edition;
    }

    public Status getBookStatus() {
        return bookStatus;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public Person getAuthor() {
        return author;
    }


    public void setBookStatus(Status bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void changeOwner(Reader reader) {
        // Implementation needed
    }

    public void getOwner(Reader reader) {
        // Implementation needed
    }

    public void display() {
        System.out.println(this.toString());
    }

    public void updateStatus(Status status) {

    }


    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Book book)) return false;
        return bookId == book.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bookId);
    }

    @Override
    public String toString() {
        return "\nBook's: \n" +
                "ID: " + bookId + "\n" +
                "ISBN: " + ISBN + "\n" +
                "Category: " + category + "\n" +
                "Title: '" + title + '\'' + "\n" +
                "Author: " + author + "\n" +
                "Edition: " + edition + "\n" +
                "Price: $" + price + "\n" +
                "Status: " + (bookStatus.equals(Status.BORROWABLE) ? "Borrowable" : "All landed right now, you can check later.") +
                "\n";
    }

}
