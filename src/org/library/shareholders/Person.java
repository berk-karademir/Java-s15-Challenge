package org.library.shareholders;

import java.util.Objects;

public abstract class Person {

    private static int idCounter = 0;
    private int id;
    private String name;

    public Person(String name) {
        this.id = ++idCounter;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void whoAreYou() {
        System.out.println(this);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Person person)) return false;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "'s name: " + name + "," + " ID: " + id;
    }

}
