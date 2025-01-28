package main.library.shareholders;

public abstract class Person {

    private String fullName;

    public Person(String fullName){
        setName(fullName);
    }

    public String getFullName() {
        return fullName;
    }

    public void setName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " name cannot be null or empty!");
        }

        // İnsan isminin yalnızca harflerden oluştuğunu kontrol eder
        if (!fullName.matches("[a-zA-ZçÇğĞıİöÖşŞüÜâ\\s.-]+")) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " name must not contain numbers or special characters!");
        }
        this.fullName = fullName;
    }

    public abstract void whoAreYou();




    @Override
    public String toString() {
        return getClass().getSimpleName() + "'s name: " + fullName;
    }

}
