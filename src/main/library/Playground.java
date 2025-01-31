package main.library;

import main.library.books.Book;
import main.library.books.Status;
import main.library.books.subGenres.Dystopian;
import main.library.books.subGenres.Fiction;
import main.library.management.Inventory;
import main.library.shareholders.Author;
import main.library.shareholders.Librarian;
import main.library.shareholders.Person;
import main.library.shareholders.Reader;

import java.util.List;

public class Playground {

    public static void main(String[] args) {



        // fieldları boş set etmeye çalışıyoruz, her biri hata fırlatmalı -PASS :)

//        Person author = new Author("");
//        Person reader = new Reader("1",bookList);
//       Book book = new Classic(1L,"buk neym", yazarYazmazYazanYazar,1, Status.BORROWABLE,10.90 );
//        System.out.println(book.equals(book2));
//        bookList.add(book);
//        Person reader = new Reader("", bookList);

        // Kitapları almak için getBooks metodunu kullanın

//
//        List<Author> authors = Library.getAuthors();
//        List<Book> books = Library.getAllBooks();
//
//        System.out.println("All authors:" + authors);
//        System.out.println("All books:" + books);
//
//        // Örnek: Agatha Christie tarafından yazılan kitapları filtrelemek
//        System.out.println("\nBooks by Agatha Christie:");
//        for (Book book : books) {
//            if (book.getAuthor().equals(Library.agathaChristie)) {
//                System.out.println("- " + book.getTitle());
//            }
//        }
//
//        System.out.println("\nBooks by Kemal Tahir:");
//        for (Book book : books) {
//            if (book.getAuthor().equals(Library.kemalTahir)) {
//                System.out.println("- " + book.getTitle());
//            }
//        }
//
//        System.out.println("-----------------------------------------------------------");
        Author yazar1 = new Author("Yazar Bey");
//        Book book1 = new Fiction(123L, "Fiction book", yazar1,1,12.90);
//        yazar1.addNewBook(book1);
//        System.out.println(yazar1);
//        yazar1.showBook();
//        yazar1.whoAreYou();
        Librarian librarian = new Librarian("Librarian");
//        librarian.searchBook(book1);
//        System.out.println();
//        librarian.searchBookByAuthorName("Agatha Christie");
//        librarian.searchBookByAuthorName("Halide Edip Adıvar");
//        librarian.searchBookByTitle("The Last Letter");
//
//        Book book = new Fiction(123L, "The Museum of Innocence", Inventory.halideEdipAdivar, 2, 11.90);
//
//        Inventory.halideEdipAdivar.addNewBook(book);
//
//        System.out.println(book.getStock());
//
//        Reader reader = new Reader("okur kişi");
//                    reader.borrowBook(book);
//        System.out.println(book.getStock());

//        librarian.searchBook(" ");
//        librarian.searchBook("");
//
//        librarian.searchBook("asd");
//        librarian.searchBook("       1984         ");
//        librarian.searchBook("1984");
//        System.out.println();
//        librarian.searchBook("pott");
//        librarian.searchBook("mys");
//        librarian.searchBook("comedy");
//        librarian.searchBook("com");
//        librarian.searchBook("class");
//        System.out.println("*****************************");
//        librarian.searchBook("aziz");
        librarian.searchBook("the");



    }
}
