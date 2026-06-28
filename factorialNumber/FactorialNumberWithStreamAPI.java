package factorialNumber;

import java.util.stream.IntStream;

public class FactorialNumberWithStreamAPI {
    public static void main(String[] args) {

        int factorialOfNumber = IntStream.rangeClosed(1, 5)
                .reduce(1, (a, b) -> a * b);
        int factorialOfNumber2 = IntStream.rangeClosed(1, 5)
                .reduce(1, Integer::sum);

        System.out.println("factorial of number is " + factorialOfNumber);
        System.out.println("Sum of number is " + factorialOfNumber2);
    }
}


         /* Step 1: Create an IntStream with numbers from 1 to 5 (inclusive)
             rangeClosed(start, end) generates a stream of integers from start to end, including both
             Step 2: Reduce the stream by multiplying all elements together
             reduce(identity, accumulator) - identity is the initial value (1 for multiplication)
             accumulator is a lambda that takes two parameters (a, b) and returns their product
             This effectively calculates: 1 * 1 * 2 * 3 * 4 * 5 = 120   */
// Step 3: Print the calculated factorial result