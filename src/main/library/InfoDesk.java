package main.library;

import main.library.books.Book;
import main.library.books.subGenres.Mystery;
import main.library.management.Inventory;
import main.library.shareholders.Author;
import main.library.shareholders.Person;

import java.util.List;

public class InfoDesk {

    public static void br() {
        System.out.println("----------------------------------------------------------------");
    }


    static List<Author> allAuthors = Inventory.authorList;
    static  List<Book> allBooks = Inventory.bookList;
//    static String password = "123";
//    static String librarianUserName = "librarian";
//    static String memberUserName = "member";
//    static String managerUserName = "manager";

    public static void main(String[] args) {
        System.out.println();

        Author author = new Author("YAZAR");
        Book book = new Mystery(1L,"KITAP",author,1,12.90);
        System.out.println(allAuthors);
        System.out.println(allBooks);
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
//            int choice;
//            if (scanner.hasNextInt()) {
//                choice = scanner.nextInt();
//                scanner.nextLine();
//            } else {
//                System.out.println("Invalid input. Please enter a number.");
//                scanner.nextLine();
//                continue;
//            }
//
//            switch (choice) {
//                case 0:
//                    System.out.println("Exiting the program. Goodbye!");
//                    return;
//                case 1:
//                    scanner.nextLine();
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

       // scanner.close();
    }
}
