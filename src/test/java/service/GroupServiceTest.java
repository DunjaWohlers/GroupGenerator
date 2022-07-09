package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupServiceTest {

    @Test
    void generateNewGroups() {
        //
        List<String> namesArray = new ArrayList<>(
                Arrays.asList("Yacin", "David", "Barbara", "Dunja", "Irene",
                        "Nicole", "Matthias", "Sara", "Asrar", "Ahmad",
                        "Sofia", "Merle", "Mehran", "Kai", "Claudia", "Alan"));
        PersonService db = new PersonService(namesArray);
        GroupService groupService = new GroupService(db);

        int groupQantity = 5;
        groupService.generateNewGroups(groupQantity);


        groupService.generateNewGroups(groupQantity);
        groupService.getGroups().forEach(System.out::println);

        //  Assertions.assertEquals();

    }
}