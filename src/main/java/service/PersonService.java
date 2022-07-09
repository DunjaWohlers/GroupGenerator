package service;

import model.Person;

import java.util.*;

public class PersonService {
    List<String> nameList;
    List<Person> persons;

    public PersonService(List<String> namesArray) {
        this.nameList = namesArray;
        this.persons = namesArray.stream().map(Person::new).toList();
    }

    public List<Person> getPersons() {
        return persons;
    }
}
