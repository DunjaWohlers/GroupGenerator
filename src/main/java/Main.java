import model.Groups;
import model.Person;
import model.PersonDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int counter;

    public static void main(String[] args) {
        List<String> namesArray = new ArrayList<>(Arrays.asList("Yacin", "David", "Barbara", "Dunja", "Irene",
                "Nicole", "Matthias", "Sara", "Asrar", "Ahmad",
                "Sofia", "Merle", "Mehran", "Kai", "Claudia", "Alan"));
        PersonDB db = new PersonDB(namesArray);
        generateNewGroups(db);
    }

    public static void generateNewGroups(PersonDB db) {
        String input = Input();
        int gruppenAnzahl = Integer.parseInt(input);
        Groups generator = new Groups(db.getPersons(), gruppenAnzahl);
        if (gruppenAnzahl < db.getPersons().size()) {
            generator.generateGroups(db.getPersons(), Integer.parseInt(input));
            addContactNumbers(generator);
        }
        counter++;
        System.out.println("Runde: " + counter);
        for (int i = 0; i < gruppenAnzahl; i++) {
            System.out.println(generator.getGroupsList().get(i));
        }
        generateNewGroups(db);
    }

    public static String Input() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static void addContactNumbers(Groups gruppenObj) {
        for (int i = 0; i < gruppenObj.getGroupsList().size(); i++) {
            List<Person> gruppe = gruppenObj.getGroupsList().get(i);
            for (int k = 0; k < gruppe.size(); k++) { //durchläuft jede Person in grp
                Person actualPerson = gruppe.get(k);
                for (Person vergleichsPerson : gruppe) {//Kontakte hochzählen
                    actualPerson.contactCount(vergleichsPerson.getName());
                }
            }
        }
    }
}
