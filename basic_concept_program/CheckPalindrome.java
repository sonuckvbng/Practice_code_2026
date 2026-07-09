package basic_concept_program;

public class CheckPalindrome {
    public static void main(String[] args) {
        String s = "madam";

        // Traditional approach using two pointers
        boolean isPalindrome1 = isPalindromeTraditional(s);
        System.out.println("Traditional approach: " + isPalindrome1);

        // Using StringBuilder reverse
        boolean isPalindrome2 = isPalindromeStringBuilder(s);
        System.out.println("StringBuilder: " + isPalindrome2);

        // Using recursion
        boolean isPalindrome3 = isPalindromeRecursive(s);
        System.out.println("Recursion: " + isPalindrome3);

        // Using Stream API
        boolean isPalindrome4 = isPalindromeStream(s);
        System.out.println("Stream API: " + isPalindrome4);
    }

    // Traditional approach using two pointers
    private static boolean isPalindromeTraditional(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Using StringBuilder reverse
    private static boolean isPalindromeStringBuilder(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }

    // Using recursion
    private static boolean isPalindromeRecursive(String s) {
        if (s.length() <= 1) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(s.substring(1, s.length() - 1));
    }

    // Using Stream API
    private static boolean isPalindromeStream(String s) {
        String reversed = s.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (a, b) -> b + a, String::concat);
        return s.equals(reversed);
    }
}
