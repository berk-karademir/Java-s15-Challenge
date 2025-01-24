package org.library;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void whoAreYou() {
        System.out.println("I'm " + this.name + ".");
    }
}
