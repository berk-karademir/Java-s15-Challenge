package main.library;

import main.library.books.Book;
import main.library.shareholders.Author;
import main.library.shareholders.Librarian;
import main.library.shareholders.Person;
import main.library.shareholders.Reader;

import java.util.List;

public class Main {

    static void br() {
        System.out.println();
    }

    static void lines(){
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        br();
        lines();
        List<Person> authorsList = Library.getAuthors();
        List<Book> bookList = Library.getAllBooks();

        char[] password = {'1', '2', '3', '4', '5', '6'};
        Person librarian = new Librarian("Kütüphaneci Berk", password);
        System.out.println("Librarian' toString():\n" + librarian);
        System.out.println("Librarian's whoAreYou():");
        librarian.whoAreYou();
        lines();




        Person reader = new Reader("Okuyucu Berk", bookList);
        System.out.println("Reader's toString():\n" + reader);
        System.out.println("Reader's whoAreYou():");
        reader.whoAreYou();
        lines();


        Person author = new Author("Yazar Berk");
        System.out.println("Author's toString():\n" + author);
        System.out.println("Author's whoAreYou():");
        author.whoAreYou();
        lines();

//        List<Book> secondListOfBooks = new ArrayList<>();
//        Person dostoevsky = new Author("Dostoevsky");
//        Book book = new Classic(123123L,"Crime and Punishment",dostoevsky, 67, Status.BORROWABLE,14.90);
//        secondListOfBooks.add(book);
//        Person reader2 = new Reader("Klasik sever okur",secondListOfBooks);
//        System.out.println(reader2);
        br();
        System.out.println("Printing each book with loop: ");
        for (Book book : bookList) {
            System.out.println(book);
        }

        br();

        System.out.println("Yazar listesi: " + authorsList);
        br();


//        JFrame frame = new JFrame("Password Field Example");
//        JPasswordField passwordField = new JPasswordField();
//        JLabel label = new JLabel("Şifre:");
//        JButton button = new JButton("Gönder");
//
//        button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                char[] password = passwordField.getPassword();
//                String passwordString = new String(password);
//                JOptionPane.showMessageDialog(frame, "Girilen Şifre: " + passwordString);
//            }
//        });
//
//        JPanel panel = new JPanel();
//        panel.add(label);
//        panel.add(passwordField);
//        panel.add(button);
//
//        frame.add(panel);
//        frame.setSize(300, 100);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
    }
}
