package org.librarybeko.entity.management.pr;


import org.librarybeko.entity.management.hr.Employee;
import org.librarybeko.entity.management.hr.Person;
import org.librarybeko.entity.management.sectionmanagement.Book;
import org.librarybeko.entity.management.sectionmanagement.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Reader extends Person implements ReaderInterface {

    private static Long idCounter = 1000L;
    private Long id;
    List<Book> books;

    public Reader(String fullName) {
        super(fullName);
        this.books = new ArrayList<>();
        this.id = ++idCounter;

        Library.getInstance().getReaders().put(this.id,(Member)this);
        System.out.println(getClass().getSimpleName() +"\s"+ getFullName() +" has been registered to Library Beko.");

    }

    public Long getId() {
        return id;
    }

    public List<Book> getBooks() {
        return books;
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

//", " +getFullName() +" currently " + (books.isEmpty() ? "has not borrow any books." : (books.size() == 1 ? "has a book borrowed. It is: " + books.get(0) : "has " + books.size() + " books borrowed:\n" + books)
    @Override
    public String toString() {
        return super.toString() + ", ID: " + id;
    }


    public static interface PersonInterface {
        void whoAreYou();
    }
}
