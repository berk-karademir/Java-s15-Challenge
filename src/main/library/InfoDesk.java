package main.library;

import main.library.books.Book;
import main.library.shareholders.Author;

import java.util.List;

public class InfoDesk {

    public static void br() {
        System.out.println("----------------------------------------------------------------");
    }

    public static void main(String[] args) {


        // Kitapları almak için getBooks metodunu kullanın
        List<Author> authors = SectionManagement.getAuthors();
        List<Book> books = SectionManagement.getBooks();


        System.out.println("All authors:" + authors);
        System.out.println("All books:" + books);

        // Örnek: Agatha Christie tarafından yazılan kitapları filtrelemek
        System.out.println("\nBooks by Agatha Christie:");
        for (Book book : books) {
            if (book.getAuthor().equals(SectionManagement.agathaChristie)) {
                System.out.println("- " + book.getTitle());
            }
        }

        System.out.println("\nBooks by Kemal Tahir:");
        for (Book book : books) {
            if (book.getAuthor().equals(SectionManagement.kemalTahir)) {
                System.out.println("- " + book.getTitle());
            }
        }
    }
}















//        JFrame frame = new JFrame("Kütüphaneye Hoşgeldiniz");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 300);
//        frame.setLayout(new BorderLayout());
//
//        // Başlık etiketi
//        JLabel welcomeLabel = new JLabel("Kütüphaneye Hoşgeldiniz!", SwingConstants.CENTER);
//        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        frame.add(welcomeLabel, BorderLayout.NORTH);
//
//        // Buton paneli
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setLayout(new FlowLayout());
//
//        // Login butonu
//        JButton loginButton = new JButton("Login");
//        loginButton.setPreferredSize(new Dimension(100, 40));
//        buttonPanel.add(loginButton);
//
//        // Signup butonu
//        JButton signupButton = new JButton("Signup");
//        signupButton.setPreferredSize(new Dimension(100, 40));
//        buttonPanel.add(signupButton);
//
//        frame.add(buttonPanel, BorderLayout.CENTER);
//
//        // Login butonuna tıklama olayı
//        loginButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(frame, "Login ekranına yönlendiriliyorsunuz.",
//                        "Login", JOptionPane.INFORMATION_MESSAGE);
//                // Burada login ekranını açabilirsiniz
//            }
//        });
//
//        // Signup butonuna tıklama olayı
//        signupButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(frame, "Signup ekranına yönlendiriliyorsunuz.",
//                        "Signup", JOptionPane.INFORMATION_MESSAGE);
//                // Burada signup ekranını açabilirsiniz
//            }
//        });
//
//        // Pencereyi görünür yap
//        frame.setLocationRelativeTo(null); // Ortala
//        frame.setVisible(true);
//    }

