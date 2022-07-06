package model;

import java.util.*;

public class PersonDB {
    List<String> nameList;
    List<Person> persons;

    public PersonDB(List<String> namesArray) {
        this.nameList = namesArray;
        System.out.println(namesArray);
        System.out.println(namesArray.size());
        this.persons = new ArrayList<>() {
        };
        for (int i = 0; i < namesArray.size(); i++) {
            persons.add(new Person(i, namesArray));
        }
    }

    public List<Person> getPersons() {
        return persons;
    }
}
