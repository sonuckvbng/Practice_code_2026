package basic_concept_program;

import java.util.HashMap;

public class FirstNonRepeating {
    public static Character firstNonRepeating(String str) { // Method to find first non-repeating character
        HashMap<Character, Integer> map = new HashMap<>(); // Create map to store character frequencies

        for (char ch : str.toCharArray()) { // Iterate through each character in the string
            map.put(ch, map.getOrDefault(ch, 0) + 1); // Increment count: if exists add 1, else default to 0 then add 1
        }

        for (char ch : str.toCharArray()) { // Iterate through string again in original order
            if (map.get(ch) == 1) { // Check if character appears exactly once
                return ch; // Return the first non-repeating character
            }
        }

        return null; // Return null if no non-repeating character found
    }

    public static void main(String[] args) {
        String input = "aabbcdde"; // Input string to test
        Character result = firstNonRepeating(input); // Call method to find first non-repeating character

        System.out.println("Input string: " + input); // Print original string
        System.out.println("First non-repeating character: " + result); // Print result (c)
    }
}
// Time Complexity: O(n) - We traverse the string twice
// Space Complexity: O(n) - HashMap stores at most n unique characters
