package com.example;

public class People {
    // construct some data

    private Person[] people = {
            new Person("Cristian", "Home", "1234", "www.cristian.com", "cristian.jpg"),
            new Person("George", "Work", "2345", "www.george.com", "cristian.jpg"),
            new Person("Cristinel", "School", "3456", "www.cristi.com", "cristian.jpg"),
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