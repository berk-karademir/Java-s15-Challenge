package org.librarybeko.entity.management.enums;


public enum EmployeeType {
    MANAGER("General Manager / Head"),
    LIBRARIAN("Librarian"),
    OTHER_STAFF("Others");

    private final String displayName;

    EmployeeType(String displayName){
            this.displayName = displayName;
        }

    @Override
    public String toString() {
        return displayName;
    }
}
