package main.library.management;

import main.library.books.Book;
import main.library.books.subGenres.*;
import main.library.shareholders.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Inventory {

    public static Author agathaChristie, jkRowling, georgeOrwell, ernestHemingway, markTwain,
            charlesDickens, leoTolstoy, fyodorDostoevsky, franzKafka, williamShakespeare,
            victorHugo, miguelDeCervantes, johannWolfgangVonGoethe, jamesJoyce, hermanMelville,
            edgarAllanPoe, albertCamus, jeanPaulSartre, khaledHosseini, isabelAllende, umbertoEco,
            pauloCoelho, johnSteinbeck, orhanPamuk, yasarKemal, nazimHikmet, orhanVeli, ahmetHamdiTanpinar,
            sabahattinAli, elifSafak, halideEdipAdivar, attilaIlhan, azizNesin, peyamiSafa,
            tarıkBugra, resatNuriGuntekin, oguzAtay, cahitSitkiTaranci, saitFaikAbasiyanik,
            haldunTaner, zülfüLivaneli, latifeTekin, kemalTahir;

    public static List<Author> authorList = new ArrayList<>();

    public static void addAuthor(Author author) {
        authorList.add(author);
    }

    public static List<Author> getAuthorsList() {
        return authorList;
    }

    static {
        agathaChristie = new Author("Agatha Christie");
//        authorList.add(agathaChristie);
        jkRowling = new Author("J.K. Rowling");
//        authorList.add(jkRowling);
        georgeOrwell = new Author("George Orwell");
//        authorList.add(georgeOrwell);
        ernestHemingway = new Author("Ernest Hemingway");
//        authorList.add(ernestHemingway);
        markTwain = new Author("Mark Twain");
//        authorList.add(markTwain);
        charlesDickens = new Author("Charles Dickens");
//        authorList.add(charlesDickens);
        leoTolstoy = new Author("Leo Tolstoy");
//        authorList.add(leoTolstoy);
        fyodorDostoevsky = new Author("Fyodor Dostoevsky");
//        authorList.add(fyodorDostoevsky);
        franzKafka = new Author("Franz Kafka");
//        authorList.add(franzKafka);
        williamShakespeare = new Author("William Shakespeare");
//        authorList.add(williamShakespeare);
        victorHugo = new Author("Victor Hugo");
//        authorList.add(victorHugo);
        miguelDeCervantes = new Author("Miguel de Cervantes");
//        authorList.add(miguelDeCervantes);
        johannWolfgangVonGoethe = new Author("Johann Wolfgang von Goethe");
//        authorList.add(johannWolfgangVonGoethe);
        jamesJoyce = new Author("James Joyce");
//        authorList.add(jamesJoyce);
        hermanMelville = new Author("Herman Melville");
//        authorList.add(hermanMelville);
        edgarAllanPoe = new Author("Edgar Allan Poe");
//        authorList.add(edgarAllanPoe);
        albertCamus = new Author("Albert Camus");
//        authorList.add(albertCamus);
        jeanPaulSartre = new Author("Jean-Paul Sartre");
//        authorList.add(jeanPaulSartre);
        khaledHosseini = new Author("Khaled Hosseini");
//        authorList.add(khaledHosseini);
        isabelAllende = new Author("Isabel Allende");
//        authorList.add(isabelAllende);
        umbertoEco = new Author("Umberto Eco");
//        authorList.add(umbertoEco);
        pauloCoelho = new Author("Paulo Coelho");
//        authorList.add(pauloCoelho);
        johnSteinbeck = new Author("John Steinbeck");
//        authorList.add(johnSteinbeck);
        orhanPamuk = new Author("Orhan Pamuk");
//        authorList.add(orhanPamuk);
        yasarKemal = new Author("Yaşar Kemal");
//        authorList.add(yasarKemal);
        nazimHikmet = new Author("Nazım Hikmet");
//        authorList.add(nazimHikmet);
        orhanVeli = new Author("Orhan Veli");
//        authorList.add(orhanVeli);
        ahmetHamdiTanpinar = new Author("Ahmet Hamdi Tanpınar");
//        authorList.add(ahmetHamdiTanpinar);
        sabahattinAli = new Author("Sabahattin Ali");
//        authorList.add(sabahattinAli);
        elifSafak = new Author("Elif Şafak");
//        authorList.add(elifSafak);
        halideEdipAdivar = new Author("Halide Edip Adıvar");
//        authorList.add(halideEdipAdivar);
        attilaIlhan = new Author("Attilâ İlhan");
//        authorList.add(attilaIlhan);
        azizNesin = new Author("Aziz Nesin");
//        authorList.add(azizNesin);
        peyamiSafa = new Author("Peyami Safa");
//        authorList.add(peyamiSafa);
        tarıkBugra = new Author("Tarık Buğra");
//        authorList.add(tarıkBugra);
        resatNuriGuntekin = new Author("Reşat Nuri Güntekin");
//        authorList.add(resatNuriGuntekin);
        oguzAtay = new Author("Oğuz Atay");
//        authorList.add(oguzAtay);
        cahitSitkiTaranci = new Author("Cahit Sıtkı Tarancı");
//        authorList.add(cahitSitkiTaranci);
        saitFaikAbasiyanik = new Author("Sait Faik Abasıyanık");
//        authorList.add(saitFaikAbasiyanik);
        haldunTaner = new Author("Haldun Taner");
//        authorList.add(haldunTaner);
        zülfüLivaneli = new Author("Zülfü Livaneli");
//        authorList.add(zülfüLivaneli);
        latifeTekin = new Author("Latife Tekin");
//        authorList.add(latifeTekin);
        kemalTahir = new Author("Kemal Tahir");
//        authorList.add(kemalTahir);
    }




    static Random random = new Random();

    public static List<Book> bookList = new ArrayList<>();


    public static Long generateRandomISBN() {
        return 1000000000000L + (long) (random.nextDouble() * 9000000000000L);
    }

    public static Integer generateRandomEdition() {
        return random.nextInt(20) + 1;
    }

    public static Double setRandomPrice() {
        return 4.90 + (random.nextDouble() * (100.00 - 4.90));
    }


    static {

        Book book = new Mystery(generateRandomISBN(), "Murder on the Orient Express", agathaChristie, generateRandomEdition(), setRandomPrice());
//        bookList.add(book);
//

        Book book2 = new Fantasy(generateRandomISBN(), "Harry Potter and the Philosopher's Stone", jkRowling, generateRandomEdition(), setRandomPrice());
//        bookList.add(book2);


        Book book3 = new Dystopian(generateRandomISBN(), "1984", georgeOrwell , generateRandomEdition(), setRandomPrice());
//        bookList.add(book3);


        Book book4 = new Fiction(generateRandomISBN(), "The Old Man and the Sea", ernestHemingway, generateRandomEdition(), setRandomPrice());
//        bookList.add(book4);


        Book book5 = new Classic(generateRandomISBN(), "The Adventures of Tom Sawyer", markTwain, generateRandomEdition(), setRandomPrice());
//        bookList.add(book5);


        Book book6 = new Classic(generateRandomISBN(), "A Tale of Two Cities", charlesDickens, generateRandomEdition(), setRandomPrice());
//        bookList.add(book6);


        Book book7 = new Classic(generateRandomISBN(), "War and Peace", leoTolstoy, generateRandomEdition(), setRandomPrice());
//        bookList.add(book7);


        Book book8 = new Classic(generateRandomISBN(), "Crime and Punishment", fyodorDostoevsky, generateRandomEdition(), setRandomPrice());
//        bookList.add(book8);


        Book book9 = new Classic(generateRandomISBN(), "The Metamorphosis", franzKafka, generateRandomEdition(), setRandomPrice());
//        bookList.add(book9);


        Book book10 = new Play(generateRandomISBN(), "Hamlet", williamShakespeare, generateRandomEdition(), setRandomPrice());
//        bookList.add(book10);


        Book book11 = new Classic(generateRandomISBN(), "Les Misérables", victorHugo, generateRandomEdition(), setRandomPrice());
//        bookList.add(book11);


        Book book12 = new Classic(generateRandomISBN(), "Don Quixote", miguelDeCervantes, generateRandomEdition(), setRandomPrice());
//        bookList.add(book12);


        Book book13 = new Classic(generateRandomISBN(), "Faust", johannWolfgangVonGoethe, generateRandomEdition(), setRandomPrice());
//        bookList.add(book13);


        Book book14 = new Classic(generateRandomISBN(), "Ulysses", jamesJoyce, generateRandomEdition(), setRandomPrice());
//        bookList.add(book14);


        Book book15 = new Classic(generateRandomISBN(), "Moby Dick", hermanMelville, generateRandomEdition(), setRandomPrice());
//        bookList.add(book15);


        Book book16 = new Classic(generateRandomISBN(), "The Raven", edgarAllanPoe, generateRandomEdition(), setRandomPrice());
//        bookList.add(book16);


        Book book17 = new Philosophy(generateRandomISBN(), "The Stranger", albertCamus, generateRandomEdition(), setRandomPrice());
//        bookList.add(book17);


        Book book18 = new Fiction(generateRandomISBN(), "Nausea", jeanPaulSartre, generateRandomEdition(), setRandomPrice());
//        bookList.add(book18);


        Book book19 = new Fiction(generateRandomISBN(), "The Kite Runner", khaledHosseini, generateRandomEdition(), setRandomPrice());
//        bookList.add(book19);


        Book book20 = new Fiction(generateRandomISBN(), "The House of the Spirits", isabelAllende, generateRandomEdition(), setRandomPrice());
//        bookList.add(book20);


        Book book21 = new Fiction(generateRandomISBN(), "The Name of the Rose", umbertoEco, generateRandomEdition(), setRandomPrice());
//        bookList.add(book21);


        Book book22 = new Fiction(generateRandomISBN(), "The Grapes of Wrath", johnSteinbeck, generateRandomEdition(), setRandomPrice());
//        bookList.add(book22);


        Book book23 = new Fiction(generateRandomISBN(), "My Name is Red", orhanPamuk, generateRandomEdition(), setRandomPrice());
//        bookList.add(book23);


        Book book24 = new Fiction(generateRandomISBN(), "Innocent", yasarKemal, generateRandomEdition(), setRandomPrice());
//        bookList.add(book24);


        Book book25 = new Fiction(generateRandomISBN(), "The Time Regulation Institute", nazimHikmet, generateRandomEdition(), setRandomPrice());
//        bookList.add(book25);


        Book book26 = new Fiction(generateRandomISBN(), "The Devil's Advocate", orhanVeli, generateRandomEdition(), setRandomPrice());
//        bookList.add(book26);


        Book book27 = new Fiction(generateRandomISBN(), "The Silent House", ahmetHamdiTanpinar, generateRandomEdition(), setRandomPrice());
//        bookList.add(book27);


        Book book28 = new Fiction(generateRandomISBN(), "The Last Train", sabahattinAli, generateRandomEdition(), setRandomPrice());
//        bookList.add(book28);


        Book book29 = new Fiction(generateRandomISBN(), "The Black Book",elifSafak, generateRandomEdition(), setRandomPrice());
//        bookList.add(book29);


        Book book30 = new Fiction(generateRandomISBN(), "The Museum of Innocence", halideEdipAdivar, generateRandomEdition(), setRandomPrice());
//        bookList.add(book30);


        Book book31 = new Fiction(generateRandomISBN(), "The Time of the Gypsies", attilaIlhan, generateRandomEdition(), setRandomPrice());
//        bookList.add(book31);


        Book book32 = new Fiction(generateRandomISBN(), "The Last Letter", azizNesin, generateRandomEdition(), setRandomPrice());
//        bookList.add(book32);


        Book book33 = new Fiction(generateRandomISBN(), "The Last Train to Istanbul", peyamiSafa, generateRandomEdition(), setRandomPrice());
//        bookList.add(book33);


        Book book34 = new Fiction(generateRandomISBN(), "The Bastard of Istanbul", tarıkBugra, generateRandomEdition(), setRandomPrice());
//        bookList.add(book34);


        Book book35 = new Fiction(generateRandomISBN(), "The Time Regulation Institute", resatNuriGuntekin, generateRandomEdition(), setRandomPrice());
//        bookList.add(book35);


        Book book36 = new Fiction(generateRandomISBN(), "The Book of Whispers", oguzAtay, generateRandomEdition(), setRandomPrice());
//        bookList.add(book36);


        Book book37 = new Fiction(generateRandomISBN(), "The Last Letter", cahitSitkiTaranci, generateRandomEdition(), setRandomPrice());
//        bookList.add(book37);


        Book book38 = new Fiction(generateRandomISBN(), "The Silent House", saitFaikAbasiyanik, generateRandomEdition(), setRandomPrice());
//        bookList.add(book38);


        Book book39 = new Fiction(generateRandomISBN(), "The Black Book", haldunTaner, generateRandomEdition(), setRandomPrice());
//        bookList.add(book39);


        Book book40 = new Fiction(generateRandomISBN(), "The Museum of Innocence", zülfüLivaneli, generateRandomEdition(), setRandomPrice());
//        bookList.add(book40);


        Book book41 = new Fiction(generateRandomISBN(), "The Time of the Gypsies", latifeTekin, generateRandomEdition(), setRandomPrice());
//        bookList.add(book41);


        Book book42 = new Fiction(generateRandomISBN(), "The Last Train", kemalTahir, generateRandomEdition(), setRandomPrice());
//        bookList.add(book42);


        Book book43 = new Fiction(generateRandomISBN(), "The Last Letter", kemalTahir, generateRandomEdition(), setRandomPrice());
//        bookList.add(book43);

    }

}
