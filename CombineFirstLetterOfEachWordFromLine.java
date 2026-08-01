import java.util.Arrays;
import java.util.stream.Collectors;

public class CombineFirstLetterOfEachWordFromLine {
    public static void main(String[] args) {

        String str = "Java Stream API";

        String result = Arrays.stream(str.split(" "))
                .map(word -> String.valueOf(word.charAt(0)))
                .collect(Collectors.joining());

        System.out.println("Final.: " + result);
    }
}
