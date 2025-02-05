package org.librarybeko.entity.management.pr;

import org.librarybeko.entity.management.hr.Librarian;
import org.librarybeko.entity.management.sectionmanagement.Book;
import org.librarybeko.entity.management.enums.MemberType;
import org.librarybeko.entity.management.enums.StatusType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Member extends Reader {

    private MemberType membertype;
    private String address;
    private Long phoneNumber;
    private String username;
    private String password;
    private String registrationDate;
    private Boolean noBooksIssued;
    private Integer maxBookLimit;
    private Double accountBalance;

    public Member(String fullName, MemberType membertype, String address, Long phoneNumber, String username, String password) {
        super(fullName);
        this.membertype = membertype;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.noBooksIssued = false;
        setRegistrationDate();
        setMaxBookLimit();
        this.accountBalance = 0.0;
    }



    public void setNoBooksIssued(Boolean noBooksIssued) {
        this.noBooksIssued = noBooksIssued;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        this.registrationDate = LocalDateTime.now().format(formatter);
    }

    public Integer getMaxBookLimit() {
        return maxBookLimit;
    }

    public Double getAccountBalance() {
        accountBalance = Math.round(accountBalance * 100.00) / 100.00;
        return accountBalance;
    }

    public void setMaxBookLimit() {
        switch (membertype) {
            case STUDENT:
                this.maxBookLimit = 10;
                break;
            case FACULTY:
                this.maxBookLimit = 50;
                break;
            case NORMAL:
                this.maxBookLimit = 5;
                break;
            default:
                this.maxBookLimit = 1;
                System.out.println("Max book limit set as 1 by default. Make you sure select a member type!");
        }
    }

    public void setMaxBookLimit(Integer maxBookLimit) {
        if(maxBookLimit <=5) {
            System.out.println("Maximum book limit can not be lower than 5.");
            return;
        } else if (maxBookLimit > 50) {
            System.out.println("Maximum book limit can not be higher than 50.");
            return;
        }
        this.maxBookLimit = maxBookLimit;
    }

    public void increaseMaxBooksIssued(Integer maxBooksCount) {
        if(accountBalance < 4.99 * maxBooksCount ) {
            System.out.println("You need to deposit balance first!");
            return;
        } else if (maxBookLimit >= 50) {
            System.out.println("You can borrow 50 books maximum");
            return;
        }
        this.accountBalance -=(maxBooksCount * 5);
        this.maxBookLimit += maxBooksCount;
        System.out.println("$" + (maxBooksCount*5) + " has been charged from your balance (5 dollars each).");
        System.out.println("Your max book limit is now: " + this.maxBookLimit);
    }

    public void decreaseMaxBooksIssued(Integer maxBooksCount) {


        if(this.maxBookLimit <=5) {
            System.out.println("Your max limit is already " + this.maxBookLimit + ". (No charge, you do not need to do that process).");
            return;
        }

        System.out.println("$" + (maxBooksCount * 5) + " has been refunded to your balance (5 dollars each).");
        this.accountBalance += maxBooksCount * 5;
        this.maxBookLimit -= maxBooksCount;
        System.out.println("Your max book limit is now: " + this.maxBookLimit);

    }

    private void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void depositCash(Double cashAmount) {
        setAccountBalance(cashAmount + this.accountBalance);
        System.out.println("Member " + this.getFullName() + " deposited + $" + cashAmount + ", current balance is: $" + this.getAccountBalance());
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void purchaseBook(Book book) {

        if (book.getStock() == 0) {
            System.out.println("Sorry... :(  '" + book.getTitle() + "' is out of stock for now, please check again later.");
            return;
        }
        if (accountBalance < book.getPrice()) {
            System.out.println("Sorry, not enough funds in your balance... You can deposit cash by entering 7.");
            return;
        }
        if(this.books.size() >= maxBookLimit) {
            System.out.println("Could not purchase the book.");
            System.out.println("You are on maximum book limit, you can increase it by entering 10, or refund a book.");
            return;
        }
            System.out.println(book.getTitle() + " -> Purchase fee: " + book.getPrice());
            this.accountBalance -= book.getPrice();
            this.books.add(book);
            book.setStock(book.getStock() - 1);
            System.out.println(book.getTitle() + " by " + book.getAuthor().getFullName() +" has been bought by " + this.getFullName() + ".");
            if(book.getStock() == 0) {
            book.setBookStatus(StatusType.OUT_OF_STOCK);
            setNoBooksIssued(false);
        }
    }

    @Override
    public void borrowBook(Book book) {
        if (book.getStock() == 0) {
            book.setBookStatus(StatusType.OUT_OF_STOCK);
            System.out.println("Sorry... :(  '" + book.getTitle() + "' is out of stock for now, please check again later.");
            return;
        }
        if (accountBalance < book.getPrice()) {
            System.out.println("Sorry, not enough funds in your balance... You can deposit cash by entering 7.");
            return;
        }

        if(this.books.size() >= maxBookLimit) {
            System.out.println("Could not borrow the book.");
            System.out.println("You are on maximum book limit, you can increase it by entering 10, or refund a book.");
            return;
        }
        System.out.println(book.getTitle() + " -> Loan fee: " + book.getPrice());
        this.accountBalance -= book.getPrice();
        this.books.add(book);
        book.setStock(book.getStock() - 1);
        System.out.println(book.getTitle() + " by " + book.getAuthor().getFullName() + " has been borrowed by " + this.getFullName() + ".");

        book.setBookStatus(StatusType.LENT);
        setNoBooksIssued(false);
    }


    @Override
    public void returnBook(Book book) {
        if(!this.books.contains(book)) {
            System.out.println("You have not got this book, are you a scammer ?");
            return;
        }
        this.accountBalance += book.getPrice();
        books.remove(book);
        book.setStock(book.getStock() + 1);
        book.setBookStatus(StatusType.AVAILABLE);
        System.out.println(book.getTitle() + book.getTitle() + " by " + book.getAuthor().getFullName() + " has been returned by " + this.getFullName() + ".");
        System.out.println("$" + book.getPrice() + " has been refunded to your balance.");
        if(books.size() == 0) {
            setNoBooksIssued(true);
        }
    }

    @Override
    public void whoAreYou() {
        System.out.println("I'm a " + getClass().getSimpleName().toLowerCase() + ", my name is " + getFullName() + ", my Library Member ID: " + getId() + ".");
    }

    public void showBook() {
        if(books.isEmpty()) {
            System.out.println("Currently there is no issued books on you");
            return;
        }
        if (books.size() == 1 ) {
            System.out.println("You have currently a book:" + books.get(0));
        }
        System.out.println("Listing the books on member " + getFullName() + "...");
        System.out.println("The books on you:");
        for(Book book : books) {
            System.out.println(book);
        }
    }
/*
* this.membertype = membertype;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.noBooksIssued = false;
        setRegistrationDate();
        setMaxBookLimit();
        this.accountBalance = 0.0;
*
* */
    @Override
    public String toString() {
        return super.toString() + ", Registration type: " + membertype +
                ", Address: " + address +
                ", Phone Number: " + phoneNumber +
                ", Username: " + username +
                ", Password: " + password +
                (books.size() == 0 ? "You have no books currently" : "\nYour books" + books) +
                ", \nRegistration Date: " + registrationDate +
                ", Maximum Book Limit: " + maxBookLimit +
                ", Current balance: " + BigDecimal.valueOf(accountBalance).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }



}