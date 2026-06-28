package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestSubsequentNumberIncreasingOrder {
    // find the longest increasing subsequence
    // Maintain a list of the smallest possible tail values for increasing subsequences of different lengths

    public static void main(String[] args) {
        int[] arr = {3, 10, 2, 1, 20};
        List<Integer> list = new ArrayList<>();

        for (int num : arr) {
            int index = Collections.binarySearch(list, num);

            if (index < 0)
                index = -(index + 1);

            if (index == list.size())
                list.add(num);
            else
                list.set(index, num);
        }
        System.out.println(list.size());
    }
}