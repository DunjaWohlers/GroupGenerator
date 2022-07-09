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

    public void clearContacts() {
        for (Person person : this.persons) {
            person.addEmptyContacts(this.nameList);
        }
    }

    public List<Person> getPersons() {
        return persons;
    }

    public int getMinimalContactNumber() {
        int actualMinNumber = 100;
        for (Person person : this.persons) {

            int personMinimum = 100;
            //    System.out.println(person.getContacts().values());
            for (int num : person.getContacts().values()) {
                personMinimum = Math.min(personMinimum, num);
                //         System.out.println("persmin");
                //            System.out.println(personMinimum);
            }
            actualMinNumber = Math.min(actualMinNumber, personMinimum);
            //        System.out.println("Actual");
            //        System.out.println(actualMinNumber);

        }
        return actualMinNumber;
    }

    public List<Person> get4RandomPersonsWithMinContact() {
        int minContactNumber = getMinimalContactNumber();
        List<Person> fourPersons = new ArrayList<>();
        int counter = 0;
        //     System.out.println("for while");
        //    System.out.println(this.persons.size());
        while (counter < 4) {
            //         System.out.println("in while");
            //         System.out.println(this.persons.size());
            int random = (int) (Math.random() * this.persons.size());
            //        System.out.println(random);
            Person randomPerson = this.persons.get(random);
            //     System.out.println(randomPerson);
            if (randomPerson.getContacts().containsValue(minContactNumber) && !fourPersons.contains(randomPerson)) {
                fourPersons.add(randomPerson);
                counter++;
            }
        }
        return fourPersons;
    }

    public List<Person> getRestPersonsWithout(List<Person> fourPersons) {
        final List<Person> restPersons = new ArrayList<>(this.persons);
        for (Person pers : fourPersons) {
            restPersons.remove(pers);
        }
        return restPersons;
    }

}
