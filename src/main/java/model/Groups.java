package model;

import java.util.*;

public class Groups {
    List<List<Person>> groupsList = new ArrayList<>();
    int minimumContacts = 0;

    public Groups(List<Person> persons, int groups) {
        //Leere initiale Gruppenarrays erstellen:
        for (int i = 0; i < 10; i++) {
            groupsList.add(new ArrayList<>());
        }
        //     System.out.println(groupsList);
        generateGroups(persons, groups);
    }

    public List<List<Person>> getGroupsList() {
        return groupsList;
    }

    public void generateGroups(List<Person> persons, int groups) {
        //leere arrays reintun
        groupsList.clear();
        //    System.out.println(groupsList);
        for (int i = 0; i < 10; i++) {
            groupsList.add(new ArrayList<>());
        }
        int rest = persons.size() % groups;
        int minimalMembersPerGroup = persons.size() / groups;

        //2 Personen mit minimal-Treffern speichern und zuerst in gruppe 1 packen:
        List<Integer> zweierListe = get2PersonsIndexwithNull(persons);
        this.groupsList.get(0).add(persons.get(zweierListe.get(0)));
        this.groupsList.get(0).add(persons.get(zweierListe.get(1)));
        System.out.println(persons.get(zweierListe.get(0)));
        System.out.println(persons.get(zweierListe.get(1)));
        List<Integer> indizes = new ArrayList<>();
        for (int i = 0; i < rest; i++) {
            int rand = (int) (Math.random() * groupsList.size());
            while (zweierListe.get(0) == rand || zweierListe.get(1) == rand || indizes.contains(rand)) {
                rand = (int) (Math.random() * groupsList.size());
            }
            indizes.add(rand);
        }
        //Minimalgröße , Restgruppen füllen (nur die zwei bisherigen nicht mit rein!)
        for (int i = 0; i < persons.size(); i++) {
            boolean escape = false;
            if (i == zweierListe.get(0) || i == zweierListe.get(1)) {
                escape = true;
            }
            //Alle "restpersonen " rausnehmen:
            if (indizes.contains(i)) {
                escape = true;
            }
            //Gruppen füllen
            while (!escape) {
                int rand = (int) (Math.random() * groups);
                if (this.groupsList.get(rand).size() < minimalMembersPerGroup) {
                    //  if(!persons.get(i).name.equals(zweierArray[0].name)&&!persons.get(i).name.equals(zweierArray[1].name)){
                    this.groupsList.get(rand).add(persons.get(i));
                    //}
                    escape = true;
                } else {
                    // System.out.println("gruppe" + rand + " ist voll , " + persons.get(i) + " muss woanders rein");
                }
            }
        }
        //Rest einfüllen
        for (Integer indize : indizes) {
            //  System.out.println(persons.get(i));
            boolean escape = false;
            while (!escape) {
                int rand = (int) (Math.random() * groups);
                if (this.groupsList.get(rand).size() == minimalMembersPerGroup) {
                    this.groupsList.get(rand).add(persons.get(indize));
                    escape = true;
                }
            }
        }
    }

    public List<Integer> get2PersonsIndexwithNull(List<Person> persons) {
        //minimumContacts = 0;
        List<Integer> twoPersons = new ArrayList<>();
        boolean ready = false;
        int counter = 0;
        while (!ready) {
            for (Person person : persons) {
                twoPersons.add(counter);
                int indexOfPerson = 0;
                for (Contact contact : person.contacts) {
                    if (contact.contactedTimes == minimumContacts && !Objects.equals(contact.name, person.name)) {
                        twoPersons.add(indexOfPerson);
                        ready = true;
                        break;
                    }
                    indexOfPerson++;
                }
                counter++;

            }
            if (!ready) {
                minimumContacts++;
            }
            System.out.println("minimumkontakte");
            System.out.println(minimumContacts);
        }
        return twoPersons;
    }
}