import java.util.Arrays;

public class FindMissingNumFromNaturalNum {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 6, 7, 8, 9};
        int n = 9;

        int expectedSum = n * (n + 1) / 2;
        int  actualSum = Arrays.stream(arr).sum();

        System.out.println("Final.: " + (expectedSum - actualSum ));
    }
}
