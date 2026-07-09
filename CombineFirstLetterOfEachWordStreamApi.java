import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombineFirstLetterOfEachWordStreamApi {

    public static void main(String[] args) {

       /*
        Given a sentence, extract and combine the first letter of each word using Java Streams only.
        Input:"Java Stream API"
        Output:JSA
        */

        String str = "Java Stream Api";

        String firstCharOfWord = Arrays.stream(str.split("\\s+"))
                .map(word -> String.valueOf(word.charAt(0)))
                .collect(Collectors.joining());

        System.out.println("First letter of each word of sentence joining stream api : " + firstCharOfWord);

        String result = Stream.of(str.split("\\s+"))
                .map(s -> s.substring(0, 1))
                .collect(Collectors.joining());

        System.out.println("First letter of each word of sentence joining stream api : " + result);
    }

}
