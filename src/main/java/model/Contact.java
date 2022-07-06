package model;

public class Contact {
    String name;
    int contactedTimes;

    public Contact(String name, int contactedTimes) {
        this.name = name;
        this.contactedTimes = contactedTimes;
    }

    @Override
    public String toString() {
        return "" + name + "K: " + contactedTimes + ' ';
    }
}