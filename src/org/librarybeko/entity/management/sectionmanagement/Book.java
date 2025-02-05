package org.librarybeko.entity.management.sectionmanagement;

import org.librarybeko.entity.management.pr.Author;
import org.librarybeko.entity.management.pr.Reader;
import org.librarybeko.entity.management.enums.CategoryType;
import org.librarybeko.entity.management.enums.StatusType;

import java.util.Objects;


public abstract class Book {

    private static Long idCounter = 0L;
    private Long bookId;
    private Long ISBN;
    private CategoryType categoryType;
    private String title;
    private Author author;
    private Integer edition;
    private StatusType bookStatusType;
    private Double price;
    private int stock;


    public Book(Long ISBN, String title, Author author, Integer edition, Double price) {
        this.bookId = ++idCounter;
        setISBN(ISBN);
        setTitle(title);
        this.author = author;
        this.edition = edition;
        this.bookStatusType = StatusType.AVAILABLE;
        this.price = price;
        this.stock = 1;
        Inventory.bookList.add(this);
        if (author != null) {
            author.addNewBook(this);
        }
    }



    public static Long getIdCounter() {
        return idCounter;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getISBN() {
        return ISBN;
    }

    public CategoryType getCategory() {
        return categoryType;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {

        if(this.stock < 0) {
            System.out.println("ERROR...Stock can not be lower than 0!");
            return;
        }
        this.stock = stock;
    }

    public Integer getEdition() {
        return edition;
    }

    public StatusType getBookStatus() {
        return bookStatusType;
    }

    public Double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }




    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Book name cannot be null or empty!");
        }

        // Kitap ismi sayı içerebilir bu koşulu eklemek mantıklı değil!
//        if (!title.matches("[a-zA-Z\\s]+")) {
//            throw new IllegalArgumentException(getClass().getSimpleName() + " name must not contain numbers or special characters");
//        }


        /* eğer aynı kitabın birden fazla olmamasını kontrol etmek isteseydik
            if(this.getTitle().equals(title)) {
                System.out.println(getTitle() + " already has been added with the same title before.");
            }
        */
        this.title = title;
    }

    public void setISBN(Long ISBN) {

        if (ISBN == null) {
            throw new IllegalArgumentException("ISBN cannot be null.");

        }

        this.ISBN = ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
        if (author != null) {
            // Add the book to the new author's list
            author.addNewBook(this);
        }
    }

    public void changeOwner(Reader reader) {

    }

    public void getOwner(Reader reader) {
    }


    public void setCategory(CategoryType categoryType) {this.categoryType = categoryType;}
    public void display() {
        System.out.println(this);
    }


    public void setBookStatus(StatusType bookStatusType) {

        this.bookStatusType = bookStatusType;
    }

    public void updateStatus(StatusType statusType) {
        setBookStatus(statusType);
    }


    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Book book)) return false;
        return Objects.equals(bookId, book.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bookId);
    }

    @Override
    public String toString() {
        return "\nBook's: \n" +
                "ID: " + bookId + "\n" +
                "ISBN: " + ISBN + "\n" +
                "Category: " + categoryType + "\n" +
                "Title: " + title  +
                 author + "\n" +
                "Edition: " + edition + "\n" +
                "Price: $" + price + "\n" +
                stock + " in the library stock" + "\n" +
                "Status: " + bookStatusType +
                "\n";
    }

}
