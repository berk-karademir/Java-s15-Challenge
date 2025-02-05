package org.librarybeko.entity.management.sectionmanagement;

import org.librarybeko.entity.management.hr.Employee;
import org.librarybeko.entity.management.hr.Librarian;
import org.librarybeko.entity.management.pr.Member;
import org.librarybeko.entity.management.pr.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Singleton Class
public class Library {
    private String brandName;
    private static Library instance;
    private List<Book> books;
    private Map<Long,Member> readers;
    private List<Employee> employees;

    private Library() {
        this.brandName ="Library Beko";
        this.books = Inventory.bookList;
        this.readers = new HashMap<>();
        this.employees = new ArrayList<>();
    }


    public String getBrandName() {
        return brandName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public static synchronized Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Map<Long, Member> getReaders() {
        return readers;
    }

    @Override
    public String toString() {
        return brandName + " has:\n"
                +"- "+ books.size() + " books from " + Inventory.getAuthorsList().size() + " different authors, " + readers.size() + " registered members, and " + employees.size() + " employees.\n" +
                "Books in inventory: " + books + "\n" +
                "Members:\n" + readers + "\n" +
                "Employees:\n" + employees;
    }
}
