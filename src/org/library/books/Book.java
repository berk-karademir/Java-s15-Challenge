package org.library.books;

import org.library.shareholders.Author;
import org.library.shareholders.Person;
import org.library.shareholders.Reader;

import java.util.Objects;


public abstract class Book {

    private static Long idCounter = 0L;
    private Long bookId;
    private Long ISBN;
    private Category category;
    private String title;
    private Person author;
    private Integer edition;
    private Status bookStatus;
    private Double price;


    public Book(Long ISBN, String title, Person author, Integer edition, Status bookStatus, Double price) {
        this.bookId = ++idCounter;
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.bookStatus = bookStatus;
        this.price = price;
    }

    public static Long getIdCounter() {
        return idCounter;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getISBN() {
        return ISBN;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getEdition() {
        return edition;
    }

    public Status getBookStatus() {
        return bookStatus;
    }

    public Double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public Person getAuthor() {
        return author;
    }

    public void changeOwner(Reader reader) {
        // Implementation needed
    }

    public void getOwner(Reader reader) {
        // Implementation needed
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void display() {
        System.out.println(this.toString());
    }


    public void setBookStatus(Status bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void updateStatus(Status status) {
        setBookStatus(status);
    }


    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Book book)) return false;
        return Objects.equals(bookId, book.bookId);
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
                "Status: " + bookStatus +
                "\n";
    }

}
