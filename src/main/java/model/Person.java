package model;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Person {
    String name;


    Map<String, Integer> contacts;

    public Person(String name) {
        this.name = name;
        this.contacts = new HashMap<>();
    }

    public Map<String, Integer> getContacts() {
        return contacts;
    }

    public void addEmptyContacts(List<String> names) {
        names.forEach(name -> this.contacts.put(name.toLowerCase(Locale.ROOT), 0));
    }

    public void countContactByKey(String key) {
        int inhalt = this.getContacts().get(key);
        this.getContacts().replace(key, inhalt + 1);
    }

    @Override
    public String toString() {
        return name;
    }
//public Person getMinimumContact(List<Person> freePersons) {
    //    int minimum = 0;
    //    int actualContactedTimes = 1;
    //    Contact actualContact = new Contact("x", 5);
    //    while (actualContactedTimes > minimum) {
    //        for (Contact contact : this.contacts) {
    //            for (Person personInGrp : freePersons) {
    //                if (personInGrp.getName() == contact.name) {
    //                    actualContact = new Contact(contact.name, contact.contactedTimes);
    //                    actualContactedTimes = contact.contactedTimes;
    //                }
    //            }
    //        }
    //        minimum++;
    //    }
    //    final Contact finalActualContact = actualContact;

    //    // freePersons.stream().filter(e-> Objects.equals(e.name, finalActualContact.name));
    //    return freePersons.stream().filter(e -> Objects.equals(e.name, finalActualContact.name)).findFirst().orElse(null);
    //}

    //public void contactCount(String name) {
    //    for (Contact contact : this.contacts) {
    //        if (name.equals(contact.name)) {
    //            contact.contactedTimes++;
    //        }
    //    }
    //}

    //@Override
    //public String toString() {
    //    StringBuilder str = new StringBuilder("" + name);
    //    String[] ar = str.toString().split("");
    //    str.append(" ".repeat(Math.max(0, 10 - ar.length)));
    //    for (Contact contact : contacts) {
    //        if (contact.contactedTimes <= 9) {
    //            str.append(" ");
    //        }
    //        str.append(" ").append(contact.contactedTimes);
    //    }
    //    return str.toString();
    //}

    //public String toShortString() {
    //    String str = "" + name;
    //    return str;
    //}

    public String getName() {
        return name;
    }
}
