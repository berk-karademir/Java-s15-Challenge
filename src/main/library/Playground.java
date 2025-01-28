package main.library;

import main.library.books.Book;
import main.library.books.Status;
import main.library.books.subGenres.Classic;
import main.library.shareholders.Author;
import main.library.shareholders.Person;
import main.library.shareholders.Reader;

import java.util.ArrayList;
import java.util.List;

public class Playground {

    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();
        Person yazarYazmazYazanYazar = new Author("Aylak yazar");


        // fieldları boş set etmeye çalışıyoruz, her biri hata fırlatmalı -PASS :)

//        Person author = new Author("");
//        Person reader = new Reader("1",bookList);
//       Book book = new Classic(1L,"buk neym", yazarYazmazYazanYazar,1, Status.BORROWABLE,10.90 );
//        System.out.println(book.equals(book2));
//        bookList.add(book);
//        Person reader = new Reader("", bookList);

    }




}
