package org.librarybeko;

import org.librarybeko.entity.management.enums.EmployeeType;
import org.librarybeko.entity.management.enums.MemberType;
import org.librarybeko.entity.management.hr.Employee;
import org.librarybeko.entity.management.hr.Librarian;
import org.librarybeko.entity.management.hr.Manager;
import org.librarybeko.entity.management.pr.*;
import org.librarybeko.entity.management.sectionmanagement.Book;
import org.librarybeko.entity.management.sectionmanagement.Fiction;
import org.librarybeko.entity.management.sectionmanagement.Inventory;
import org.librarybeko.entity.management.sectionmanagement.Library;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InfoDesk {

    public static void br() {
        System.out.println("----------------------------------------------------------------");
    }


    static Library library = Library.getInstance();
    static Manager manager = Manager.getInstance();
    static List<Author> allAuthors = Inventory.authorList;
    static List<Book> allBooks = Inventory.bookList;
    static Map<Long, Member> allReaders = library.getReaders();
    private static Librarian librarian = null;

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        while (true) {
            System.out.println();
            System.out.println("✦✦✦✦✦ WELCOME to " + library.getBrandName().toUpperCase() + " ✦✦✦✦✦");
            System.out.println("Select the operation you want to perform from the operation menu below.");
            System.out.println("Enter a number for operations, or 0 to exit.\n" +
                    "- 1 for staff operations,\n" +
                    "- 2 for member operations.\n");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Exiting... Goodbye!");
                break;
            } else if (choice == 1) {
                staffLogin();
            } else if (choice == 2) {
                memberMenu();
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void staffLogin() {
        while (true) {
            System.out.println("\nStaff Login:");
            System.out.println("1- Manager login");
            System.out.println("2- Librarian login");
            System.out.println("9- Back");
            System.out.println("0- Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (managerLogin()) {
                        managerMenu();
                    }
                    break;
                case 2:
                    if (librarianLogin()) {
                        librarianMenu();
                    }
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

    private static boolean managerLogin() {
        System.out.print("Enter Manager username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Manager password: ");
        String password = scanner.nextLine();

        if (username.equals("osm123") && password.equals("osm123")) {
            System.out.println("Login successful. Role: Manager, welcome " + manager.getFullName() + "!");
            return true;
        } else {
            System.out.println("Incorrect username or password. Try again.");
            return false;
        }
    }


    private static boolean librarianLogin() {
        if (librarian == null) {
            System.out.println("No librarian exists yet. Please contact your manager.");
            return false;
        }

        System.out.print("Enter Librarian username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Librarian password: ");
        String password = scanner.nextLine();

        if (username.equals(librarian.getUserName()) && password.equals(librarian.getPassword())) {
            System.out.println("Login successful. Role: Librarian, welcome " + librarian.getFullName() + "!");
            return true;
        } else {
            System.out.println("Incorrect username or password. Try again.");
            return false;
        }
    }

    private static void managerMenu() {
        while (true) {
            System.out.println("\nManager Menu:");
            System.out.println("1- Hire new librarian");
            System.out.println("9- Back");
            System.out.println("0- Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    hireLibrarian();
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

    private static void hireLibrarian() {
        System.out.print("Enter Librarian full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter Librarian username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Librarian password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Librarian email: ");
        String email = scanner.nextLine();

        librarian = manager.hireNewLibrarian(fullName, username, password, email);

        System.out.println("Operation successful!");
        System.out.println("Login credentials: username: " + username + ", password: " + password);
    }


    private static void librarianMenu() {
        while (true) {
            System.out.println("\nLibrarian Menu:");
            System.out.println("1- Search book");
            System.out.println("2- Search author");
            System.out.println("3- Add a new book to inventory");
            System.out.println("4- Print an invoice");
            System.out.println("9- Previous menu");
            System.out.println("0- Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    searchBookMenu();
                    break;
                case 2:
                    searchAuthorMenu();
                    break;
                case 3:
                    addNewBookMenu();
                    break;
                case 4:
                    printInvoiceMenu();
                    break;
                case 9:
                    System.out.println("Going back to previous menu...");
                    return;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void searchBookMenu() {
        System.out.print("Enter search keyword (title, author, or category): ");
        String queryKeyword = scanner.nextLine();
        librarian.searchBook(queryKeyword);
    }

    private static void searchAuthorMenu() {
        System.out.print("Enter author's name to search: ");
        String authorName = scanner.nextLine();
        // Assuming you have a method to search by author name in Librarian class
        librarian.searchBook(authorName); // You might need to implement this method
    }

    private static void addNewBookMenu() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author's full name: ");
        String authorName = scanner.nextLine();
        System.out.print("Enter edition: ");
        int edition = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Assuming you have a method to find or create an author
        Author author = findOrCreateAuthor(authorName);

        // Create a new book instance
        Book newBook = new Fiction(Inventory.generateRandomISBN(), title, author, edition, price);
        librarian.addNewBook(newBook);
        System.out.println("New book added to inventory: " + newBook);
    }

    private static Author findOrCreateAuthor(String authorName) {
        for (Author author : Inventory.authorList) {
            if (author.getFullName().equalsIgnoreCase(authorName)) {
                return author;
            }
        }
        // If author not found, create a new one
        Author newAuthor = new Author(authorName);
        Inventory.addAuthor(newAuthor);
        return newAuthor;
    }

    private static void printInvoiceMenu() {
        System.out.print("Enter member ID to print invoice: ");
        long memberId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Reader member = library.getReaders().get(memberId);
        if (member != null) {
            librarian.createBill((Member) member);
        } else {
            System.out.println("Member with ID " + memberId + " not found.");
        }
    }

    private static void memberMenu() {
        while (true) {
            System.out.println("\nMember Operations:");
            System.out.println("1- Member Login");
            System.out.println("2- Member Registration");
            System.out.println("9- Previous Menu");
            System.out.println("0- Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    memberLogin();
                    break;
                case 2:
                    memberRegistration();
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



    private static void memberRegistration() {
        System.out.println("\nMember Registration:");
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        Long phoneNumber = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        System.out.println("Select your member type:");
        System.out.println("1- Faculty");
        System.out.println("2- Student");
        System.out.println("3- Casual");
        int memberTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Member newMember;
        switch (memberTypeChoice) {
            case 1:
                newMember = new Faculty(fullName, address, phoneNumber, username, password);
                break;
            case 2:
                newMember = new Student(fullName, address, phoneNumber, username, password);
                break;
            case 3:
                newMember = new Casual(fullName, address, phoneNumber, username, password);
                break;
            default:
                System.out.println("Invalid choice. Registration cancelled.");
                return;
        }

        // Add the new member to the library
        library.getReaders().put(newMember.getId(), newMember);
        System.out.println("Registration successful! Welcome, " + newMember.getFullName() + ".");
        System.out.println("You can log in by entering 1 now.");
    }


    private static void memberLogin() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check if the member exists in the library
        for (Map.Entry<Long, Member> entry : library.getReaders().entrySet()) {
            Member member = entry.getValue();
            if (member.getUsername().equals(username) && member.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + member.getFullName() + ".");
                System.out.println("You can log in with your credentials:");
                System.out.println(member);
                memberOperations(member); // Member operations menu
                return;
            }
        }

        System.out.println("Invalid username or password. Please try again or register.");
    }




    private static void memberOperations(Member member) {
        while (true) {
            System.out.println("\nMember Menu:");
            System.out.println("1- Search book");
            System.out.println("2- Search author");
            System.out.println("3- See all books in inventory");
            System.out.println("4- See all authors whose books are in our inventory");
            System.out.println("5- Purchase a book");
            System.out.println("6- Borrow a book");
            System.out.println("7- Deposit balance");
            System.out.println("8- Log out");
            System.out.println("9- Previous page");
            System.out.println("10- Increase max book limit");
            System.out.println("11- Decrease max book limit");
            System.out.println("12- Show books on me");
            System.out.println("13- See my profile");
            System.out.println("14- See my balance");
            System.out.println("15- Refund a book");
            System.out.println("0- Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    searchBookMenu(member);
                    break;
                case 2:
                    searchAuthorMenu(member);
                    break;
                case 3:
                    seeAllBooks();
                    break;
                case 4:
                    seeAllAuthors();
                    break;
                case 5:
                    purchaseBookMenu(member);
                    break;
                case 6:
                    borrowBookMenu(member);
                    break;
                case 7:
                    depositBalanceMenu(member);
                    break;
                case 8:
                    System.out.println("Logging out...");
                    return;
                case 9:
                    System.out.println("Going back to previous page...");
                    return;
                case 10:
                    increaseMaxBookLimitMenu(member);
                    break;
                case 11:
                    decreaseMaxBookLimitMenu(member);
                    break;
                case 12:
                    member.showBook();
                    break;
                case 13:
                    System.out.println(member);
                    break;
                case 14:
                    System.out.println("Your current balance is: $" + member.getAccountBalance());
                    break;
                case 15:
                    refundBookMenu(member);
                    break;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }


    private static void searchBookMenu(Member member) {
        System.out.print("Enter search keyword (title, author, or category): ");
        String queryKeyword = scanner.nextLine();
        librarian.searchBook(queryKeyword);
    }

    private static void searchAuthorMenu(Member member) {
        System.out.print("Enter author's name to search: ");
        String authorName = scanner.nextLine();
        librarian.searchBook(authorName); // Yazar adına göre kitap arama
    }

    private static void seeAllBooks() {
        System.out.println("All books in inventory:");
        for (Book book : Inventory.bookList) {
            System.out.println(book);
        }
    }

    private static void seeAllAuthors() {
        System.out.println("All authors whose books are in our inventory:");
        for (Author author : Inventory.authorList) {
            System.out.println(author);
        }
    }

    private static void purchaseBookMenu(Member member) {
        System.out.print("Enter the book ID you want to purchase: ");
        Long bookId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Book bookToPurchase = findBookById(bookId);
        if (bookToPurchase != null) {
            member.purchaseBook(bookToPurchase);
        } else {
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }

    private static Book findBookById(Long bookId) {
        for (Book book : Inventory.bookList) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    private static void borrowBookMenu(Member member) {
        System.out.print("Enter the book ID you want to borrow: ");
        Long bookId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Book bookToBorrow = findBookById(bookId);
        if (bookToBorrow != null) {
            member.borrowBook(bookToBorrow);
        } else {
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }

    private static void depositBalanceMenu(Member member) {
        System.out.print("Enter the amount to deposit: $");
        Double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        member.depositCash(amount);
    }


    private static void increaseMaxBookLimitMenu(Member member) {
        System.out.print("Enter the number of books to increase the limit by: ");
        Integer maxBooksCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        member.increaseMaxBooksIssued(maxBooksCount);
    }

    private static void decreaseMaxBookLimitMenu(Member member) {
        System.out.print("Enter the number of books to decrease the limit by: ");
        Integer maxBooksCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        member.decreaseMaxBooksIssued(maxBooksCount);
    }

    private static void refundBookMenu(Member member) {
        System.out.print("Enter the book ID you want to refund: ");
        Long bookId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Book bookToRefund = findBookById(bookId);
        if (bookToRefund != null) {
            member.returnBook(bookToRefund);
        } else {
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }

}
