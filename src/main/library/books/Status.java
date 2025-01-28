package main.library.books;

public enum Status {
    LENDED("Lended"),
    BORROWABLE("Borrowable"),
    PURCHASABLE("Purchasable"),
    IN_PREPARATION_STAGE("In Preparation Stage");

    private final String displayName;

    // Constructor
    Status(String displayName) {
        this.displayName = displayName;
    }

    // Override toString method
    @Override
    public String toString() {
        return displayName;
    }
}
