package service;

import model.Group;
import model.Person;

import java.util.*;

public class GroupService {


    public PersonService getPersonService() {
        return personService;
    }

    private final PersonService personService;
    private final List<Group> groups = new ArrayList<>();

    public int getCounter() {
        return counter;
    }

    int counter = 0;

    public GroupService(PersonService personService) {
        this.personService = personService;
    }

    public void generateNewGroups(int groupQuantity) {
        //gruppenzaehler zurücksetzen grid
        this.personService.clearContacts();
        //
        counter++;
        List<Person> persons = newOptimizedRandomList();

        List<Group> plannedGroups = new ArrayList<>(groupQuantity);
        List<Person> temporaryGroup = new ArrayList<>();
        //     int rest = persons.size() % groupQuantity;
        int minimalMembersPerGroup = persons.size() / groupQuantity;

        for (Person person : persons) {//hier sind immer dieselben..... :((BUGGG
            //randomperson adden
            temporaryGroup.add(person);
            //     alreadyLocked.add(person);
            if (temporaryGroup.size() >= minimalMembersPerGroup) {
                plannedGroups.add(new Group(temporaryGroup, counter));
                temporaryGroup = new ArrayList<>();
            }
        }
        int counter = 0;
        for (Person person : temporaryGroup) {
            plannedGroups.get(counter).addPerson(person);
            counter++;
        }

        this.groups.addAll(plannedGroups);
        //Kontakte mit wem jeweils generieren:
        this.groups.forEach(group ->
                group.getParticipants().forEach(groupmember ->
                        group.getParticipants().forEach(partner ->
                                groupmember.countContactByKey(partner.getName().toLowerCase(Locale.ROOT)))));
        // System.out.println(getMeetingsGridToString());
    }

    private List<Person> newOptimizedRandomList() {
        List<Person> newList = new ArrayList<>();
        List<Person> fourPersons = new ArrayList<>(this.personService.get4RandomPersonsWithMinContact());
        //    System.out.println("problem");
        //    System.out.println(fourPersons);
        //  System.out.println(restPersons);
        List<Person> restPersons = new ArrayList<>(this.personService.getRestPersonsWithout(fourPersons));
        Collections.shuffle(restPersons);
        // System.out.println(restPersons);
        newList.add(fourPersons.get(0));
        newList.add(fourPersons.get(1));
        newList.addAll(restPersons);
        newList.add(fourPersons.get(2));
        newList.add(fourPersons.get(3));

        //  System.out.println(newList);
        return newList;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public String getMeetingsGridToString() {
        StringBuilder str = new StringBuilder();
        for (Person person : this.personService.getPersons()) {
            str.append(person.getName());
            str.append(" ".repeat(Math.max(0, 10 - person.getName().length())));
            str.append(": ");
            for (String key : person.getContacts().keySet()) {
                str.append(" ".repeat(Math.max(0, 4 - person.getContacts().get(key).toString().length())));
                str.append(person.getContacts().get(key));
            }
            str.append("\n");
        }
        return str.toString();
    }

    public String getKeysForGridToString() {
        StringBuilder str = new StringBuilder();
        Person pers = this.personService.getPersons().get(0);
        str.append(" ".repeat(10));
        str.append(": ");
        for (String key : pers.getContacts().keySet()) {
            if (key.length() >= 4) {
                str.append(key.substring(0, 1).toUpperCase(Locale.ROOT)).append(key, 1, 4);
            } else {
                str.append(key.substring(0, 1).toUpperCase(Locale.ROOT)).append(key.substring(1)).append(" ");
            }
        }
        str.append("\n");

        return str.toString();
    }
}

