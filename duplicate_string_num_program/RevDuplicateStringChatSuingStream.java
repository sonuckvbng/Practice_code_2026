package duplicate_string_num_program;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RevDuplicateStringChatSuingStream {

    public static void main(String[] args) {

        String str = "programming";


        // Using Stream api Distinct() ---------------------------------------------------------------------------

        String distinctCharString = str.chars()
                .distinct()
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());
        System.out.println("distinct Char String using distinct() streamapi: " + distinctCharString);


        //Using Stream api without distinct method - used linkedHashSet<>() --------------------------------------

        String result =
                str.chars()
                        .mapToObj(c -> (char )c)
                        .collect(Collectors.toCollection(LinkedHashSet::new))
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining());


        //Using Set without stream API ---------------------------------------------------------------------------

        Set<Character> set = new LinkedHashSet<>();
        for(char ch : str.toCharArray()) {
            set.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : set) {
            sb.append(ch);
        }
        System.out.println("distinct Char String using Set() " +sb);
    }
}


/*
        // Convert string to stream of characters, remove duplicates, and join back
        // Step 1: chars() - Converts the string into an IntStream of character codes
        // Step 2: distinct() - Removes duplicate character codes from the stream
        // Step 3: mapToObj() - Converts each character code back to a String object
        // Step 4: collect(Collectors.joining()) - Concatenates all strings into a single result
 */