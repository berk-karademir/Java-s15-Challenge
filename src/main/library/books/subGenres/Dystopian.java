package main.library.books.subGenres;

import main.library.books.Book;
import main.library.books.Category;
import main.library.books.Status;
import main.library.shareholders.Author;
import main.library.shareholders.Person;

public class Dystopian extends Book {

    public Dystopian(Long ISBN, String title, Author author, Integer edition, Double price) {
        super( ISBN, title, author, edition, price);
        setCategory(Category.DYSTOPIAN);
    }
}
