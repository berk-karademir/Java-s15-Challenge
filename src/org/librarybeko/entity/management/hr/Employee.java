package org.librarybeko.entity.management.hr;

import org.librarybeko.entity.management.enums.EmployeeType;
import org.librarybeko.entity.management.sectionmanagement.Library;

import java.util.regex.Pattern;

public abstract class Employee extends Person {
    private static Long idCounter = 100L;
    private Long id;
    private String userName;
    private String password;
    private String eMail;
    private EmployeeType employeeType;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public Employee(String fullName) {
        super(fullName.substring(0, 1).toUpperCase() + fullName.substring(1));
        this.id = ++idCounter;
        Library.getInstance().getEmployees().add(this);
        System.out.println(getClass().getSimpleName() + " " + getFullName().substring(0, 1).toUpperCase() + fullName.substring(1) + " has been hired and started to working.");

    }

    public Long getId() {
        return id;
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    public String getUserName() {
        return userName;
    }

    public String getEMail() {
        return eMail;
    }

    public String getPassword() {
        return password;
    }

    protected void setUserName(String userName) {
        this.userName = userName;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    protected void setEMail(String eMail) {
        if (eMail == null || !EMAIL_PATTERN.matcher(eMail).matches()) {
            throw new IllegalArgumentException("Invalid email format! Please provide a valid email.");
        } else {
            this.eMail = eMail;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", ID: " + id;
    }

}
