package model;

public class PersonDB {
    Person[] persons;

    public PersonDB(){
        NameList nameList=new NameList();
        this.persons=new Person[nameList.personList.length];

        for(int i=0;i<nameList.personList.length;i++){
            Person pers=new Person(i); //enthält Name und Kontakte
            this.persons[i] = pers;
        }
    }

    public Person[] getPersons() {
        return persons;
    }

    public void setPersons(Person[] persons) {
        this.persons = persons;
    }
}
