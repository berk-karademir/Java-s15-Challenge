package main.library.shareholders;

import main.library.books.Book;
import main.library.management.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Librarian extends Person {

    private static Long idCounter = 100L;
    private Long id;
    private char[] password; // Şifreyi char[] olarak sakla
    private List<Book> listByCategory;
    private List<Book> listByTitle;
    private List<Book> listByAuthor;

    public Librarian(String name) {
        super(name);
        this.id = ++idCounter;
    }


    public char[] getPassword() {
        return password;
    }

    public void clearPassword() {
        if (password != null) {
            for (int i = 0; i < password.length; i++) {
                password[i] = 0; // Bellekteki şifreyi sıfırla
            }
        }
    }
    /*Eğer bu yaklaşım projenizin ihtiyaçlarını karşılıyorsa, kullanabilirsiniz. Ancak, büyük ölçekli projelerde farklı method isimleri kullanmak veya enum ile arama türünü belirtmek daha uygun olabilir. */

    //flag var. kullanılmıştır
    public void searchBook(String queryKeyword) {
        List<Book> listByCategory = new ArrayList<>();
        List<Book> listByTitle = new ArrayList<>();
        List<Book> listByAuthor = new ArrayList<>();

        if (queryKeyword == null || queryKeyword.isBlank()) {
            System.out.println("Search expression can not be null or empty!");
            return;
        }

        System.out.println("Searching with '" + queryKeyword.trim() + "' in library inventory.");
        queryKeyword = queryKeyword.trim().toLowerCase(Locale.ENGLISH);

        // Kitapları tarayarak uygun listelere ekleyelim
        for (Book book : Inventory.bookList) {
            if (book.getTitle().toLowerCase(Locale.ENGLISH).contains(queryKeyword)) {
                listByTitle.add(book);
            }

            if (book.getCategory().toString().toLowerCase(Locale.ENGLISH).contains(queryKeyword)) {
                listByCategory.add(book);
            }

            if (book.getAuthor().getFullName().toLowerCase(Locale.ENGLISH).contains(queryKeyword)) {
                listByAuthor.add(book);
            }
        }

        // Başlık bazlı arama sonuçları
        if (!listByTitle.isEmpty()) {
            System.out.println((listByTitle.size() == 1 ? "A book" : listByTitle.size() + " books") +
                    " found with '" + queryKeyword + "' in the title:");
            for (Book book : listByTitle) {
                System.out.println(book);
            }
        }

        // Kategori bazlı arama sonuçları
        if (!listByCategory.isEmpty()) {
            System.out.println((listByCategory.size() == 1 ? "A book" : listByCategory.size() + " books") +
                    " found under '" + queryKeyword + "' category:");
            for (Book book : listByCategory) {
                System.out.println(book);
            }
        }

        // Yazar bazlı arama sonuçları
        if (!listByAuthor.isEmpty()) {
            System.out.println((listByAuthor.size() == 1 ? "A book" : listByAuthor.size() + " books") +
                    " found written by an author with '" + queryKeyword + "' in their name:");
            for (Book book : listByAuthor) {
                System.out.println(book);
            }
        }

        // Hiçbir sonuç bulunamazsa
        if (listByTitle.isEmpty() && listByCategory.isEmpty() && listByAuthor.isEmpty()) {
            System.out.println("Can not find any books or authors with '" + queryKeyword + "'");
        }
    }



/*
    // by instance itself
    public void searchBookByInstance(Book book) {
        if (Inventory.bookList.contains(book)) {
            System.out.println("We have this book in our inventory:");
            System.out.println(book);
        } else {
            System.out.println("Can not find this book in our inventory.");
        }
    }

    //by book title
    public void searchBookByTitle(String bookTitle) {
        for (Book book : Inventory.bookList) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                System.out.println("'" + book.getTitle() + "' has been found in our library: ");
                System.out.println(book);
                return;
            }
        }
        System.out.println("Can not find this book in our inventory with the given title '" + bookTitle + "'.");
    }

    //by author instance
    public void searchBookByAuthorInstance(Author author) {
        for (Book book : Inventory.bookList) {
            if (book.getAuthor().equals(author)) {
                System.out.println((author.getBooks().size() == 1 ? "A book" : author.getBooks().size() + " books") + " found in our inventory written by " + author.getFullName() + ".");
                System.out.println(author.getBooks().size() > 1 ? "Books:" : "Book:");
                System.out.println(author.getBooks());
                return;
            }
        }
        System.out.println("Can not find any books in our inventory written by " + author.getFullName() + ".");
    }

    public void searchBookByAuthorName(String authorName) {
        for (Author author : Inventory.authorList) {
            if (author.getFullName().equalsIgnoreCase(authorName)) {
                System.out.println((author.getBooks().size() == 1 ? "A book" : author.getBooks().size() + " books") + " found in our inventory written by " + author.getFullName() + ".");
                author.showBook();
                return;
            }
        }
        System.out.println("Can not find any books in our inventory written by " + authorName + ".");
    }
*/

    public void verifyMember() {
    }

    public void issueBook() {
    }

    public void calculateFine() {
    }

    public void createBill() {
    }

    public void returnBook() {
    }

    public void whoAreYou() {
        System.out.println("I'm a " + getClass().getSimpleName() + ", my name is " + getFullName() + ", my ID is " + id + ".");
    }


    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Librarian librarian)) return false;
        return Objects.equals(id, librarian.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    @Override
    public String toString() {
        return super.toString() + ", ID: " + id + ".\n";
    }
}