package EvenOrOdd;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EvenOrOddUsingStreamApi {

    public static void main(String[] args) {
        // Step 1: Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Step 2: Loop to continuously accept input until user decides to quit
        while (true) {
            // Prompt user to enter integers or 'quit' to exit
            System.out.println("Enter integers (space-separated) or 'quit' to exit:");

            // Step 3: Read the input line
            String input = scanner.nextLine().trim();

            // Check if user wants to quit
            if ("quit".equalsIgnoreCase(input)) {
                break;
            }

            // Skip empty inputs
            if (input.isEmpty()) {
                continue;
            }

            try {
                // Step 4: Process the input using Stream API
                // Stream processing chain explained in detail:
                // - Arrays.stream(input.split(" ")): Splits the input string by spaces into an array of strings,
                //   then creates a Stream<String> from that array. This allows us to process each number as a string initially.
                // - .mapToInt(Integer::parseInt): Converts each String in the stream to an int using Integer.parseInt.
                //   This transforms the Stream<String> into an IntStream, which is efficient for primitive int operations.
                // - .boxed(): Converts the IntStream back to a Stream<Integer> (Stream of Integer objects).
                //   This is necessary because Collectors.partitioningBy works with objects, not primitives.
                // - .collect(Collectors.partitioningBy(n -> n % 2 == 0)): Collects the stream into a Map<Boolean, List<Integer>>,
                //   where the key 'true' maps to a list of even numbers (n % 2 == 0), and 'false' maps to odd numbers.
                //   partitioningBy is a collector that splits the stream into two groups based on a predicate.
                Map<Boolean, List<Integer>> grouped =
                        Arrays.stream(input.split("\\s+"))  // Use \\s+ to handle multiple spaces
                                .mapToInt(Integer::parseInt)
                                .boxed()
                                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

                // Step 5: Output the results, sorted for better readability
                List<Integer> evens = grouped.get(true).stream().sorted().toList();
                List<Integer> odds = grouped.get(false).stream().sorted().toList();
                System.out.println("EVEN: " + evens);
                System.out.println("ODD: " + odds);

            } catch (NumberFormatException e) {
                // Handle invalid input
                System.out.println("Invalid input. Please enter only integers separated by spaces.");
            }
        }

        // Step 6: Close the scanner
        scanner.close();
    }
}
