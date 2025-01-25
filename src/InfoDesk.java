import org.library.books.*;
import org.library.shareholders.Author;
import org.library.shareholders.Person;
import org.library.shareholders.Reader;

public class InfoDesk {

    public static void br() {
        System.out.println("----------------------------------------------------------------");
    }

    public static void main(String[] args) {


        System.out.println("------- READER and AUTHOR --------");

        Person reader = new Reader("Berk");
        Person author = new Author("Ali");
        Person reader2 = new Reader("Berk");
        Person author2 = new Author("Ali");

        Person agatheCristie = new Author("Agathe Cristie");

        reader.whoAreYou();
        author.whoAreYou();
        reader2.whoAreYou();
        author2.whoAreYou();

        System.out.println(author.equals(author2)); //f
        System.out.println(reader.equals(reader2)); //f
        br();


        System.out.println("------- BOOK --------");
        Book magazine1 = new Magazine(123, Category.MAGAZINE, "TIMES",author2,1, Status.BORROWABLE,10.90);
        Book magazine2 = new Magazine(123, Category.MAGAZINE, "TIMES",author2,1, Status.BORROWABLE,10.90);
        Book magazine3 = new Magazine(500, Category.MAGAZINE, "TIMES",author2,1, Status.BORROWABLE,10.90);

        System.out.println(magazine1.equals(magazine2));
        magazine1.display();
        magazine2.display();
        magazine3.display();
        System.out.println(magazine1.getBookId());
        System.out.println(magazine2.getBookId());
        System.out.println(magazine3.getBookId());
        br();
        Book whodunit1 = new Whodunit(23456,Category.WHODUNIT,"Doğu Ekspressi'nde Cinayet", agatheCristie,1, Status.BORROWABLE,11.90);
        System.out.println(whodunit1);












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

    }
}