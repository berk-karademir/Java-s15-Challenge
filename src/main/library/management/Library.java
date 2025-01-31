package main.library.management;

import main.library.books.Book;
import main.library.shareholders.LibraryMember;
import main.library.shareholders.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Singleton Class
public class Library {
    private static Library instance;
    private List<Book> books;
    private List<Reader> readers;

    private Library() {
        this.books = Inventory.bookList;
        this.readers = new ArrayList<>();
    }


    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }


    public void addReader(Reader reader) {
        readers.add(reader);
        System.out.println(reader.getFullName() + " has been added to the library as a reader.");
    }



    @Override
    public String toString() {
        return "Library:\n" +
                "Books in inventory: " + books + "\n" +
                "Member readers: " + readers + "\n" ;
    }
}
