package model;

import java.util.Arrays;

public class Person {
    String name;
    Contact[] kontakte;

    public Person(int index) {
        NameList names = new NameList();
        this.kontakte = new Contact[names.personList.length];
        this.name=names.personList[index];
        for (int i = 0; i < names.personList.length; i++) {
            if (this.kontakte[i] == null) {
                this.kontakte[i] = new Contact(names.personList[i], 0);
            } else {
                this.kontakte[i].name = names.personList[i];
                this.kontakte[i].contactedTimes = 0;
            }
        }


    }

    public void contactCount(String name) {
        for (int i = 0; i < this.kontakte.length; i++) {
            if (name == this.kontakte[i].name) {
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
