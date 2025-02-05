package org.librarybeko.entity.management.enums;

public enum StatusType {
    LENT("Lent"),
    AVAILABLE("Available"),
    OUT_OF_STOCK("Out of Stock"),
    IN_PREPARATION_STAGE("In Preparation Stage");


    private final String displayName;

    // Constructor
    StatusType(String displayName) {
        this.displayName = displayName;
    }


    // Override toString method
    @Override
    public String toString() {
        return displayName;
    }
}
