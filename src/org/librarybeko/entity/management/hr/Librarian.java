package org.librarybeko.entity.management.hr;

import org.librarybeko.entity.management.pr.Member;
import org.librarybeko.entity.management.sectionmanagement.Book;
import org.librarybeko.entity.management.sectionmanagement.Inventory;


import java.util.*;

public class Librarian extends Employee {



    private List<Book> listByCategory;
    private List<Book> listByTitle;
    private List<Book> listByAuthor;
    private Integer uniqueInvoiceNumber = 0;

    public Librarian(String fullName) {
        super(fullName);
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

    //Search book by id
    public void searchBook(Long bookId) {
        boolean found = false;

        for (Book book : Inventory.bookList) {
            if (book.getBookId().equals(bookId)) {
                System.out.println("The book with id " + book.getBookId() + " has been found in inventory:");
                System.out.println(book);
                found = true;
                break; // Kitap bulunduğunda döngüden çık
            }
        }

        if (!found) {
            System.out.println("The book with id " + bookId + " cannot be found in inventory.");
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

    public void addNewBook(Book book){
        if(!book.getAuthor().equals(this)) {
            System.out.println("Eklemeye çalıştığın kitabın yazarı başka bir yazar!");
        } else if (Inventory.getBookList().contains(book)) {
            System.out.println("Bu yazarın bu kitabı zaten kütüphane envanterinde mevcut, yeni kitap kaydı yerine stok 1 arttırıldı!");
            book.setStock(book.getStock()+1);

        }
        Inventory.getBookList().add(book);
    };

    public void verifyMember() {
    }

    public void issueBook() {
    }

    public void calculateFine() {
    }

    public void createBill(Member member) {
        List<Book> memberBooks = member.getBooks();
        if(memberBooks == null || memberBooks.isEmpty()) {
            System.out.println("Member " + member.getFullName() + ", currently has not any books.");
            return;
        }

        System.out.println("Your invoice is getting printed... Please wait...");
        if(memberBooks.size() == 1) {
            System.out.println("Member " + member.getFullName() + ", currently has a book, your invoice has been created: ");

        } else if (memberBooks.size() > 2) {
            System.out.println("Member " + member.getFullName() + ", currently has "+ memberBooks.size() +  "a books, Your invoice has been created: ");

        }
        uniqueInvoiceNumber++;
        System.out.println("Bill details:");
        System.out.println("Invoice number: " + this.getId().toString() + "00000" + uniqueInvoiceNumber);
        for(Book book : memberBooks) {
            System.out.println(book.getTitle() + " by " + book.getAuthor().getFullName() + " - $" + book.getPrice()
            );
            System.out.println("Enjoy your book, have good day :)");
        }
    }

    public void returnBook(Book book,Member member) {
        member.returnBook(book);
    }

    public void whoAreYou() {
        System.out.println("I'm a " + getClass().getSimpleName() + ", my name is " + getFullName() + ", my ID is " + getId() + ".");
    }



    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Librarian librarian)) return false;
        return Objects.equals(getId(), librarian.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }


    @Override
    public String toString() {
        return super.toString();
    }
}