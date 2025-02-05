package org.librarybeko.entity.management.hr;

import org.librarybeko.entity.management.sectionmanagement.Library;

public class Manager extends Employee {

    private static final String fullName ="Osman Müdüroğlu" ;
    private static Manager instance; // Singleton

    private final String userName;
    private final String password;

    private Manager() {
        super(fullName);
        this.userName = "osm123";
        this.password = "osm123";
    }

    public static Manager getInstance() {
        if (instance == null) {
            instance = new Manager();
        }
        return instance;
    }


    public void setEmployeeCredentials(Employee employee, String userName, String password, String email) {
        employee.setUserName(userName);
        employee.setPassword(password);
        employee.setEMail(email);
        System.out.println("Credentials set for " + employee.getFullName().substring(0, 1).toUpperCase() + employee.getFullName().substring(1));
    }

    public Librarian hireNewLibrarian(String fullName, String userName, String password, String email) {
        // Çalışanın zaten eklenip eklenmediğini kontrol et
        for (Employee employee : Library.getInstance().getEmployees()) {
            if (employee.getFullName().equalsIgnoreCase(fullName)) {
                System.out.println(employee.getFullName().substring(0, 1).toUpperCase() + employee.getFullName().substring(1) + " is already hired!");
                return (Librarian) employee;
            }
        }

        // Yeni bir Librarian nesnesi oluştur
        Librarian newLibrarian = new Librarian(fullName);
        this.setEmployeeCredentials(newLibrarian, userName, password, email);

        return newLibrarian;
    }


    public void whoAreYou() {
        System.out.println("I'm the Manager, my name is " + getFullName() + ".");
    }

}
