package main.library;

import main.library.books.Book;
import main.library.books.Status;
import main.library.books.subGenres.*;
import main.library.books.subGenres.Fantasy;
import main.library.shareholders.Author;
import main.library.shareholders.Person;

import java.util.*;

public class SectionManagement {
    public static Author agathaChristie, jkRowling, georgeOrwell, ernestHemingway, markTwain,
            charlesDickens, leoTolstoy, fyodorDostoevsky, franzKafka, williamShakespeare,
            victorHugo, miguelDeCervantes, johannWolfgangVonGoethe, jamesJoyce, hermanMelville,
            edgarAllanPoe, albertCamus, jeanPaulSartre, khaledHosseini, isabelAllende, umbertoEco,
            pauloCoelho, johnSteinbeck, orhanPamuk, yasarKemal, nazimHikmet, orhanVeli, ahmetHamdiTanpinar,
            sabahattinAli, elifSafak, halideEdipAdivar, attilaIlhan, azizNesin, peyamiSafa,
            tarıkBugra, resatNuriGuntekin, oguzAtay, cahitSıtkıTarancı, saitFaikAbasıyanık,
            haldunTaner, zülfüLivaneli, latifeTekin, kemalTahir;
    static Random random = new Random();

    // ArrayList oluşturuluyor
    private static List<Author> authorsList = new ArrayList<>();

    // Statik blok ile yazarları oluştur ve listeye ekle
    static {
        agathaChristie = new Author("Agatha Christie"); authorsList.add(agathaChristie);
        jkRowling = new Author("J.K. Rowling"); authorsList.add(jkRowling);
        georgeOrwell = new Author("George Orwell"); authorsList.add(georgeOrwell);
        ernestHemingway = new Author("Ernest Hemingway"); authorsList.add(ernestHemingway);
        markTwain = new Author("Mark Twain"); authorsList.add(markTwain);
        charlesDickens = new Author("Charles Dickens"); authorsList.add(charlesDickens);
        leoTolstoy = new Author("Leo Tolstoy"); authorsList.add(leoTolstoy);
        fyodorDostoevsky = new Author("Fyodor Dostoevsky"); authorsList.add(fyodorDostoevsky);
        franzKafka = new Author("Franz Kafka"); authorsList.add(franzKafka);
        williamShakespeare = new Author("William Shakespeare"); authorsList.add(williamShakespeare);
        victorHugo = new Author("Victor Hugo"); authorsList.add(victorHugo);
        miguelDeCervantes = new Author("Miguel de Cervantes"); authorsList.add(miguelDeCervantes);
        johannWolfgangVonGoethe = new Author("Johann Wolfgang von Goethe"); authorsList.add(johannWolfgangVonGoethe);
        jamesJoyce = new Author("James Joyce"); authorsList.add(jamesJoyce);
        hermanMelville = new Author("Herman Melville"); authorsList.add(hermanMelville);
        edgarAllanPoe = new Author("Edgar Allan Poe"); authorsList.add(edgarAllanPoe);
        albertCamus = new Author("Albert Camus"); authorsList.add(albertCamus);
        jeanPaulSartre = new Author("Jean-Paul Sartre"); authorsList.add(jeanPaulSartre);
        khaledHosseini = new Author("Khaled Hosseini"); authorsList.add(khaledHosseini);
        isabelAllende = new Author("Isabel Allende"); authorsList.add(isabelAllende);
        umbertoEco = new Author("Umberto Eco"); authorsList.add(umbertoEco);
        pauloCoelho = new Author("Paulo Coelho"); authorsList.add(pauloCoelho);
        johnSteinbeck = new Author("John Steinbeck"); authorsList.add(johnSteinbeck);
        orhanPamuk = new Author("Orhan Pamuk"); authorsList.add(orhanPamuk);
        yasarKemal = new Author("Yaşar Kemal"); authorsList.add(yasarKemal);
        nazimHikmet = new Author("Nazım Hikmet"); authorsList.add(nazimHikmet);
        orhanVeli = new Author("Orhan Veli"); authorsList.add(orhanVeli);
        ahmetHamdiTanpinar = new Author("Ahmet Hamdi Tanpınar"); authorsList.add(ahmetHamdiTanpinar);
        sabahattinAli = new Author("Sabahattin Ali"); authorsList.add(sabahattinAli);
        elifSafak = new Author("Elif Şafak"); authorsList.add(elifSafak);
        halideEdipAdivar = new Author("Halide Edip Adıvar"); authorsList.add(halideEdipAdivar);
        attilaIlhan = new Author("Attilâ İlhan"); authorsList.add(attilaIlhan);
        azizNesin = new Author("Aziz Nesin"); authorsList.add(azizNesin);
        peyamiSafa = new Author("Peyami Safa"); authorsList.add(peyamiSafa);
        tarıkBugra = new Author("Tarık Buğra"); authorsList.add(tarıkBugra);
        resatNuriGuntekin = new Author("Reşat Nuri Güntekin"); authorsList.add(resatNuriGuntekin);
        oguzAtay = new Author("Oğuz Atay"); authorsList.add(oguzAtay);
        cahitSıtkıTarancı = new Author("Cahit Sıtkı Tarancı"); authorsList.add(cahitSıtkıTarancı);
        saitFaikAbasıyanık = new Author("Sait Faik Abasıyanık"); authorsList.add(saitFaikAbasıyanık);
        haldunTaner = new Author("Haldun Taner"); authorsList.add(haldunTaner);
        zülfüLivaneli = new Author("Zülfü Livaneli"); authorsList.add(zülfüLivaneli);
        latifeTekin = new Author("Latife Tekin"); authorsList.add(latifeTekin);
        kemalTahir = new Author("Kemal Tahir"); authorsList.add(kemalTahir);
    }

    public static List<Author> getAuthors() {
        return authorsList;
    }

    public static Long createRandomISBN() {
        return 1000000000000L + (long) (random.nextDouble() * 9000000000000L);
    }

    public static Integer createRandomEdition() {
        return random.nextInt(20) + 1;
    }

    public static Double createRandomPrice() {
        return 4.90 + (random.nextDouble() * (100.00 - 4.90));
    }


    public static List<Book> getBooks() {

        List<Book> books = new ArrayList<>();





        books.add(new Mystery(createRandomISBN(), "Murder on the Orient Express", agathaChristie, createRandomEdition(), Status.LENDED, createRandomPrice()));

        books.add(new Fantasy(createRandomISBN(), "Harry Potter and the Philosopher's Stone", jkRowling, createRandomEdition(), Status.PURCHASABLE, createRandomPrice()));

        books.add(new Dystopian(createRandomISBN(), "1984", georgeOrwell, createRandomEdition(), Status.LENDED, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Old Man and the Sea", ernestHemingway, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Classic(createRandomISBN(), "The Adventures of Tom Sawyer", markTwain, createRandomEdition(), Status.IN_PREPARATION_STAGE, createRandomPrice()));

        books.add(new Classic(createRandomISBN(), "A Tale of Two Cities", charlesDickens, createRandomEdition(), Status.PURCHASABLE, createRandomPrice()));

        books.add(new Classic(createRandomISBN(), "War and Peace", leoTolstoy, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Classic(createRandomISBN(), "Crime and Punishment", fyodorDostoevsky, createRandomEdition(), Status.LENDED, createRandomPrice()));

        books.add(new Classic(createRandomISBN(), "The Metamorphosis", franzKafka, createRandomEdition(), Status.PURCHASABLE, createRandomPrice()));

        books.add(new Play(createRandomISBN(), "Hamlet", williamShakespeare, createRandomEdition(), Status.IN_PREPARATION_STAGE, createRandomPrice()));

        books.add(new Classic(createRandomISBN(), "Les Misérables", victorHugo, createRandomEdition(), Status.PURCHASABLE, createRandomPrice()));

        books.add(new Classic(createRandomISBN(), "Don Quixote", miguelDeCervantes, createRandomEdition(), Status.LENDED, createRandomPrice()));

        books.add(new Classic(createRandomISBN(), "Faust", johannWolfgangVonGoethe, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Classic(createRandomISBN(), "Ulysses", jamesJoyce, createRandomEdition(), Status.LENDED, createRandomPrice()));

        books.add(new Classic(createRandomISBN(), "Moby Dick", hermanMelville, createRandomEdition(), Status.PURCHASABLE, createRandomPrice()));

        books.add(new Classic(createRandomISBN(), "The Raven", edgarAllanPoe, createRandomEdition(), Status.IN_PREPARATION_STAGE, createRandomPrice()));

        books.add(new Philosophy(createRandomISBN(), "The Stranger", albertCamus, createRandomEdition(), Status.PURCHASABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "Nausea", jeanPaulSartre, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Kite Runner", khaledHosseini, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The House of the Spirits", isabelAllende, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Name of the Rose", umbertoEco, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Grapes of Wrath", johnSteinbeck, createRandomEdition(), Status.PURCHASABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "My Name is Red", orhanPamuk, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "Innocent", yasarKemal, createRandomEdition(), Status.LENDED, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Time Regulation Institute", nazimHikmet, createRandomEdition(), Status.PURCHASABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Devil's Advocate", orhanVeli, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Silent House", ahmetHamdiTanpinar, createRandomEdition(), Status.LENDED, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Last Train", sabahattinAli, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Black Book", elifSafak, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Museum of Innocence", halideEdipAdivar, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Time of the Gypsies", attilaIlhan, createRandomEdition(), Status.LENDED, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Last Letter", azizNesin, createRandomEdition(), Status.PURCHASABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Last Train to Istanbul", peyamiSafa, createRandomEdition(), Status.LENDED, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Bastard of Istanbul", tarıkBugra, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Time Regulation Institute", resatNuriGuntekin, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Book of Whispers", oguzAtay, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Last Letter", cahitSıtkıTarancı, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Silent House", saitFaikAbasıyanık, createRandomEdition(), Status.LENDED, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Black Book", haldunTaner, createRandomEdition(), Status.PURCHASABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Museum of Innocence", zülfüLivaneli, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Time of the Gypsies", latifeTekin, createRandomEdition(), Status.IN_PREPARATION_STAGE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Last Train", kemalTahir, createRandomEdition(), Status.BORROWABLE, createRandomPrice()));

        books.add(new Fiction(createRandomISBN(), "The Last Letter", kemalTahir, createRandomEdition(), Status.IN_PREPARATION_STAGE, createRandomPrice()));

        return books;
    }






    public static void main(String[] args) {
        // Initialize the authors and books
        // Print all authors
        System.out.println("Authors in the Library: " + getAuthors().size());

        for (Person author : getAuthors()) {
            System.out.println("- " + author.getFullName());
        }

        System.out.println("\nBooks in the Library: " + getBooks().size());
        List<Book> books = getBooks();

        // Print some book details with their status
        for (Book book : books) {
            System.out.println("Book Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor().getFullName());
            System.out.println("Edition: " + book.getEdition());
            System.out.println("Status: " + book.getBookStatus());
            System.out.println("Price: $" + String.format("%.2f", book.getPrice()));
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("------------------------------------------------");
        }
    }

}
