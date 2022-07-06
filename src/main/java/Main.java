import model.Groups;
import model.Person;
import model.PersonDB;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    int gruppenAnzahl=5;
        PersonDB db= new PersonDB();
        public void generateNewGroups(db, gruppenAnzahl);


    }

    public void generateNewGroups(PersonDB db, int  gruppenAnzahl){
        Groups generator=new Groups(db.getPersons(),gruppenAnzahl);
        System.out.println(generator.getGrps()[0].length);
        for(int i=0;i<gruppenAnzahl;i++) {
            System.out.println(Arrays.toString(generator.getGrps()[i]));
        }

        Scanner scan= new Scanner(System.in);
        String input=scan.nextLine();
        if (Integer.parseInt(input)<db.getPersons().length){
            generator.generateGroups(db.getPersons(),Integer.parseInt(input));
        }


        for(int i=0;i<gruppenAnzahl;i++) {
            System.out.println(Arrays.toString(generator.getGrps()[i]));
        }
    }


}
