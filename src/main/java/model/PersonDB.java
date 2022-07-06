package model;

public class PersonDB {
    Person[] persons;

    public PersonDB(String[] namesArray){
        this.persons=new Person[namesArray.length];
        for(int i=0;i<namesArray.length;i++){
            this.persons[i] = new Person(i, namesArray);
        }
    }

    public Person[] getPersons() {
        return persons;
    }

    public void setPersons(Person[] persons) {
        this.persons = persons;
    }
}
