package model;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Groups {
    List<List<Person>> groupsList = new ArrayList<>();

    public Groups(List<Person> persons, int groups) {
        //Leere initiale Gruppenarrays erstellen:
        for (int i = 0; i < 10; i++) {
            groupsList.add(new ArrayList<>());
        }
        System.out.println(groupsList);
        generateGroups(persons, groups);
    }

    public List<List<Person>> getGroupsList() {
        return groupsList;
    }

    public void generateGroups(List<Person> persons, int groups) {
        //leere arrays reintun
        groupsList.clear();
        System.out.println(groupsList);
        for (int i = 0; i < 10; i++) {
            groupsList.add(new ArrayList<>());
        }

        int rest = persons.size() % groups;
        int minimalMembersPerGroup = persons.size() / groups;

        //Minimalgröße , gruppen füllen
        for (int i = 0; i < persons.size() - rest; i++) {
            boolean escape = false;
            while (!escape) {
                int rand = (int) (Math.random() * groups);
                if (this.groupsList.get(rand).size() < minimalMembersPerGroup) {
                    this.groupsList.get(rand).add(persons.get(i));
                    escape = true;
                } else {
                    System.out.println("gruppe" + rand + " ist voll , " + persons.get(i) + " muss woanders rein");
                }
            }
        }
        //Rest einfüllen
        for (int i = persons.size() - rest; i < persons.size(); i++) {
            System.out.println(persons.get(i));
            boolean escape = false;
            while (!escape) {
                int rand = (int) (Math.random() * groups);
                if (this.groupsList.get(rand).size() == minimalMembersPerGroup) {
                    this.groupsList.get(rand).add(persons.get(i));
                    escape = true;
                }
            }
        }
        //for (Person person : persons.values()) {//alle Gruppen füllen

        //}
    }
}