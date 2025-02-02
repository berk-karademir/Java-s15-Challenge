package main.library;

import main.library.books.Book;
import main.library.books.subGenres.Mystery;
import main.library.management.Inventory;
import main.library.management.Library;
import main.library.shareholders.Author;
import main.library.shareholders.Person;
import main.library.shareholders.Reader;

import java.util.List;
import java.util.Map;

public class Main {


static List<Author> yazarliste = Inventory.getAuthorsList();


    static void br() {
        System.out.println();
    }

    static void lines(){
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        br();

//        Author yazar = new Author("Yazar kişi");
//        Book kitap = new Mystery(1L,"Kitap adı burda",yazar,1,12.90);
//        lines();
//        Inventory.edgarAllanPoe.addNewBook(kitap);
//        System.out.println(kitap.getStock());
//        yazar.addNewBook(kitap);
//        System.out.println(kitap.getStock());
//
//
        Person okurKisi = new Reader("Okur kisi");
        Reader okurKisi2 = new Reader("Okur kisi vol2");
//        List<Author> yazarlar = Inventory.getAuthorsList();


//        System.out.println(library.getReaders());
//        System.out.println(library.getBooks());
//        System.out.println(library1.equals(library));
        Library library = Library.getInstance();
        System.out.println(library);


    }
}
