
import service.GroupService;
import service.PersonService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int counter;

    public static void main(String[] args) {
        List<String> namesArray = new ArrayList<>(
                Arrays.asList("Yacin", "David", "Barbara", "Dunja", "Irene",
                        "Nicole", "Matthias", "Sara", "Asrar", "Ahmad",
                        "Sofia", "Merle", "Mehran", "Kai", "Claudia", "Alan"));
        PersonService db = new PersonService(namesArray);
        GroupService groupService = new GroupService(db);

        //groupService.getGroups().forEach(System.out::println);
        askForNewGroupAndGenerate(groupService);


    }

    static void askForNewGroupAndGenerate(GroupService groupService) {
        int groupsNumber;
        try {
            groupsNumber = Input();
            groupService.generateNewGroups(groupsNumber);
            System.out.println(groupService.getMeetingsGridToString());
        } catch (Exception e) {
            System.out.println("Gib bitte eie Nummer ein:");
        } finally {
            askForNewGroupAndGenerate(groupService);
        }
    }

    public static int Input() {
        Scanner scan = new Scanner(System.in);
        return Integer.parseInt(scan.nextLine());
    }


}
