package com.company;

import java.util.Objects;

public class EqPerson extends Person {

    public EqPerson(String name, String lastName) {
        super(name, lastName);
    }
    //metody zostały nadpisane aby w klasie EqPerson obiekty o takich smaych zmiennych name oraz lastName zostały dostrzeżone jako takie same obiekty przy sortowaniu itd.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLastName(), getName());
    }
}
