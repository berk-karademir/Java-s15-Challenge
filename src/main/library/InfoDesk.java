package main.library;

import main.library.books.Book;
import main.library.books.Status;
import main.library.books.subGenres.Classic;
import main.library.shareholders.Author;
import main.library.shareholders.Person;
import main.library.shareholders.Reader;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class InfoDesk {

    public static void br() {
        System.out.println("----------------------------------------------------------------");
    }

    static List<Book> allBooks = Library.getAllBooks();
    static List<Person> allAuthors = Library.getAuthors();


    public static void main(String[] args) {
        System.out.println();
        Library.azizNesin.showBook();
        br();
        Book book1 = new Classic(123L,"title",Library.agathaChristie,1, Status.IN_PREPARATION_STAGE,12.90);
        Reader reader = new Reader("Okur kişi");
        System.out.println(reader);
        reader.borrowBook(book1);
        System.out.println(reader);
//        Scanner scanner = new Scanner(System.in); // Scanner nesnesi oluştur
//
//        System.out.println("Welcome to our library!");
//        System.out.println("Select the operation you want to perform from the operation menu below.");
//
//        while (true) {
//            System.out.println("Enter 1 - 3 for operations, or 0 to exit.\n" +
//                    "- 1 for librarian operations,\n" +
//                    "- 2 for member operations,\n" +
//                    "- 3 for manager operations.");
//
//            // Kullanıcıdan giriş al
//            int getIntInput;
//            if (scanner.hasNextInt()) {
//                getIntInput = scanner.nextInt();
//                scanner.nextLine(); // Tamponu temizle
//            } else {
//                System.out.println("Invalid input. Please enter a number.");
//                scanner.nextLine(); // Geçersiz girdiyi temizle
//                continue;
//            }
//
//            if (getIntInput == 0) {
//                System.out.println("Exiting the program. Goodbye!");
//                break;
//            }
//
//            switch (getIntInput) {
//                case 0:
//                    System.out.println("sıfır");
//                    break;
//                case 1:
//                    System.out.println("bir");
//                    break;
//                case 2:
//                    System.out.println("iki");
//                    break;
//                case 3:
//                    System.out.println("üç");
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please enter a number between 0 and 5.");
//            }
//        }
//
//        scanner.close(); // Scanner'ı kapat
    }
}
