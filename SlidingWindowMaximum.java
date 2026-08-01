import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {

    public static void main(String[] args) {

        int[] num = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= num.length - k; i++) {
            int max = num[i];

            for (int j = i; j < i + k; j++) {
                max = Math.max(max, num[j]);
            }

            result.add(max);
        }

        System.out.println("Final.: " + result);
    }
}
