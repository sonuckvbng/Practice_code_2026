import java.util.Arrays;

public class FindTheMissingNumberFromGivenNaturalNumber {
    /*
     Given natural numbers from 1 to 9 with one number missing, find the missing number.
    Input:[1, 2, 3, 4, 6, 7, 8, 9]
    Output:5
     */
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 6, 7, 8, 9};
        int n = 9;
        int expectedSum = n * (n + 1) / 2;

        int sum = Arrays.stream(arr).sum();

        int missingNum = expectedSum - sum;

        System.out.println("missing umber : " + missingNum);
    }
}
