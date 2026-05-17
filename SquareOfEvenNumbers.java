import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquareOfEvenNumbers {

    public static void main(String[] args) {

        List<Integer> listNum = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // even square
        List<Integer> squareOfEvenNum = listNum.stream().filter(num -> num%2 ==0)
                .map(even -> even*even)
                .toList();

        System.out.println("Even square : " + squareOfEvenNum);

        //odd square
        List<Integer> squareOfOddNum = listNum.stream()
                .filter(num -> num%2 !=0)
                .map(even -> even*even)
                .toList();

        System.out.println("Odd square : " + squareOfOddNum);

    }
}
