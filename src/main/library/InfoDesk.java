package main.library;

import main.library.books.Book;
import main.library.books.subGenres.Mystery;
import main.library.management.Inventory;
import main.library.management.Library;
import main.library.shareholders.Author;
import main.library.shareholders.Person;

import java.util.List;
import java.util.Scanner;

public class InfoDesk {

    public static void br() {
        System.out.println("----------------------------------------------------------------");
    }


    static Library library = Library.getInstance();
    static List<Author> allAuthors = Inventory.authorList;
    static  List<Book> allBooks = Inventory.bookList;

    private static final Scanner scanner = new Scanner(System.in);
    private static final String LIBRARIAN_USERNAME = "librarian";
    private static final String MEMBER_USERNAME = "member";
    private static final String PASSWORD = "123";


    public static void main(String[] args) {


        while (true) {
            System.out.println("Welcome to our library");
            System.out.println("Select the operation you want to perform from the operation menu below.");
            System.out.println("Enter a number for operations, or 0 to exit.\n" +
                    "- 1 for librarian operations,\n" +
                    "- 2 for member operations,\n");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Exiting... Goodbye!");
                break;
            } else if (choice == 1) {
                if (login(LIBRARIAN_USERNAME)) {
                    librarianMenu();
                }
            } else if (choice == 2) {
                if (login(MEMBER_USERNAME)) {
                    memberMenu();
                }
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static boolean login(String userType) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (!username.equals(userType)) {
            System.out.println("Invalid username. Try again.");
            return false;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (password.equals(PASSWORD)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid password. Try again.");
            return false;
        }
    }

    private static void librarianMenu() {
        while (true) {
            System.out.println("\nLibrarian Menu:");
            System.out.println("1- Search book");
            System.out.println("2- Search author");
            System.out.println("3- Add a new book to inventory");
            System.out.println("9- Previous menu");
            System.out.println("0- Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Searching book...");
                    break;
                case 2:
                    System.out.println("Searching author...");
                    break;
                case 3:
                    System.out.println("Adding new book to inventory...");
                    break;
                case 9:
                    return;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void memberMenu() {
        while (true) {
            System.out.println("\nMember Menu:");
            System.out.println("1- Search book");
            System.out.println("2- Search author");
            System.out.println("3- See all books in inventory");
            System.out.println("4- See all authors whose books are in our inventory");
            System.out.println("5- Purchase a book");
            System.out.println("6- Borrow a book");
            System.out.println("9- Previous menu");
            System.out.println("0- Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Searching book...");
                    break;
                case 2:
                    System.out.println("Searching author...");
                    break;
                case 3:
                    System.out.println("Displaying all books...");
                    break;
                case 4:
                    System.out.println("Displaying all authors...");
                    break;
                case 5:
                    System.out.println("Purchasing a book...");
                    break;
                case 6:
                    System.out.println("Borrowing a book...");
                    break;
                case 9:
                    return;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
