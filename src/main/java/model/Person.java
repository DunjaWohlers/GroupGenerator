package model;

public class Person {
    String name;
    Contact[] contacts;

    public Person(int index, String[] namesArray) {
        this.contacts = new Contact[namesArray.length];
        this.name = namesArray[index];
        for (int i = 0; i < namesArray.length; i++) {
            if (this.contacts[i] == null) {
                this.contacts[i] = new Contact(namesArray[i], 0);
            } else {
                this.contacts[i].name = namesArray[i];
                this.contacts[i].contactedTimes = 0;
            }
        }


    }

    public void contactCount(String name) {
        /*for (int i = 0; i < this.contacts.length; i++) {
            if (name.equals(this.contacts[i].name)) {
                this.contacts[i].contactedTimes++;
            }
        }*/
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
        /*
             for (int i = 0; i < 10 - ar.length; i++) {
            str.append(" ");
        }*/
        str.append(" ".repeat(Math.max(0, 10 - ar.length)));
        for (Contact contact : contacts) {
            str.append(" ").append(contact.contactedTimes);
        }
        return str.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact[] getContacts() {
        return contacts;
    }

    public void setContacts(Contact[] contacts) {
        this.contacts = contacts;
    }
}
