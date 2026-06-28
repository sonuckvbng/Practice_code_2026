package basic_concept_program;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VowelAndCons {

    public static void main(String[] args) {

        String s = "Sonu chaurasia";

        int vow = 0, cons = 0;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vow++;
            } else if (c != ' ') {
                cons++;
            }
        }
        System.out.println("Traditional approach:");
        System.out.println("Vowels : " + vow);
        System.out.println("Consonants : " + cons);

        // Using Stream API with partitioningBy
        Map<Boolean, List<Character>> group = s.chars()
                .distinct()
                .mapToObj(ch -> (char) ch)
                .filter(c -> c != ' ')  // Filter out spaces
                .collect(Collectors.partitioningBy(c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'));

        System.out.println("\nStream API approach:");
        System.out.println("Vowels : " + group.get(true));
        System.out.println("Consonants : " + group.get(false));
        System.out.println("Vowel count : " + group.get(true).size());
        System.out.println("Consonant count : " + group.get(false).size());
    }
}
