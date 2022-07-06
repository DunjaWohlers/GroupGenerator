package model;

import java.util.Arrays;

public class Person {
    String name;
    Contact[] kontakte;

    public Person(int index, String[] namesArray) {
        this.kontakte = new Contact[namesArray.length];
        this.name=namesArray[index];
        for (int i = 0; i < namesArray.length; i++) {
            if (this.kontakte[i] == null) {
                this.kontakte[i] = new Contact(namesArray[i], 0);
            } else {
                this.kontakte[i].name = namesArray[i];
                this.kontakte[i].contactedTimes = 0;
            }
        }


    }

    public void contactCount(String name) {
        for (int i = 0; i < this.kontakte.length; i++) {
            if (name.equals(this.kontakte[i].name)) {
                this.kontakte[i].contactedTimes++;
            }
        }
    }

    @Override
    public String toString() {
        String str = "" + name;
        String[] ar=str.split("");
        for(int i=0;i < 10-ar.length;i++){
            str += " ";
        }
        for(int i=0;i< kontakte.length;i++){
            str+= " " + kontakte[i].contactedTimes;
        }
        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact[] getKontakte() {
        return kontakte;
    }

    public void setKontakte(Contact[] kontakte) {
        this.kontakte = kontakte;
    }
}
