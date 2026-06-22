package factorialNumber;

import java.math.BigDecimal;
import java.util.stream.IntStream;

public class FactorialNumWIthStreamApiAndBigDecimal {

    public static void main(String[] args) {

        BigDecimal factorialOfNum = IntStream.rangeClosed(1, 5)
                .mapToObj(BigDecimal::valueOf)
                .reduce(BigDecimal.ONE, BigDecimal::multiply);

        System.out.println(factorialOfNum);
    }
}
