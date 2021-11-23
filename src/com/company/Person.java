package com.company;

public class Person implements Comparable<Person> {

    public Person(String name, String lastName) {
        this.name=name;
        this.lastName = lastName;
    }

    private String lastName;
    private String name;

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    //metoda umożliwia poprawne fukcjonowanie kolekcji Set
    @Override
    public int compareTo(Person o) {
        if (this.equals(o))
            return 0;

        if (this.name.compareTo(o.name) >= 0)
            return 1;

        else return -1;
    }


}
