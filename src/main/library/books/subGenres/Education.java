package main.library.books.subGenres;

import main.library.books.Book;
import main.library.books.Category;
import main.library.books.Status;
import main.library.shareholders.Author;

public class Education extends Book {
    public Education(Long ISBN, String title, Author author, Integer edition, Status bookStatus, Double price) {
        super(ISBN, title, author, edition, price);
        setCategory(Category.EDUCATION);
    }
}
