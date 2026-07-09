import java.util.Arrays;
import java.util.List;

public class FilterOutNumFromListOfStrAndNum {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("sts", "232", "26", "ygsak");

        List<String> numList = list.stream().filter(str -> str.chars().allMatch(Character::isDigit))
                .toList();

        List<String> numList2 = list.stream()
                        .filter(c-> c.matches("\\d+"))
                                .toList();
        System.out.println(numList);
        System.out.println(numList2);
    }
}
