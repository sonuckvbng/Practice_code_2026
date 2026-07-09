package basic_concept_program;

public class ReverseString {
    public static void main(String[] args) {
        String s = "Sonu Chaurasia";

        // Traditional approach using char array
        String reversed1 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed1 += s.charAt(i);
        }
        System.out.println("Traditional approach: " + reversed1);

        // Using StringBuilder
        String reversed2 = new StringBuilder(s).reverse().toString();
        System.out.println("StringBuilder: " + reversed2);

        // Using char array and swapping
        char[] charArray = s.toCharArray();
        int left = 0, right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        System.out.println("Char array swap: " + new String(charArray));

        // Using recursion
        System.out.println("Recursion: " + reverseRecursive(s));
    }

    private static String reverseRecursive(String s) {
        if (s.isEmpty()) {
            return s;
        }
        return reverseRecursive(s.substring(1)) + s.charAt(0);
    }
}
