package basic_concept_program;

import java.util.Collections;
import java.util.stream.Collectors;

public class reverseNum {
    public static void main(String[] args) {
        int num = 54321;
        int originalNum = num;  // Store original for Stream API

        //Using traditional approach
        int rev=0, rem;
        while(num!=0){
            rem = num%10;  // Extract last digit: 54321 % 10 = 1
            num = num/10;  // Remove last digit: 54321 / 10 = 5432
            rev =  rev * 10 + rem;  // Build reversed number: 0*10 + 1 = 1, then 1*10 + 2 = 12, etc.
        }
        System.out.println("Reversed using traditional: " + rev);

        // Using Stream API to reverse number
        int reversed = Integer.parseInt(
                String.valueOf(originalNum)          // Step 1: Convert int to String: "54321"
                        .chars()                     // Step 2: Get IntStream of char codes: [53, 52, 51, 50, 49]
                        .mapToObj(c -> (char) c)      // Step 3: Convert int codes to Characters: ['5', '4', '3', '2', '1']
                        .collect(Collectors.collectingAndThen(
                                Collectors.toList(), // Step 4: Collect to List<Character>
                                list -> {
                                    Collections.reverse(list);  // Step 5: Reverse the list: ['1', '2', '3', '4', '5']
                                    return list;
                                }
                        ))
                        .stream()                     // Step 6: Stream the reversed list
                        .map(String::valueOf)         // Step 7: Convert each Character to String
                        .collect(Collectors.joining()) // Step 8: Join all strings: "12345"
        );

        System.out.println("Original number: " + originalNum);
        System.out.println("Reversed number: " + reversed);

        /*
         * Stream API Explanation:
         * 1. String.valueOf(originalNum) - Converts integer to string
         * 2. .chars() - Returns IntStream of character codes (ASCII values)
         * 3. .mapToObj(c -> (char) c) - Converts int codes to Character objects
         * 4. .collect(Collectors.toList()) - Collects characters into a list
         * 5. Collections.reverse(list) - Reverses the list in place
         * 6. .stream() - Creates a new stream from the reversed list
         * 7. .map(String::valueOf) - Converts each Character to String
         * 8. .collect(Collectors.joining()) - Joins all strings together
         * 9. Integer.parseInt() - Parses the final string back to integer
         */
    }
}
