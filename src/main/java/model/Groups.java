package model;

import java.util.Arrays;

public class Groups {
    Person[][] groupsArray = {new Person[0], new Person[0], new Person[0], new Person[0], new Person[0], new Person[0], new Person[0], new Person[0]};

    public Groups(Person[] persons, int groups) {
        generateGroups(persons, groups);
    }

    public void generateGroups(Person[] persons, int groups) {
        Arrays.fill(groupsArray, new Person[0]);//
        int rest = persons.length % groups;
        int maxGroupMembers = (persons.length) / groups;
        int count = 0;
        while (count < persons.length - rest) {
            int rand = (int) (Math.random() * groups);
            if (this.groupsArray[rand].length < maxGroupMembers) {
                addPersonToGroup(rand, persons[count]);
                count++;
            } else {
                System.out.println("Gruppe ist voll, nächste, Bitte!");
            }
        }
    }

    public void addPersonToGroup(int rand, Person pers) {
        Person[] newGrp = new Person[this.groupsArray[rand].length + 1];
        newGrp[this.groupsArray[rand].length] = pers;
        System.arraycopy(this.groupsArray[rand], 0, newGrp, 0, newGrp.length - 1);//
        this.groupsArray[rand] = newGrp;
    }

    public Person[][] getGrps() {
        return groupsArray;
    }

    public void setGrps(Person[][] grps) {
        this.groupsArray = grps;
    }
}