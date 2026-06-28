package default_program_practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMapUsingStreamAPI {
    public static void main(String[] args) {

        List<String> empList = Arrays.asList("Sonu","Aruna","Naina");

        Map<Integer, String> listToMap = empList.stream()
                .collect(Collectors.toMap(String::length, name -> name,(oldLen,newLen)->oldLen));

        System.out.println("List to Map using Stream Api : " + listToMap);

    }
}
