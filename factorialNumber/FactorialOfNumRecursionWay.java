package factorialNumber;

public class FactorialOfNumRecursionWay {

    public static void main(String[] args) {
        System.out.println(factorialOfNum(5));
    }

    private static int factorialOfNum(int num) {

        if(num ==0 || num ==1 ) {
            return 1;
        }


        return num * factorialOfNum(num -1);
    }
}
        /*
        * Step 1: Base case check
        * If num is 0 or 1, factorial is 1
        * This stops the recursion from infinite loop

         * Step 2: Recursive case
         * For any other number, multiply current number with factorial of (num - 1)
         * Example: factorialOfNum(5) = 5 * factorialOfNum(4)
         *                            = 5 * 4 * factorialOfNum(3)
         *                            = 5 * 4 * 3 * factorialOfNum(2)
         *                            = 5 * 4 * 3 * 2 * factorialOfNum(1)
         *                            = 5 * 4 * 3 * 2 * 1 = 120
         */