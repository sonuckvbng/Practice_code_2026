import java.util.Arrays;
import java.util.Scanner;

public class FindTheMissingNumberFromGivenNaturalNumber {
    /*
     Given natural numbers from 1 to n with one number missing, find the missing number.
     Approach: Sum formula - sum of array elements
     Expected sum of 1 to n = n * (n + 1) / 2
     Missing number = expectedSum - actualSum

     Example:
     Input: [1, 2, 3, 4, 6, 7, 8, 9], n = 9
     Output: 5
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the range n from user
        System.out.print("Enter the value of n (max number in range 1 to n): ");
        int n = scanner.nextInt();

        // Get the array size (should be n-1 since one number is missing)
        System.out.print("Enter the size of array (should be " + (n - 1) + "): ");
        int size = scanner.nextInt();

        // Validate array size
        if (size != n - 1) {
            System.out.println("Warning: Array size should be " + (n - 1) + " for one missing number.");
        }

        // Read array elements
        int[] arr = new int[size];
        System.out.println("Enter " + size + " distinct numbers from 1 to " + n + ":");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Calculate expected sum using formula n*(n+1)/2
        int expectedSum = n * (n + 1) / 2;

        // Calculate actual sum using Stream API
        int actualSum = Arrays.stream(arr).sum();

        // Find missing number
        int missingNum = expectedSum - actualSum;

        System.out.println("Missing number: " + missingNum);
        scanner.close();
    }
}
