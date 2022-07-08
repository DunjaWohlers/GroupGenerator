package model;

import java.util.List;

public class Person {
    String name;
    Contact[] contacts;

    public Person(int index, List<String> namesArray) {
        this.contacts = new Contact[namesArray.size()];
        this.name = namesArray.get(index);
        for (int i = 0; i < namesArray.size(); i++) {
            this.contacts[i] = new Contact(namesArray.get(i), 0);
        }
    }

    public void contactCount(String name) {
        for (Contact contact : this.contacts) {
            if (name.equals(contact.name)) {
                contact.contactedTimes++;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("" + name);
        String[] ar = str.toString().split("");
        str.append(" ".repeat(Math.max(0, 10 - ar.length)));
        for (Contact contact : contacts) {
            if (contact.contactedTimes <= 9) {
                str.append(" ");
            }
            str.append(" ").append(contact.contactedTimes);
        }
        return str.toString();
    }

    public String toShortString() {
        String str = "" + name;
        return str;
    }

    public String getName() {
        return name;
    }
}
