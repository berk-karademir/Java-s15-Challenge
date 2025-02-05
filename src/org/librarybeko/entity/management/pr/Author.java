package org.librarybeko.entity.management.pr;

import org.librarybeko.entity.management.hr.Person;
import org.librarybeko.entity.management.sectionmanagement.Book;
import org.librarybeko.entity.management.sectionmanagement.Inventory;

import java.util.ArrayList;
import java.util.List;


public class Author extends Person {

    private List<Book> books;

    public Author(String name) {
        super(name);
        this.books = new ArrayList<>();
        Inventory.addAuthor(this);
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    public void addNewBook(Book book){
        if(!book.getAuthor().equals(this)) {
            System.out.println("Eklemeye çalıştığın kitabın yazarı başka bir yazar!");
        } else if (books.contains(book)) {
            System.out.println("Bu yazarın bu kitabı zaten kütüphane envanterinde mevcut, yeni kitap kaydı yerine stok 1 arttırıldı!");
            book.setStock(book.getStock()+1);

        }
        this.books.add(book);
    };


    public List<Book> getBooks() {
        return books;
    }

    public void showBook() {
        if (books.isEmpty()) {
            System.out.println(getFullName() + " has no books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book.toString());
            if(books.size() == 1) {
                System.out.println("We have a book in our library, written by " + getFullName() + ":");
                System.out.println(book);
                return;
            } else if (books.size() > 1) {
                System.out.println("The books in our library, written by " + getFullName() + ":");
                System.out.println(book);
            }
            }
        }
    }




    @Override
    public void whoAreYou() {
        System.out.println("I'm an " + getClass().getSimpleName().toLowerCase() + ", my name is " + getFullName() + ", call showBook method to check my books in this library.");
    }

    @Override
    public String toString() {
        return super.toString();
    }


    //+ ", i have "+ books.size() + (books.size() != 1 ? " books " : " book ") +"in this library and you can call my showBook method to see all my books."
}
