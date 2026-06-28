package default_program_practice;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCharactersInString {

    public static void main(String[] args) {

        String str = "programming";

        //for each and set
        Set<Character> set = new HashSet<>();

        System.out.println("Duplicate Elements In Array using forEach and HashSet :");
        for(char ch : str.toCharArray()){
            if(!set.add(ch)){
                System.out.println(ch);
            }
        }

        //using stream Api and set
        Set<Character> setStream = new HashSet<>();

        System.out.println("Duplicate Elements In Array using Stream api and HashSet with filter() :");
        str.chars().mapToObj(ch -> (char) ch)
                .filter(ch -> !setStream.add(ch))
                .forEach(System.out::println);

        //Stream API with groupingBy() and counting()
        str.chars()
                .mapToObj(ch -> (char)ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >1)
                .map(Map.Entry::getKey)
                .toList();
    }
}
