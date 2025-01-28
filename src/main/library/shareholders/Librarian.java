package main.library.shareholders;

import java.util.Objects;

public class Librarian extends Person {

    private static Long idCounter = 100L;
    private Long id;
    private char[] password; // Şifreyi char[] olarak sakla

    public Librarian(String name, char[] password) {
        super(name);
        this.password = password;
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


    public void searchBook() {}

    public void verifyMember() {}

    public void issueBook() {}

    public void calculateFine() {}

    public void createBill() {}

    public void returnBook() {}

    public void whoAreYou() {
        System.out.println("I'm a " + getClass().getSimpleName() + ", my name is " + getFullName() + ", my ID is " + id + ".");
    };

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