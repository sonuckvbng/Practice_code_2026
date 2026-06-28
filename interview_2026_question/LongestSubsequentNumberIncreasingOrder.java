package interview_2026_question;

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
        System.out.println("Length of longest increasing subsequence: " + list.size());
        System.out.println("Tail values list: " + list);

        // Alternative approach using DP to get actual subsequence
        findLISUsingDP(arr);
    }

    private static void findLISUsingDP(int[] arr) {
        int n = arr.length;

        // dp[i] = length of LIS ending at index i
        int[] dp = new int[n];
        // parent[i] = previous index in the LIS ending at i
        int[] parent = new int[n];

        // Initialize
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            parent[i] = -1;
        }

        // Fill dp and parent arrays
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
        }

        // Find the index with maximum length
        int maxLength = 0;
        int endIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                endIndex = i;
            }
        }

        // Reconstruct the LIS by backtracking
        List<Integer> lis = new ArrayList<>();
        int current = endIndex;
        while (current != -1) {
            lis.add(arr[current]);
            current = parent[current];
        }

        // Reverse to get correct order
        Collections.reverse(lis);

        System.out.println("\n--- Using DP approach ---");
        System.out.println("Length of longest increasing subsequence: " + maxLength);
        System.out.println("Longest increasing subsequence: " + lis);
    }
}