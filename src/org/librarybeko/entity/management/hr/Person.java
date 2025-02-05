package org.librarybeko.entity.management.hr;

public abstract class Person implements PersonInterface {

    private String fullName;

    public Person(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException(getClass().getSimpleName() + "'s name cannot be null or empty!");
        }

        // İnsan isminin yalnızca harflerden oluştuğunu kontrol eder
        if (!fullName.matches("[a-zA-ZçÇğĞıİöÖşŞüÜâ\\s.-]+")) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " name must not contain numbers or special characters!");
        }
        this.fullName = fullName;
    }


    @Override
    public String toString() {
        return "\n"+getClass().getSimpleName() + "member's name: " + fullName ;
    }

}