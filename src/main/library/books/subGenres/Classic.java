package main.library.books.subGenres;

import main.library.books.Book;
import main.library.books.Category;
import main.library.books.Status;
import main.library.shareholders.Person;

public class Classic extends Book {
    public Classic(Long ISBN, String title, Person author, Integer edition, Status bookStatus, Double price) {
        super(ISBN, title, author, edition, bookStatus, price);
        setCategory(Category.CLASSIC);
    }

}
