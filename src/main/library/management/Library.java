package main.library.management;

import main.library.books.Book;
import main.library.shareholders.Reader;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private static Library instance;  // Singleton örneği
    private List<Book> books;
    private List<Reader> readers;

    // **PRIVATE constructor**
    private Library() {
        this.books = Inventory.bookList;
        this.readers = new ArrayList<>();
    }

    // Singleton nesnesini döndüren metot
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

    // Yeni okuyucuyu Library'ye ekleme
    public void addReader(Reader reader) {
        readers.add(reader);
        System.out.println(reader.getFullName() + " has been added to the library system.");
    }

    @Override
    public String toString() {
        return "Library:\n" +
                "Books in inventory: " + books + "\n" +
                "Member readers: " + readers + "\n" ;
    }
}
