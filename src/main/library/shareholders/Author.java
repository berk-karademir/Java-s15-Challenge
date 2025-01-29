package main.library.shareholders;

import main.library.books.Book;

import java.util.ArrayList;
import java.util.List;


public class Author extends Person {

    private List<Book> books;

    public Author(String name) {
        super(name);
        this.books = new ArrayList<>();
    }

    public void addNewBook(Book book){
        books.add(book);
    };


    public List<Book> getBooks() {
        return books;
    }

    public void showBook(){
        System.out.println("The books written by " + getFullName() + ":");
        for (Book book : books) {
            System.out.println("- " + book.getTitle());
        };
    }

    public void whoAreYou() {
        System.out.println("I'm an " + getClass().getSimpleName().toLowerCase() + ", my name is " + getFullName() + ".");
    }

    @Override
    public String toString() {
        return super.toString();
    }
         //+ ", i have "+ books.size() + (books.size() != 1 ? " books " : " book ") +"in this library and you can call my showBook method to see all my books."
}
