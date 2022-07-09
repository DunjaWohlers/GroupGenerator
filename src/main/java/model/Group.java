package model;

import java.util.*;

public class Group {


    List<Person> participants;
    int tagNr;

    public Group(List<Person> persons, int tagNr) {
        this.participants = persons;
        this.tagNr = tagNr;
    }

    public void addPerson(Person person) {
        this.participants.add(person);
    }

    public List<Person> getParticipants() {
        return participants;
    }

    @Override
    public String toString() {
        return "" + participants +
                ", tagNr=" + tagNr;
    }
}
