package com.example;

public class People {
    // construct some data

    private Person[] people = {
            new Person("Cristian George", "Home", "1234", "https://www.unitbv.com", "cristian.jpg"),
            new Person("Cristian George", "Work", "2345", "https://www.unitbv.com", "cristian.jpg"),
            new Person("Cristian George", "School", "3456", "https://www.unitbv.com", "cristian.jpg"),
    };

    public Person[] getData() {
        return people;
    }

    public Person getPerson(int i) {
        return people[i];
    }

    public int getCount() {
        return people.length;
    }
}