package basic_concept_program;

import java.util.Arrays;

public class checkAnagram {
    public static void main(String[] args) {
        String s1 = "geeks" , s2 = "kseeg";
        char[] c1 =s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);
        System.out.println(Arrays.equals(c1,c2) );

    }
}
