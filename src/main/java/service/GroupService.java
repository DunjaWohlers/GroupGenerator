package service;

import model.Group;
import model.Person;

import java.util.*;

public class GroupService {


    private final PersonService personService;
    private final List<Group> groups = new ArrayList<>();
    Map<String, List<Integer>> meetingsGrid;
    int counter = 0;

    public GroupService(PersonService personService) {
        this.personService = personService;
        this.meetingsGrid = new HashMap<>();

    }

    public void generateNewGroups(int groupQuantity) {
        //gruppenzaehler zurücksetzen grid
        meetingsGrid.clear();
        this.personService.getPersons().forEach(e -> meetingsGrid.put(e.getName().toLowerCase(Locale.ROOT), new ArrayList<>()));
        meetingsGrid.values().forEach(e -> this.personService.getPersons().forEach(z -> e.add(0)));
        //
        counter++;
        List<Person> persons = new ArrayList<>(personService.getPersons());
        Collections.shuffle(persons);

        // List<Person> alreadyLocked = new ArrayList<>();
        List<Group> plannedGroups = new ArrayList<>(groupQuantity);
        List<Person> temporaryGroup = new ArrayList<>();
        //     int rest = persons.size() % groupQuantity;
        int minimalMembersPerGroup = persons.size() / groupQuantity;

        for (Person person : persons) {
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
        this.groups.forEach(group -> group.getParticipants().forEach(groupmember ->
                group.getParticipants().forEach(partner -> {
                    //absoluter index des aktuellen partners in index speichern.
                    int partnerIndex = this.personService.getPersons().indexOf(partner);
                    int actualNumber = this.meetingsGrid.get(groupmember.getName().toLowerCase(Locale.ROOT)).get(partnerIndex);

                    this.meetingsGrid.get(groupmember.getName().toLowerCase(Locale.ROOT)).set(partnerIndex, actualNumber + 1);

                })));
        // System.out.println(getMeetingsGridToString());

    }

    public List<Group> getGroups() {
        return groups;
    }

    public String getMeetingsGridToString() {
        String str = "";

        for (String key : this.meetingsGrid.keySet()) {
            str += key + " " + this.meetingsGrid.get(key).toString() + "\n";

        }
        return str;
    }
}

